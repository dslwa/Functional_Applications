import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Toyota", "Supra", ItemCondition.NEW, 500000, 2024, 0, 3.0);
        Vehicle v2 = new Vehicle("Honda", "Civic", ItemCondition.NEW, 30000, 2024, 0, 1.8);
        Vehicle v3 = new Vehicle("Ford", "Mustang", ItemCondition.NEW, 60000, 2024, 0, 5.0);
        Vehicle v4 = new Vehicle("BMW", "X5", ItemCondition.DAMAGED, 80000, 2024, 0, 4.4);
        Vehicle v5 = new Vehicle("Mercedes-Benz", "E-Class", ItemCondition.NEW, 70000, 2024, 0, 3.0);
        Vehicle v6 = new Vehicle("Audi", "A4", ItemCondition.NEW, 45000, 2024, 0, 2.0);
        Vehicle v7 = new Vehicle("Volkswagen", "Golf", ItemCondition.NEW, 35000, 2024, 0, 1.5);
        Vehicle v8 = new Vehicle("Tesla", "Model S", ItemCondition.NEW, 90000, 2024, 0, 0);
        Vehicle v9 = new Vehicle("Lamborghini", "Huracan", ItemCondition.NEW, 250000, 2024, 0, 5.2);
        Vehicle v10 = new Vehicle("Porsche", "911", ItemCondition.NEW, 200000, 2024, 0, 3.0);
        Vehicle v11 = new Vehicle("BMW", "X5", ItemCondition.DAMAGED, 80000, 2024, 0, 4.4);
        Vehicle v12 = new Vehicle("BMW", "M3", ItemCondition.DAMAGED, 90000, 2024, 0, 3.0);
        Vehicle v13 = new Vehicle("BMW", "X3", ItemCondition.DAMAGED, 70000, 2024, 0, 2.0);
        CarShowroom c1 = new CarShowroom("RichRick",10);
        c1.addProduct(v1);
        c1.addProduct(v2);
        c1.addProduct(v3);
        c1.addProduct(v4);
        c1.addProduct(v5);
        c1.addProduct(v6);
        c1.addProduct(v7);
        c1.addProduct(v8);
        c1.addProduct(v9);
        c1.summary();
        c1.removeProduct(v2);
        c1.summary();
        Vehicle searched = c1.search(v1);
        System.out.println("Searched:" + searched.getName());


        CarShowroom c2 = new CarShowroom("C2", 10);
        c2.addProduct(v10);
        c2.addProduct(v11);
        c2.addProduct(v12);
        c2.addProduct(v4);
        c2.addProduct(v1);
        c2.summary();
        System.out.println(" ");
        List<Vehicle> res = c2.searchPartial("BMW");
        for(Vehicle v: res){
            v.print();
            System.out.println("");
        }
        System.out.println(c2.countByCondition(ItemCondition.DAMAGED));

        c2.sortByName();
        c2.max();


        CarShowroomContainer continer1 = new CarShowroomContainer();
        continer1.addCenter(c2);
        continer1.addCenter(c1);
        continer1.addCenter("Max",10);
        continer1.removeCenter("C2");
        continer1.summary();

        List<CarShowroom> r = continer1.findEmpty();
        System.out.println("Empty showrooms:");
        for(CarShowroom c: r){
            System.out.println(c.getName());
        }
    }
}
