package Core;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarShowroom {

    private final String showroomName;
    private final List<Vehicle> cars;
    public double maxCapacity;

    public List<Vehicle> getCars(){
        return this.cars;
    }

    public String getName(){
        return this.showroomName;
    }
    public CarShowroom(String showroomName, int maxCapacity) {
        this.showroomName = showroomName;
        this.maxCapacity = maxCapacity;
        this.cars = new ArrayList<>();
    }

    public void addProduct(Vehicle vehicle) {
        if (cars.size() >= maxCapacity) {
            System.err.println("Capacity is exceeded");
            return;
        }

        for (Vehicle v : cars) {
            String name1 = v.getBrand() + " " + v.getModel();
            String name2 = vehicle.getBrand() + " " + vehicle.getModel();
            if (name1.compareTo(name2) == 0) {
                v.quantity++;
                return;
            }
        }

        cars.add(vehicle);
    }
    public void getProduct(Vehicle vehicle) {
        for (Vehicle v : cars) {
            if(v.equals(vehicle)) {
                v.quantity -=1;
                if(v.quantity == 0)
                    cars.remove(vehicle);
                return;
            }
        }
    }


    public Vehicle search(String name) {
        for (Vehicle v : cars) {
            String fullName = v.getBrand() + " " + v.getModel();
            if(fullName.compareTo(name) == 0) {
                return v;
            }
        }
        return null;
    }


    public List<Vehicle> searchPartial(String name) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : cars) {
            if (v.getBrand().contains(name) || v.getModel().contains(name)) {
                result.add(v);
            }
        }
        return result;
    }

    public int countByCondition(ItemCondition condition) {
        int i = 0;
        for (Vehicle v : cars) {
            if (v.getCondition() == condition) {
                i+=v.quantity;
            }
        }
        return i;
    }

    public List<Vehicle> filterByCondition(ItemCondition condition) {
        return cars.stream().filter(v -> v.getCondition() == condition).collect(Collectors.toList());
    }

    public void summary() {
        for (Vehicle v : cars) {
            v.print();
        }
    }

    public void sortByName() {
        Collections.sort(cars);
    }


    public void sortByAmount() {
        AmountComparator comparator = new AmountComparator();
        Collections.sort(cars, comparator);
    }


    public Vehicle max() {
        return Collections.max(cars, Comparator.comparingInt(Vehicle::getQuantity));
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public double getFillPercentage() {
        return ((double) cars.size() / maxCapacity) * 100;
    }

    static class AmountComparator implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            return Integer.compare(v2.getQuantity(), v1.getQuantity());
        }
    }

}