public class RectangleDemo {

    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(10);
        rectangle.setHeight(20);

        System.out.println("Expected area: 200");
        System.out.println("Actual area: " + rectangle.getArea());
    }
}
