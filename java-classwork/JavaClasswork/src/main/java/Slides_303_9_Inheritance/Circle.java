package Slides_303_9_Inheritance;

public class Circle extends Shape{

    private double diameter;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double calculateArea() {
        area = 456;
        return Math.PI * (diameter / 2) * (diameter / 2);
    }

}
