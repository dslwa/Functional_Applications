public class Circle extends Figure implements Printable{
    private double r;
    Circle(double r){
        if(r < 0)
            throw new IllegalArgumentException("Error: r <= 0");
        this.r = r;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * this.r;
    }

    @Override
    double calculateArea() {
        return Math.PI * (this.r * this.r);
    }

    @Override
    public void printf() {
        System.out.println("==============CIRCLE================");
        System.out.println("R: " + this.r);
        System.out.println("Perimeter: " + this.calculatePerimeter());
        System.out.println("Area: " + this.calculateArea());
    }
}
