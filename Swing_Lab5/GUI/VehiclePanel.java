package GUI;
import Core.*;
import Models.VehicleTableModel;

import javax.swing.*;
import java.awt.*;


public class VehiclePanel extends JPanel {
    private JTable vehicleTable;
    private VehicleTableModel vehicleTableModel;
    private JButton addButton, removeButton, sortByNameButton, sortByAmountButton;
    private CarShowroom showroom;
    private JTextField filterTextField;
    private JComboBox<ItemCondition> stateComboBox;

    public VehiclePanel(CarShowroom showroom) {
        this.showroom = showroom;

        setLayout(new BorderLayout());
        initUI();
        addListeners();
    }

    private void initUI() {
        vehicleTableModel = new VehicleTableModel(showroom.getCars());
        vehicleTable = new JTable(vehicleTableModel);

        JScrollPane scrollPane = new JScrollPane(vehicleTable);
        add(scrollPane, BorderLayout.CENTER);

        addButton = new JButton("Add Vehicle");
        removeButton = new JButton("Remove Vehicle");
        sortByNameButton = new JButton("Sort by Name");
        sortByAmountButton = new JButton("Sort by Amount");

        filterTextField = new JTextField(20);

        stateComboBox = new JComboBox<>(ItemCondition.values());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(sortByNameButton);
        buttonPanel.add(sortByAmountButton);

        buttonPanel.add(filterTextField);

        buttonPanel.add(stateComboBox);

        add(buttonPanel, BorderLayout.NORTH);
    }

    private void addListeners() {
        addButton.addActionListener(e -> addVehicle());
        removeButton.addActionListener(e -> removeSelectedVehicle());
        sortByNameButton.addActionListener(e -> sortByName());
        sortByAmountButton.addActionListener(e -> sortByAmount());

        filterTextField.addActionListener(e -> {
            String searchText = filterTextField.getText();
            vehicleTableModel.setVehicleList(showroom.searchPartial(searchText));
            vehicleTableModel.fireTableDataChanged();
        });

        stateComboBox.addActionListener(e -> {
            ItemCondition selectedCondition = (ItemCondition) stateComboBox.getSelectedItem();
            vehicleTableModel.setVehicleList(showroom.filterByCondition(selectedCondition));
            vehicleTableModel.fireTableDataChanged();
        });
    }

    private void addVehicle() {
        try {
            String brand = JOptionPane.showInputDialog("Brand:");
            String model = JOptionPane.showInputDialog("Model:");
            try {
                ItemCondition condition = ItemCondition.valueOf(JOptionPane.showInputDialog("Enter vehicle condition:"));
                int price = Integer.parseInt(JOptionPane.showInputDialog("Price:"));
                int yearOfProduction = Integer.parseInt(JOptionPane.showInputDialog("Year of Production:"));
                int mileage = Integer.parseInt(JOptionPane.showInputDialog("Mileage:"));
                int engineCapacity = Integer.parseInt(JOptionPane.showInputDialog("Engine Capacity:"));
                Vehicle newVehicle = new Vehicle(brand, model, condition, price, yearOfProduction, mileage, engineCapacity);
                showroom.addProduct(newVehicle);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Invalid input for numeric value. Please enter a number.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Invalid input for condition. Please enter: NEW, USED or DAMAGED.");
            }
            vehicleTableModel.fireTableDataChanged();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Name is null.");
        }

    }

    private void removeSelectedVehicle() {
        int selectedRow = vehicleTable.getSelectedRow();
        if (selectedRow >= 0) {
            Vehicle vehicle = showroom.getCars().get(selectedRow);
            showroom.getProduct(vehicle);
            vehicleTableModel.fireTableDataChanged();
        }
    }

    private void sortByName() {
        showroom.sortByName();
        vehicleTableModel.fireTableDataChanged();
    }

    private void sortByAmount() {
        showroom.sortByAmount();
        vehicleTableModel.fireTableDataChanged();
    }

    public void updateShowroom(CarShowroom newShowroom) {
        this.showroom = newShowroom;
        vehicleTableModel.setVehicleList(showroom.getCars());
        vehicleTableModel.fireTableDataChanged();
    }
}