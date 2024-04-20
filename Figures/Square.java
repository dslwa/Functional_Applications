public class Square extends Figure implements Printable {
    private double a;
    Square(double a){
        if(a <= 0)
            throw new IllegalArgumentException("Error a <= 0");

        this.a = a;
    }
    @Override
    double calculatePerimeter() {
        return (4 * this.a);
    }

    @Override
    double calculateArea() {
        return this.a*this.a;
    }

    @Override
    public void printf() {
        System.out.println("==============SQUARE================");
        System.out.println("a:" + this.a);
        System.out.println("Perimeter is " + this.calculatePerimeter());
        System.out.println("Area is " + this.calculateArea());
    }
}
