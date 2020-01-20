import java.awt.*;
import java.util.Scanner;

// creates fractals out of circles, triangles, and rectangles;
class Fractal{
  static double totalArea;

  // creates circle fractal through recursion.
  public static double circleFractal(Canvas drawing, double radius, double xcor, double ycor){
    Circle circleToFractal = new Circle(xcor,ycor,radius);
    circleToFractal.setColor(Color.RED);
    // base case.
    if (radius < 1){
      return -1;
    }
    // computes area each time a new circle is drawn.
    totalArea += circleToFractal.calculateArea();
    drawing.drawShape(circleToFractal);
    // recursive calls. Each call places circles on either left,right,top,or bottom of existing circle. The two circles will just be touching.
    circleFractal(drawing, radius/2, xcor + 2*radius - radius/2, ycor);
    circleFractal(drawing, radius/2, xcor - 2*radius + radius/2 , ycor);
    circleFractal(drawing, radius/2, xcor, ycor + 2*radius - radius/2);
    circleFractal(drawing, radius/2, xcor, ycor - 2*radius + radius/2);

    return totalArea;
  }
  // creates triange fractal through recursion.
  public static double triangleFractal(Canvas drawing, double xcorbottomleftcorner, double ycorbottomleftcorner, double width, double height){

    Triangle triangleToFractal = new Triangle(xcorbottomleftcorner, ycorbottomleftcorner, width, height);
    triangleToFractal.setColor(Color.BLUE);
    // base case.
    if (height < 1){
      return -1;
    }
    // computes area each time a new triangle is drawn.
    totalArea += triangleToFractal.calculateArea();
    drawing.drawShape(((triangleToFractal)));
    // recursive calls which draw triangles on each corner of an existing triangle. Each call draws different corner.
    triangleFractal(drawing, xcorbottomleftcorner - width/2, ycorbottomleftcorner, width/2, height/2);
    triangleFractal(drawing, xcorbottomleftcorner + width, ycorbottomleftcorner, width/2, height/2);
    triangleFractal(drawing, xcorbottomleftcorner + width/4, ycorbottomleftcorner - height, width/2, height/2);
    return totalArea;
  }

  // creates rectangle fractal using recursion.
  public static double rectangleFractal(Canvas drawing, double xcorbottomleftcorner, double ycorbottomleftcorner, double width, double height){
    Rectangle rectangleToFractal = new Rectangle(xcorbottomleftcorner, ycorbottomleftcorner, width, height);
    rectangleToFractal.setColor(Color.GREEN);
    // base case.
    if (width < 1){
      return -1;
    }
    // computes area each time a new rectangle is drawn.
    totalArea += rectangleToFractal.calculateArea();
    drawing.drawShape(rectangleToFractal);
    // recursive calls which draw rectangles on each corner of an existing rectangle. Each call draws different corner.
    rectangleFractal(drawing, xcorbottomleftcorner - width/2,  ycorbottomleftcorner - height/2, width/2, height/2);
    rectangleFractal(drawing, xcorbottomleftcorner + width,  ycorbottomleftcorner + height, width/2, height/2);
    rectangleFractal(drawing, xcorbottomleftcorner - width/2,  ycorbottomleftcorner + height, width/2, height/2);
    rectangleFractal(drawing, xcorbottomleftcorner + width,  ycorbottomleftcorner - height/2, width/2, height/2);

    return totalArea;
  }

  public static void main(String[]args){
    System.out.println("Pick a shape to fractal: circle, triangle, rectangle: ");
    Scanner input = new Scanner(System.in);
    String userInput = input.nextLine();

    if(userInput.equals("circle")){
      Canvas drawing = new Canvas(800,800);
      System.out.println("Total area: " + circleFractal(drawing,150,400,400));
    }
    else if(userInput.equals("triangle")){
      Canvas drawing = new Canvas(800,800);
      System.out.println("Total area: " + triangleFractal(drawing,300,600,150,225));
    }

    else if(userInput.equals("rectangle")){
      Canvas drawing = new Canvas(800,800);
      System.out.println("Total area: " + rectangleFractal(drawing,400,400,100,100));
    }
    else{
      System.out.println("Invalid input.");
    }
  }
}
