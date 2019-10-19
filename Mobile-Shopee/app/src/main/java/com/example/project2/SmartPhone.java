package com.example.project2;

import java.io.Serializable;

public class SmartPhone implements Serializable {
    private String name;
    private int ram;
    private int cpu;
    private double price;
    private int gsmArenaRank;
    private int storage;
    private double screenSize;
    private String manufacturer;
    private double weight;
    private String resolution;
    private String platform;
    private int battery;
    private double frontCamera;
    private double rearCamera;
    private int phoneImage;
    private String url;

    public SmartPhone(String name, int ram, int cpu, double price, int gsmArenaRank, int storage, double screenSize, String manufacturer, double weight, String resolution, String platform, int battery, double frontCamera, double rearCamera, int phoneImage, String url) {
        this.name = name;
        this.ram = ram;
        this.cpu = cpu;
        this.price = price;
        this.gsmArenaRank = gsmArenaRank;
        this.storage = storage;
        this.screenSize = screenSize;
        this.manufacturer = manufacturer;
        this.weight = weight;
        this.resolution = resolution;
        this.platform = platform;
        this.battery = battery;
        this.frontCamera = frontCamera;
        this.rearCamera = rearCamera;
        this.phoneImage = phoneImage;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    public int getCpu() {
        return cpu;
    }

    public double getPrice() {
        return price;
    }

    public int getGsmArenaRank() {
        return gsmArenaRank;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public String getResolution() {
        return resolution;
    }

    public String getPlatform() {
        return platform;
    }

    public double getFrontCamera() {
        return frontCamera;
    }

    public double getRearCamera() {
        return rearCamera;
    }

    public int getPhoneImage() {
        return phoneImage;
    }

    public int getBattery() {
        return battery;
    }

    public String getUrl() {
        return url;
    }
}
