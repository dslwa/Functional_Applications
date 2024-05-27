import java.util.*;
import java.lang.String;

public class CarShowroom{
    private String name;
    private List<Vehicle> cars = new ArrayList<>();
    private Integer maxCapacity;
    private Integer size = 0;
    private HashMap<Vehicle, Integer> qnt = new HashMap<>();
    public CarShowroom(String n, Integer m){
        this.name = n;
        this.maxCapacity = m;
        this.size = cars.size();
    }
    public Integer getSize(){
        return this.size;
    }
    public Integer getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getCars() {
        return cars;
    }

    public void setCars(List<Vehicle> cars) {
        this.cars = cars;
    }

    public void addProduct(Vehicle object){
        if(size >= maxCapacity){
            System.err.println("Car showroom is full");
            return;
        }
        boolean flag = false;
        for(Vehicle v: cars) {
            if (object.getName().compareTo(v.getName()) == 0) {
                flag = true;
                break;
            }
        }
        if(!flag){
            cars.add(object);
            qnt.put(object, 1);
            size++;
        }
        else{
            qnt.put(object, qnt.get(object) + 1);
            size++;
        }
    }

    public void getProduct(Vehicle object){
        boolean flag = false;
        for(Vehicle v: cars){
            if(qnt.get(object) > 1){
                flag = true;
                break;
            }
        }
        if(flag){
            qnt.put(object, qnt.get(object) - 1);
            size--;
        }
        else{
            cars.remove(object);
            qnt.put(object, qnt.get(object) - 1);
            size--;
        }
    }

    public void removeProduct(Vehicle object){
        Integer dcm =  qnt.get(object);
        cars.remove(object);
        size -= dcm;
    }

    public Vehicle search(Vehicle object) {
        Vehicle res = null;
        for (Vehicle v : cars) {
            if (v.getName().compareTo(object.getName()) == 0) {
                res = v;
                break;
            }
        }
        if(res == null){
            System.err.println("Car does not exist in showroom");
        }
        return res;
    }

    public List<Vehicle> searchPartial(String fragment){
        List<Vehicle> res = new ArrayList<>();
        for(Vehicle v: cars) {
            if (v.getName().contains(fragment)){
                res.add(v);
            }
        }
        return res;
    }

    public Integer countByCondition(ItemCondition a){
        Integer counter = 0;
        for(Vehicle v: cars){
            if(v.getCondition() == a){
                counter++;
            }
        }
        return counter;
    }
    public void displayHashMap(){
        System.out.println("Vehicle Quantities:");
        for (Map.Entry<Vehicle, Integer> entry : qnt.entrySet()) {
            Vehicle vehicle = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(vehicle.getName() + ": " + quantity);
        }
    }

    public void sortByName(){
        cars.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for(Vehicle v: cars){
            v.print();
            System.out.println();
        }
    }
    public void max() {
        Map.Entry<Vehicle, Integer> maxEntry = Collections.max(qnt.entrySet(), Comparator.comparing(Map.Entry::getValue));
        System.out.print("Max:");
        maxEntry.getKey().print();
    }


    public void summary(){
        System.out.println("Car showroom name:" + this.getName());
        System.out.println("Capacity:" + this.getMaxCapacity());
        for(Vehicle v: cars){
            v.print();
            System.out.println("Quantity: " + qnt.get(v));
        }
    }

}
