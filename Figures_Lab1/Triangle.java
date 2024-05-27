public class Triangle extends Figure implements Printable{
    private double a;
    private double b;
    private double c;
    Triangle(double a, double b, double c){
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("Invalid data about triangle");
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    double calculateArea() {
        double p = this.calculatePerimeter() / 2;
        return Math.sqrt((p*(p-this.a)*(p-this.b)*(p-this.c)));
    }

    @Override
    double calculatePerimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    public void printf() {
        System.out.println("=============TRIANGLE===============");
        System.out.println("A: " + this.a);
        System.out.println("B: " + this.b);
        System.out.println("C: " + this.c);
        System.out.println("Perimeter " + this.calculatePerimeter());
        System.out.println("Area: " + this.calculateArea());
    }
}
