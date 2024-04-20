package controllers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import Core.*;

public class CarShowroomApp extends Application {
    private CarShowroomContainer showroomContainer;
    private ObservableList<Vehicle> allVehicles = FXCollections.observableArrayList();
    private ObservableList<Vehicle> reservedVehicles = FXCollections.observableArrayList();
    private TableView<Vehicle> vehicleTable;
    private TableView<Vehicle> reservedVehicleTable;
    private ComboBox<String> showroomSelection;

    @Override
    public void start(Stage primaryStage) {
        showroomContainer = new CarShowroomContainer();  // Assume this is initialized and populated

        vehicleTable = createVehicleTable();
        reservedVehicleTable = createReservedVehicleTable();

        showroomSelection = new ComboBox<>();
        showroomSelection.getItems().add("Any");
        showroomSelection.getItems().addAll(showroomContainer.getShowroomNames());
        showroomSelection.setValue("Any");
        showroomSelection.setOnAction(event -> updateVehicleTable(showroomSelection.getValue()));

        TextField searchField = new TextField();
        searchField.setPromptText("Search by vehicle name...");
        searchField.textProperty().addListener((obs, oldVal, newVal) -> filterVehicleTable(newVal));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(new Label("Select Showroom:"), showroomSelection,
                new Label("Search Vehicle:"), searchField,
                new Label("Available Vehicles:"), vehicleTable,
                new Label("Reserved Vehicles:"), reservedVehicleTable);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

        Scene scene = new Scene(layout, 800, 800);
        primaryStage.setTitle("Car Showroom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableView<Vehicle> createVehicleTable() {
        TableView<Vehicle> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(
                createColumn("Name", "name"),
                createColumn("Price", "price"),
                createColumn("Year", "yearOfProduction"),
                createColumn("Showroom", "showroomName"),
                createActionColumn(false)
        );
        return table;
    }

    private TableView<Vehicle> createReservedVehicleTable() {
        TableView<Vehicle> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(
                createColumn("Name", "name"),
                createColumn("Price", "price"),
                createColumn("Year", "yearOfProduction"),
                createColumn("Showroom", "showroomName"),
                createActionColumn(true)
        );
        table.setItems(reservedVehicles);
        return table;
    }

    private <T> TableColumn<Vehicle, T> createColumn(String title, String property) {
        TableColumn<Vehicle, T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        return column;
    }

    private TableColumn<Vehicle, Void> createActionColumn(boolean isReservedTable) {
        TableColumn<Vehicle, Void> actionCol = new TableColumn<>("Actions");
        actionCol.setCellFactory(col -> new ActionCell(isReservedTable));
        return actionCol;
    }

    private void updateVehicleTable(String showroomName) {
        allVehicles.clear();
        if ("Any".equals(showroomName)) {
            showroomContainer.getCarShowrooms().values().forEach(showroom -> showroom.getCars().forEach(vehicle -> {
                vehicle.setShowroomName(showroom.getName());
                allVehicles.add(vehicle);
            }));
        } else {
            CarShowroom showroom = showroomContainer.getShowroom(showroomName);
            showroom.getCars().forEach(vehicle -> {
                vehicle.setShowroomName(showroom.getName());
                allVehicles.add(vehicle);
            });
        }
        vehicleTable.setItems(allVehicles);
    }

    private void filterVehicleTable(String searchText) {
        javafx.application.Platform.runLater(() -> {
            if (searchText == null || searchText.isEmpty()) {
                vehicleTable.setItems(allVehicles);
            } else {
                ObservableList<Vehicle> filteredVehicles = FXCollections.observableArrayList();
                for (Vehicle vehicle : allVehicles) {
                    if (vehicle.getName().toLowerCase().contains(searchText.toLowerCase())) {
                        filteredVehicles.add(vehicle);
                    }
                }
                vehicleTable.setItems(filteredVehicles);
            }
            vehicleTable.refresh();
        });
    }
    class ActionCell extends TableCell<Vehicle, Void> {
        private final Button reserveButton = new Button("Reserve");
        private final Button cancelButton = new Button("Cancel");
        private final Button buyButton = new Button("Buy");
        private final HBox pane = new HBox(5, reserveButton, buyButton);

        public ActionCell(boolean isReservedTable) {
            super();
            if (isReservedTable) {
                pane.getChildren().setAll(cancelButton, buyButton);
                cancelButton.setOnAction(event -> cancelReservation(getTableView().getItems().get(getIndex())));
                buyButton.setOnAction(event -> buyVehicle(getTableView().getItems().get(getIndex())));
            } else {
                reserveButton.setOnAction(event -> reserveVehicle(getTableView().getItems().get(getIndex())));
                buyButton.setOnAction(event -> buyVehicle(getTableView().getItems().get(getIndex())));
            }
        }

        private void reserveVehicle(Vehicle vehicle) {
            if (!vehicle.isReserved()) {
                vehicle.setReserved(true);
                reservedVehicles.add(vehicle);
                allVehicles.remove(vehicle);
                refreshTables();
                showAlert(Alert.AlertType.INFORMATION, "Vehicle reserved: " + vehicle.getName());
            } else {
                showAlert(Alert.AlertType.ERROR, "Vehicle is already reserved!");
            }
        }

        private void cancelReservation(Vehicle vehicle) {
            vehicle.setReserved(false);
            allVehicles.add(vehicle);
            reservedVehicles.remove(vehicle);
            refreshTables();
            showAlert(Alert.AlertType.INFORMATION, "Reservation canceled: " + vehicle.getName());
        }

        private void buyVehicle(Vehicle vehicle) {
            reservedVehicles.remove(vehicle);
            allVehicles.remove(vehicle);
            refreshTables();
            showAlert(Alert.AlertType.INFORMATION, "Vehicle purchased: " + vehicle.getName());
        }

        private void refreshTables() {
            vehicleTable.refresh();
            reservedVehicleTable.refresh();
        }

        private void showAlert(Alert.AlertType alertType, String content) {
            Alert alert = new Alert(alertType, content);
            alert.showAndWait();
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            setGraphic(empty ? null : pane);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}