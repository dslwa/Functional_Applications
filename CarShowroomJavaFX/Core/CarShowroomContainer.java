package Core;

import java.util.*;
import java.util.stream.Collectors;

public class CarShowroomContainer {
    private Map<String, CarShowroom> carShowrooms;

    public CarShowroomContainer() {
        this.carShowrooms = new HashMap<>();
        initializeShowrooms();
    }

    public Map<String, CarShowroom> getCarShowrooms(){
        return this.carShowrooms;
    }
    private void initializeShowrooms() {
        CarShowroom c1 = new CarShowroom("Salon Chicago",10);
        CarShowroom c2 = new CarShowroom("Salon LA", 30);

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

        c1.addProduct(v1);
        c1.addProduct(v2);
        c1.addProduct(v3);
        c1.addProduct(v4);
        c1.addProduct(v5);
        c1.addProduct(v6);
        c1.addProduct(v7);
        c1.addProduct(v8);
        c1.addProduct(v9);

        c2.addProduct(v10);
        c2.addProduct(v11);
        c2.addProduct(v12);
        c2.addProduct(v4);
        c2.addProduct(v1);

        carShowrooms.put("Salon Chicago", c1);
        carShowrooms.put("Salon LA", c2);
    }

    public void addCenter(String name, int maxCapacity) {
        carShowrooms.put(name, new CarShowroom(name, maxCapacity));
    }

    public void removeCenter(String name) {
        carShowrooms.remove(name);
    }

    public List<CarShowroom> findEmpty() {
        List<CarShowroom> emptyShowrooms = new ArrayList<>();
        for (CarShowroom s : carShowrooms.values()) {
            if (s.isEmpty()) {
                emptyShowrooms.add(s);
            }
        }
        for (CarShowroom s : emptyShowrooms) {
            System.out.println(s.getName());
        }
        return emptyShowrooms;
    }

    public void summary() {
        for (CarShowroom s : carShowrooms.values()) {
            System.out.println("Salon Name: " + s.getName());
            System.out.println("% of : " + s.getFillPercentage());
        }
    }

    public CarShowroom getShowroom(String name) {
        return carShowrooms.get(name);
    }

    public List<String> getShowroomNames() {
        return carShowrooms.keySet().stream().collect(Collectors.toList());
    }


    public int getSize() {
        return carShowrooms.size();
    }

    public void sortShowroomsByLoad() {
        carShowrooms = carShowrooms.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(CarShowroom::getFillPercentage).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}