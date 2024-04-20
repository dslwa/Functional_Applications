package Models;
import Core.Vehicle;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VehicleTableModel extends AbstractTableModel {
    private List<Vehicle> vehicleList;
    public VehicleTableModel(List<Vehicle> vehicles){
        this.vehicleList = vehicles;
    }

    public void setVehicleList(List<Vehicle> vehicles){
        this.vehicleList = vehicles;
    }

    @Override
    public  int getRowCount(){
        return vehicleList.size();
    }
    @Override
    public int getColumnCount(){
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehicle vehicle = vehicleList.get(rowIndex);
        switch (columnIndex) {
            case 0: return vehicle.getBrand();
            case 1: return vehicle.getModel();
            case 2: return vehicle.getCondition();
            case 3: return vehicle.getPrice();
            case 4: return vehicle.getYearOfProduction();
            case 5: return vehicle.getMileage();
            case 6: return vehicle.getEngineCapacity();
            case 7: return vehicle.getQuantity();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Brand:";
            case 1: return "Model:";
            case 2: return "Condition:";
            case 3: return "Price:";
            case 4: return "Year:";
            case 5: return "Mileage:";
            case 6: return "Capacity:";
            case 7: return "Quantity:";
            default: return "";
        }
    }


}
