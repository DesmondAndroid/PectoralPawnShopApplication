package com.vadym.pectoralepawnshop.database;

/**
 * Created by Vadym on 25.06.2016.
 */
public class DepartmentEntity {

    private String name;
    private double coordinateX;
    private double coordinateY;
    private String city;
    private String address;
    private String[] telephoneNumbers;
    private String hoursWorking;

    public DepartmentEntity(String name, double coordinateX, double coordinateY, String city, String address, String[] telephoneNumbers, String hoursWorking) {
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.city = city;
        this.address = address;
        this.telephoneNumbers = telephoneNumbers;
        this.hoursWorking = hoursWorking;
    }

    public String getName() {
        return name;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String[] getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public String getHoursWorking() {
        return hoursWorking;
    }
}
