/*
   Course: CS 45500
   Name: Daniel Briseno
   Email: dbriseno@pnw.edu
   Assignment: 2
*/

import renderer.scene.*;
import renderer.scene.primitives.*;

import java.awt.Color;

/**
   A three-dimensional wireframe model of the letter P.

  1______________ 2
   |             \
   |   8_______ 9 \ 3
   |    |      |  |
   |    |______|  |
   |   11     10  / 4
   |   6_________/
   |    |         5
   |____|
  0     7
*/
public class P extends Model
{
   /**
      The letter P.
   */
   public P()
   {
      super("P");

      // Create the front face vertices.
      addVertex(new Vertex(0.00, 0.00, 0.0),
                new Vertex(0.00, 1.00, 0.0),
                new Vertex(0.75, 1.00, 0.0),
                new Vertex(1.00, 0.8,  0.0),
                new Vertex(1.00, 0.6,  0.0),
                new Vertex(0.75, 0.4,  0.0),
                new Vertex(0.25, 0.4,  0.0),
                new Vertex(0.25, 0.0,  0.0));

      addVertex(new Vertex(0.25, 0.8,  0.0),
                new Vertex(0.75, 0.8,  0.0),
                new Vertex(0.75, 0.6,  0.0),
                new Vertex(0.25, 0.6,  0.0));

      // Create the back face vertices.
      addVertex(new Vertex(0.00, 0.00, -0.25),
                new Vertex(0.00, 1.00, -0.25),
                new Vertex(0.75, 1.00, -0.25),
                new Vertex(1.00, 0.80, -0.25),
                new Vertex(1.00, 0.60, -0.25),
                new Vertex(0.75, 0.40, -0.25),
                new Vertex(0.25, 0.40, -0.25),
                new Vertex(0.25, 0.00, -0.25));

      addVertex(new Vertex(0.25, 0.80, -0.25),
                new Vertex(0.75, 0.80, -0.25),
                new Vertex(0.75, 0.60, -0.25),
                new Vertex(0.25, 0.60, -0.25));


      // Create the Color objects.
      addColor(Color.green, Color.red, Color.magenta);



      // Create the front face line segments
      // (you need to add the Color indices!).
      // Front outer boundary 
      addPrimitive(new LineSegment(0, 1, 0, 0),
                   new LineSegment(1, 2, 2, 2),
                   new LineSegment(2, 3, 2, 2),
                   new LineSegment(3, 4,1, 1),
                   new LineSegment(4, 5, 2, 2),
                   new LineSegment(5, 6, 2,2),
                   new LineSegment(6, 7, 2, 2),
                   new LineSegment(7, 0, 2, 2));

      // Front inner boundary
      addPrimitive(new LineSegment( 8,  9, 2, 2),
                   new LineSegment( 9, 10, 2, 2),
                   new LineSegment(10, 11, 2, 2),
                   new LineSegment(11,  8, 2, 2));

      // Create the back face line segments.
      // Back outer boundary.
      addPrimitive(new LineSegment(12, 13, 0, 0),
                   new LineSegment(13, 14, 2, 2),
                   new LineSegment(14, 15, 2, 2),
                   new LineSegment(15,16, 1, 1),
                   new LineSegment(16,17,2,2),
                   new LineSegment(17,18, 2,2),
                   new LineSegment(18, 19, 2, 2),
                   new LineSegment(19,12,2,2 ));

      // Back inner opening.
      addPrimitive(new LineSegment(20, 21, 2, 2),
                   new LineSegment(21, 22, 2, 2),
                   new LineSegment(22, 23, 2, 2),
                   new LineSegment(23, 20, 2, 2));

            // Connect the outer boundaries.
      addPrimitive(new LineSegment(0, 12, 0, 0),
                   new LineSegment(1, 13, 0, 0),
                   new LineSegment(2, 14, 2, 2),
                   new LineSegment(3, 15, 1, 1),
                   new LineSegment(4, 16, 1, 1),
                   new LineSegment(5, 17, 2, 2),
                   new LineSegment(6, 18, 2, 2),
                   new LineSegment(7, 19, 2, 2));

      // Connect the inner openings.
      addPrimitive(new LineSegment( 8, 20, 2, 2),
                   new LineSegment( 9, 21, 2, 2),
                   new LineSegment(10, 22, 2, 2),
                   new LineSegment(11, 23, 2, 2));

      



      // Create the front face to back face line segments.


   }
}
