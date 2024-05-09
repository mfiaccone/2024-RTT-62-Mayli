package Slides_303_9_Inheritance;

public abstract class Shape {

    public static double area;

    private String name;

    public Shape() {

    }

    public Shape(String name) {
        this.name = name;
    }

    protected void printName() {
        System.out.println("The name of the shape is" + name);
    }

    public abstract double calculateArea();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
