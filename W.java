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
   A three-dimensional wireframe model of the letter W.

   Front vertex numbering (schematic; coordinates below are exact):
  0---1       3---4       6---7
   \   \     /     \     /   /
    \   \   /       \   /   /
     \   \ /   10    \ /   /
      \   2   /  \    5   /
       \     /    \      /
        12--11     9----8

   The front outline follows 0 through 12, then closes back to 0.
   Back vertices have the same numbering plus 13.
*/
public class W extends Model
{
   /**
      The letter W.
   */
   public W()
   {
      super("W");

      // Create the front face vertices.
      addVertex(new Vertex(0.00, 1.00, 0.00), // 0
                new Vertex(0.20, 1.00, 0.00), // 1
                new Vertex(0.30, 0.45, 0.00), // 2
                new Vertex(0.40, 1.00, 0.00), // 3
                new Vertex(0.60, 1.00, 0.00), // 4
                new Vertex(0.70, 0.45, 0.00), // 5
                new Vertex(0.80, 1.00, 0.00), // 6
                new Vertex(1.00, 1.00, 0.00), // 7
                new Vertex(0.80, 0.00, 0.00), // 8
                new Vertex(0.60, 0.00, 0.00), // 9
                new Vertex(0.50, 0.55, 0.00), // 10
                new Vertex(0.40, 0.00, 0.00), // 11
                new Vertex(0.20, 0.00, 0.00)); // 12

      // Create the back face vertices.
      addVertex(new Vertex(0.00, 1.00, -0.25), // 13
                new Vertex(0.20, 1.00, -0.25), // 14
                new Vertex(0.30, 0.45, -0.25), // 15
                new Vertex(0.40, 1.00, -0.25), // 16
                new Vertex(0.60, 1.00, -0.25), // 17
                new Vertex(0.70, 0.45, -0.25), // 18
                new Vertex(0.80, 1.00, -0.25), // 19
                new Vertex(1.00, 1.00, -0.25), // 20
                new Vertex(0.80, 0.00, -0.25), // 21
                new Vertex(0.60, 0.00, -0.25), // 22
                new Vertex(0.50, 0.55, -0.25), // 23
                new Vertex(0.40, 0.00, -0.25), // 24
                new Vertex(0.20, 0.00, -0.25)); // 25

      // Color indices: 0 = green, 1 = red, 2 = magenta.
      addColor(Color.green, Color.red, Color.magenta);

      // Create the front face line segments.
      addPrimitive(new LineSegment(0, 1, 0, 0),
                   new LineSegment(1, 2, 2, 2),
                   new LineSegment(2, 3, 2, 2),
                   new LineSegment(3, 4, 0, 0),
                   new LineSegment(4, 5, 2, 2),
                   new LineSegment(5, 6, 2, 2),
                   new LineSegment(6, 7, 0, 0),
                   new LineSegment(7, 8, 2, 2),
                   new LineSegment(8, 9, 1, 1),
                   new LineSegment(9, 10, 2, 2),
                   new LineSegment(10, 11, 2, 2),
                   new LineSegment(11, 12, 1, 1),
                   new LineSegment(12, 0, 2, 2));

      // Create the back face line segments.
      addPrimitive(new LineSegment(13, 14, 0, 0),
                   new LineSegment(14, 15, 2, 2),
                   new LineSegment(15, 16, 2, 2),
                   new LineSegment(16, 17, 0, 0),
                   new LineSegment(17, 18, 2, 2),
                   new LineSegment(18, 19, 2, 2),
                   new LineSegment(19, 20, 0, 0),
                   new LineSegment(20, 21, 2, 2),
                   new LineSegment(21, 22, 1, 1),
                   new LineSegment(22, 23, 2, 2),
                   new LineSegment(23, 24, 2, 2),
                   new LineSegment(24, 25, 1, 1),
                   new LineSegment(25, 13, 2, 2));

      // Connect each front vertex to its matching back vertex.
      addPrimitive(new LineSegment(0, 13, 0, 0),
                   new LineSegment(1, 14, 0, 0),
                   new LineSegment(2, 15, 2, 2),
                   new LineSegment(3, 16, 0, 0),
                   new LineSegment(4, 17, 0, 0),
                   new LineSegment(5, 18, 2, 2),
                   new LineSegment(6, 19, 0, 0),
                   new LineSegment(7, 20, 0, 0),
                   new LineSegment(8, 21, 1, 1),
                   new LineSegment(9, 22, 1, 1),
                   new LineSegment(10, 23, 2, 2),
                   new LineSegment(11, 24, 1, 1),
                   new LineSegment(12, 25, 1, 1));
   }
}
