public class Prism implements Printable {
    private Figure base;
    private double height;

    Prism(Figure b, double h){
        if(h <= 0)
            throw new IllegalArgumentException("Error h < 0");

        this.base = b;
        this.height = h;
    }

    public double calculateSurfaceArea() {
        return 2 * base.calculateArea() + base.calculatePerimeter() * height;
    }

    public double calculateVolume() {
        return base.calculateArea() * height;
    }

    @Override
    public void printf() {
        System.out.println("===============PRISM=================");
        System.out.println("Height: " + this.height);
        System.out.println("Perimeter: " + this.base.calculatePerimeter());
        System.out.println("Area: " + this.base.calculateArea());
        System.out.println("Surface Area: " + this.calculateSurfaceArea());
        System.out.println("Volume: " + this.calculateVolume());

    }
}
