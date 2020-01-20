import java.awt.*;

class Triangle{
    private double xCorBottomLeftCorner;
    private double yCorBottomLeftCorner;
    private double width;
    private double height;
    private Color triangleColor;

    public Triangle(double xcorbottomleftcorner, double ycorbottomleftcorner, double trianglewidth, double triangleheight){
      xCorBottomLeftCorner = xcorbottomleftcorner;
      yCorBottomLeftCorner = ycorbottomleftcorner;
      width = trianglewidth;
      height = triangleheight;
    }
    // finds perimeter by splitting isosceles into two right triangles, finding hypotenuses, then adding width. Formula: P = 2a + b.
    public double calculatePerimeter(){
      double hypotenuse = Math.sqrt(((width/2*width/2) + height*height));
      return hypotenuse*2+width;
    }
    // finds area using formula: A = 1/2*a*b.
    public double calculateArea(){
      return width*height/2;
    }

    public void setColor(Color color){
      triangleColor = color;
    }

    public void setPos(double xcorbottomleftcorner, double ycorbottomleftcorner){
      xCorBottomLeftCorner = xcorbottomleftcorner;
      yCorBottomLeftCorner = ycorbottomleftcorner;
    }

    public void setHeight(double triangleheight){
      height = triangleheight;
    }

    public void setWidth(double trianglewidth){
      trianglewidth = width;
    }

    public Color getColor(){
      return triangleColor;
    }

    public double getXPos(){
      return xCorBottomLeftCorner;
    }

    public double getYPos(){
      return yCorBottomLeftCorner;
    }

    public double getHeight(){
      return height;
    }

    public double getWidth(){
      return width;
    }
}
