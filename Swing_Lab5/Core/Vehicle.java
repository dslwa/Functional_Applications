package Core;

import java.util.*;
public class Vehicle implements Comparable<Vehicle>{
    private String brand;
    private String model;
    private ItemCondition condition;
    private double price;
    private Integer yearOfProduction;
    private double mileage;
    private double engineCapacity;
    private String name;
    public int quantity = 1;

    public Vehicle(String b, String m, ItemCondition i, double p, Integer y, double ma, double ec){
        this.brand = b;
        this.model= m;
        this.condition = i;
        this.price = p;
        this.yearOfProduction = y;
        this.mileage = ma;
        this.engineCapacity = ec;
        this.name = this.brand + " " + this.model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public ItemCondition getCondition() {
        return condition;
    }

    public double getPrice() {
        return price;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public double getMileage() {
        return mileage;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getEngineCapacity() {
        return engineCapacity;
    }
    public String getName(){
        return name;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCondition(ItemCondition condition) {
        this.condition = condition;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(price, vehicle.price) == 0 && Double.compare(mileage, vehicle.mileage) == 0 && Double.compare(engineCapacity, vehicle.engineCapacity) == 0 && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && condition == vehicle.condition && Objects.equals(yearOfProduction, vehicle.yearOfProduction) && Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, condition, price, yearOfProduction, mileage, engineCapacity, name);
    }

    @Override
    public int compareTo(Vehicle object){
        return object.name.compareTo(this.name);
    }
    public void print(){
        System.out.print("Brand:" + this.brand);
        System.out.print(" Model:" + this.model);
        System.out.print(" Condition:" + this.condition);
        System.out.print(" Price:" + this.price);
        System.out.print(" Year of production:" + this.yearOfProduction);
        System.out.print(" Mileage:" + this.mileage);
        System.out.print(" Engine Capacity:" + this.engineCapacity);
        System.out.print(" Name:" + this.name + " ");
    }

}

