package GUI;
import Core.*;

import javax.swing.*;
import java.awt.*;

public class CarShowroomGUI extends JFrame {
    private final CarShowroomContainer carShowroomContainer;
    private CenterPanel centerPanel;
    private VehiclePanel vehiclePanel;

    public CarShowroomGUI() {
        this.setTitle("Cars");
        this.setSize(800, 1200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        carShowroomContainer = new CarShowroomContainer();

        initComponents();

        this.setVisible(true);

        this.pack();
    }

    private void initComponents() {
        centerPanel = new CenterPanel(carShowroomContainer, this);
        vehiclePanel = new VehiclePanel(carShowroomContainer.getShowroom("Salon LA"));

        this.add(centerPanel, BorderLayout.EAST);
        this.add(vehiclePanel, BorderLayout.CENTER);

    }

    public void updateVehiclePanel(String showroomName) {
        vehiclePanel.updateShowroom(carShowroomContainer.getShowroom(showroomName));
    }
}