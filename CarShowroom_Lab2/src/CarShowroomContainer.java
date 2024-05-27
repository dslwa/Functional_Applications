import java.beans.VetoableChangeListener;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarShowroomContainer {
    private HashMap<String, CarShowroom> showrooms = new HashMap<>();

    public void addCenter(String name, Integer maxCapacity) {
        CarShowroom showroom = new CarShowroom(name, maxCapacity);
        showrooms.put(name, showroom);
    }

    public void addCenter(CarShowroom showroom) {
        showrooms.put(showroom.getName(), showroom);
    }

    public void removeCenter(String name) {
        showrooms.remove(name);
    }

    public List<CarShowroom> findEmpty() {
        List<CarShowroom> emptyShowrooms = new ArrayList<>();
        for (CarShowroom showroom : showrooms.values()) {
            if (showroom.getSize() == 0) {
                emptyShowrooms.add(showroom);
            }
        }
        return emptyShowrooms;
    }

    public void summary() {
        System.out.println("Summary:");
        for (Map.Entry<String, CarShowroom> entry : showrooms.entrySet()) {
            String name = entry.getKey();
            CarShowroom showroom = entry.getValue();
            double occupancyRate = (double) showroom.getSize() / showroom.getMaxCapacity() * 100;
            System.out.println("Showroom: " + name + ", Occupancy: " + occupancyRate + "%");
        }
    }

}
