import java.awt.*;


class Rectangle {
  private double xCorBottomLeftCorner;
  private double yCorBottomLeftCorner;
  private double width;
  private double height;
  private Color rectangleColor;


  public Rectangle(double xcorbottomleftcorner, double ycorbottomleftcorner, double rectanglewidth, double rectangleheight){
    xCorBottomLeftCorner = xcorbottomleftcorner;
    yCorBottomLeftCorner = ycorbottomleftcorner;
    width = rectanglewidth;
    height = rectangleheight;
  }

  public double calculatePerimeter(){
    return 2*(width+height);
  }

  public double calculateArea(){
    return width*height;
  }

  public void setColor(Color color){
    rectangleColor = color;
  }

  public void setPos(double xcorbottomleftcorner, double ycorbottomleftcorner){
    xCorBottomLeftCorner = xcorbottomleftcorner ;
    yCorBottomLeftCorner = ycorbottomleftcorner;
  }

  public void setHeight(double rectangleheight){
    height = rectangleheight;
  }

  public void setWidth(double rectanglewidth){
    width = rectanglewidth;
  }

  public Color getColor(){
    return rectangleColor;
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
