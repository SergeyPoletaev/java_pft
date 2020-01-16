package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    // Hello, world!
    hello("world");

    // Площадь квадрата и прямоугольника
    Square s = new Square(5);
    System.out.println("площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(6,4);
    System.out.println("площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    // Расстояние между двумя точками
    double x1 = 4;
    double y1 = 6;
    double x2 = -3;
    double y2 = 8;

    System.out.println("расстояние между точками p1 и p2 = " + distance(x1, y1, x2, y2));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  }

}
