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

    Point p1 = new Point(3,8);
    Point p2 = new Point(-4,5);
    System.out.println("расстояние между точками p1 и p2 = " + p1.distance(p2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
}
