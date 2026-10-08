/*
   Course: CS 45500
   Name: Daniel Briseno
   Email: dbriseno@pnw.edu
   Assignment: 2
*/

import renderer.scene.*;
import renderer.scene.util.DrawSceneGraph;
import renderer.pipeline.*;
import renderer.framebuffer.*;

import java.awt.Color;

/**
 * Create the frames for an animation
 * of the letters P, N, and W.
 */
public class Hw2 {
   public static void main(String[] args) {
      // Create a FrameBuffer to render our scene into.
      final int width = 900;
      final int height = 900;
      final FrameBuffer fb = new FrameBuffer(width, height, Color.black);

      final Scene scene = new Scene();

      // Create the Models and give them an initial location.
      final Model p = new P();
      final Model n = new N();
      final Model w = new W();

      final Position pPosition = new Position(p, new Vector(-1.5, -0.5, -1.5));

      final Position nPosition = new Position(n, new Vector(-0.5, -0.5, -1.5));

      final Position wPosition = new Position(w, new Vector(0.5, -0.5, -1.5));

      // Share each Model with a second Position; do not create more Models.
      // The original letters move backward, and these copies move upward.
      final Position pCopy = new Position(p, "P upper copy");
      final Position nCopy = new Position(n, "N upper copy");
      final Position wCopy = new Position(w, "W upper copy");
      pCopy.visible = false;
      nCopy.visible = false;
      wCopy.visible = false;

      scene.addPosition(pPosition, nPosition, wPosition, pCopy, nCopy, wCopy);

      // If you need to, print the Scene data structure to the console.
      // This can help you check that your models and scene make sense.
      // System.out.println( scene );

      // Use GraphViz to draw a picture of the Scene data structure.
      DrawSceneGraph.draw(scene, "Hw2_SG");

      Rasterize.doClipping = true;
      Rasterize.doGamma = false;
      // scene.debug = true; // Uncomment this line for debugging output.
      // Rasterize.debug = true; // Uncomment this line for more debugging output.

      // Render frames 000 through 299. Move only after saving the current frame.
      for (int i = 0; i < 300; ++i) {
         fb.clearFB();
         Pipeline.render(scene, fb);
         fb.dumpFB2File(String.format("Hw2_frame%03d.ppm", i));
         fb.dumpFB2File(String.format("Hw2_frame%03d.png", i), "png");

         // Start each duplicate at its original's current location.
         // It becomes visible in the next frame as the two copies separate.
         if (i == 0) {
            pCopy.translate(pPosition.getTranslation());
            pCopy.visible = true;
         } else if (i == 100) {
            nCopy.translate(nPosition.getTranslation());
            nCopy.visible = true;
         } else if (i == 200) {
            wCopy.translate(wPosition.getTranslation());
            wCopy.visible = true;
         }

         // First 100 updates: P passes N and W, changing P N W to N W P.
         if (i < 25) {
            move(pPosition, 0, 0, -1.0 / 25);
            move(pCopy, 0, 1.0 / 25, 0);
         } else if (i < 75) {
            move(pPosition, 2.0 / 50, 0, 0);
            move(pCopy, 2.0 / 50, 0, 0);
            move(nPosition, -1.0 / 50, 0, 0);
            move(wPosition, -1.0 / 50, 0, 0);
         } else if (i < 100) {
            move(pPosition, 0, 0, 1.0 / 25);
            move(pCopy, 0, -1.0 / 25, 0);
         }

         // Second 100 updates: N passes W and P, changing N W P to W P N.
         else if (i < 125) {
            move(nPosition, 0, 0, -1.0 / 25);
            move(nCopy, 0, 1.0 / 25, 0);
         } else if (i < 175) {
            move(nPosition, 2.0 / 50, 0, 0);
            move(nCopy, 2.0 / 50, 0, 0);
            move(wPosition, -1.0 / 50, 0, 0);
            move(pPosition, -1.0 / 50, 0, 0);
         } else if (i < 200) {
            move(nPosition, 0, 0, 1.0 / 25);
            move(nCopy, 0, -1.0 / 25, 0);
         }

         // Last 100 updates: W passes P, then N, returning to P N W.
         else if (i < 225) {
            move(wPosition, 0, 0, -1.0 / 25);
            move(wCopy, 0, 1.0 / 25, 0);
            move(pPosition, 0, -1.0 / 25, 0);
            move(nPosition, 0, -1.0 / 25, 0);
         } else if (i < 250) {
            move(wPosition, 1.0 / 25, 0, 0);
            move(wCopy, 1.0 / 25, 0, 0);
            move(pPosition, -1.0 / 25, 0, 0);
         } else if (i < 275) {
            move(wPosition, 1.0 / 25, 0, 0);
            move(wCopy, 1.0 / 25, 0, 0);
            move(nPosition, -1.0 / 25, 0, 0);
         } else {
            move(pPosition, 0, 1.0 / 25, 0);
            move(nPosition, 0, 1.0 / 25, 0);
            move(wPosition, 0, 0, 1.0 / 25);
            move(wCopy, 0, -1.0 / 25, 0);
         }

         // Each duplicate has rejoined its original after 100 updates.
         if (i == 99) {
            pCopy.visible = false;
         } else if (i == 199) {
            nCopy.visible = false;
         } else if (i == 299) {
            wCopy.visible = false;
         }
      }
   }

   /**
    * Move relative to the current translation without changing model vertices.
    */
   private static void move(Position position, double dx, double dy, double dz) {
      position.translate(position.getTranslation().plus(new Vector(dx, dy, dz)));
   }
}
