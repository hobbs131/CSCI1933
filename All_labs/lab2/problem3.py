import math

class Circle():

    def __init__(self,radius):
        self.__radius = radius
    def getRadius(self):
        return self.__radius

    def setRadius(self,newRadius):
        newRadius = self.__newRadius

    def getArea(self):
        return math.pi*self.__radius*self.__radius

    def getDiameter(self):
        return self.__radius*2

    def getCircumference(self):
        return 2*math.pi*self.__radius

    def __eq__(self, otherRadius):
        if self.__radius == otherRadius:
            return True
        else:
            return False

def main():
    newCircle = Circle(8)
    secondCircle = Circle(10)
    
    print("")
    print("First circle:")
    print("Area: ", newCircle.getArea())
    print("Diameter: ", newCircle.getDiameter())
    print("Circumference", newCircle.getCircumference())

    print("")
    print("Second Circle:")
    print("Area: ", secondCircle.getArea())
    print("Diameter: ", secondCircle.getDiameter())
    print("Circumference", secondCircle.getCircumference())
    print("")

    if newCircle.__eq__(secondCircle.getRadius()) == True:
        print("The circles are the same")
    else:
        print("The circles are not the same")

if __name__ == '__main__':
    main()
