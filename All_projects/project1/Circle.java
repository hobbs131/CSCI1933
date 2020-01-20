import java.awt.*;

class Circle{
  private double xPosition;
  private double yPosition;
  private double radius;
  private Color circleColor;



    public Circle(double xposition,double yposition, double circleRadius){
      xPosition = xposition;
      yPosition = yposition;
      radius = circleRadius;
    }

    public double calculatePerimeter(){
      return Math.PI*2*radius;
    }

    public double calculateArea(){
      return Math.PI*radius*radius;
    }

    public void setColor(Color color){
      circleColor = color;
    }

    public void setPos(double xposition, double yposition){
      xPosition = xposition;
      yPosition = yposition;
    }

    public void setRadius(double circleRadius){
      radius = circleRadius;
    }

    public Color getColor(){
      return circleColor;
    }

    public double getXPos(){
      return xPosition;
    }

    public double getYPos(){
      return yPosition;
    }

    public double getRadius(){
      return radius;
    }
}
