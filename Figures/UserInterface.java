import java.util.Scanner;
public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Choose a shape:");
            System.out.println("1. Triangle");
            System.out.println("2. Square");
            System.out.println("3. Circle");
            System.out.println("4. Prism");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createTriangle();
                    break;
                case 2:
                    createSquare();
                    break;
                case 3:
                    createCircle();
                    break;
                case 4:
                    createPrism();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void createTriangle() {
        System.out.println("Enter the lengths of the triangle sides:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        try {
            Triangle triangle = new Triangle(a, b, c);
            triangle.calculateArea();
            triangle.printf();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createSquare() {
        System.out.println("Enter the length of the square side:");
        double a = scanner.nextDouble();

        try {
            Square square = new Square(a);
            square.calculatePerimeter();
            square.calculateArea();
            square.printf();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createCircle() {
        System.out.println("Enter the radius of the circle:");
        double r = scanner.nextDouble();

        try {
            Circle circle = new Circle(r);
            circle.calculatePerimeter();
            circle.calculateArea();
            circle.printf();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createPrism() {
        System.out.println("Choose a base shape for the prism:");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");

        int baseChoice = scanner.nextInt();
        switch (baseChoice) {
            case 1:
                createTrianglePrism();
                break;
            case 2:
                createSquarePrism();
                break;
            case 3:
                createCirclePrism();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void createTrianglePrism() {
        System.out.println("Enter the lengths of the triangle sides:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.println("Enter the height of the prism:");
        double height = scanner.nextDouble();

        try {
            Triangle baseTriangle = new Triangle(a, b, c);
            Prism prism = new Prism(baseTriangle, height);
            prism.printf();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createSquarePrism() {
        System.out.println("Enter the length of the square side:");
        double a = scanner.nextDouble();

        System.out.println("Enter the height of the prism:");
        double height = scanner.nextDouble();

        try {
            Square baseSquare = new Square(a);
            Prism prism = new Prism(baseSquare, height);
            prism.printf();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createCirclePrism() {
        System.out.println("Enter the radius of the circle:");
        double r = scanner.nextDouble();

        System.out.println("Enter the height of the prism:");
        double height = scanner.nextDouble();

        try {
            Circle baseCircle = new Circle(r);
            Prism prism = new Prism(baseCircle, height);
            prism.printf();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}

