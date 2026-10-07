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
   A three-dimensional wireframe model of the letter N.

   Front vertex numbering (schematic; coordinates below are exact):
  1----2          4----5
  |     \         |    |
  |      \        |    |
  |       \       |    |
  |    8   \------3    |
  |    |\              |
  |    | \             |
  |    |  \            |
  0----9   \------7----6

   The front outline follows 0 through 9, then closes back to 0.
   Back vertices have the same numbering plus 10.
*/
public class N extends Model
{
   /**
      The letter N.
   */
   public N()
   {
      super("N");

      // Create the front face vertices.
      addVertex(new Vertex(0.00, 0.00, 0.00), // 0
                new Vertex(0.00, 1.00, 0.00), // 1
                new Vertex(0.25, 1.00, 0.00), // 2
                new Vertex(0.75, 0.50, 0.00), // 3
                new Vertex(0.75, 1.00, 0.00), // 4
                new Vertex(1.00, 1.00, 0.00), // 5
                new Vertex(1.00, 0.00, 0.00), // 6
                new Vertex(0.75, 0.00, 0.00), // 7
                new Vertex(0.25, 0.50, 0.00), // 8
                new Vertex(0.25, 0.00, 0.00)); // 9

      // Create the back face vertices.
      addVertex(new Vertex(0.00, 0.00, -0.25), // 10
                new Vertex(0.00, 1.00, -0.25), // 11
                new Vertex(0.25, 1.00, -0.25), // 12
                new Vertex(0.75, 0.50, -0.25), // 13
                new Vertex(0.75, 1.00, -0.25), // 14
                new Vertex(1.00, 1.00, -0.25), // 15
                new Vertex(1.00, 0.00, -0.25), // 16
                new Vertex(0.75, 0.00, -0.25), // 17
                new Vertex(0.25, 0.50, -0.25), // 18
                new Vertex(0.25, 0.00, -0.25)); // 19

      // Color indices: 0 = green, 1 = red, 2 = magenta.
      addColor(Color.green, Color.red, Color.magenta);

      // Create the front face line segments.
      addPrimitive(new LineSegment(0, 1, 0, 0),
                   new LineSegment(1, 2, 0, 0),
                   new LineSegment(2, 3, 2, 2),
                   new LineSegment(3, 4, 1, 1),
                   new LineSegment(4, 5, 1, 1),
                   new LineSegment(5, 6, 1, 1),
                   new LineSegment(6, 7, 1, 1),
                   new LineSegment(7, 8, 2, 2),
                   new LineSegment(8, 9, 0, 0),
                   new LineSegment(9, 0, 0, 0));

      // Create the back face line segments.
      addPrimitive(new LineSegment(10, 11, 0, 0),
                   new LineSegment(11, 12, 0, 0),
                   new LineSegment(12, 13, 2, 2),
                   new LineSegment(13, 14, 1, 1),
                   new LineSegment(14, 15, 1, 1),
                   new LineSegment(15, 16, 1, 1),
                   new LineSegment(16, 17, 1, 1),
                   new LineSegment(17, 18, 2, 2),
                   new LineSegment(18, 19, 0, 0),
                   new LineSegment(19, 10, 0, 0));

      // Connect each front vertex to its matching back vertex.
      addPrimitive(new LineSegment(0, 10, 0, 0),
                   new LineSegment(1, 11, 0, 0),
                   new LineSegment(2, 12, 0, 0),
                   new LineSegment(3, 13, 1, 1),
                   new LineSegment(4, 14, 1, 1),
                   new LineSegment(5, 15, 1, 1),
                   new LineSegment(6, 16, 1, 1),
                   new LineSegment(7, 17, 1, 1),
                   new LineSegment(8, 18, 0, 0),
                   new LineSegment(9, 19, 0, 0));
   }
}
