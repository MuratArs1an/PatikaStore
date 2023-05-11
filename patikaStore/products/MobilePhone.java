package patikaStore.products;

import patikaStore.tradeMark.TradeMark;

public class MobilePhone extends Products{
    private String memory;
    private String screenSize;
    private String battery;
    private String ram;
    private String color;

    public MobilePhone(int id, String name,int price, int disCount, int stock, TradeMark tradeMark, String memory, String screenSize, String battery, String ram, String color) {
        super(id, name,price, disCount, stock, tradeMark);
        this.memory = memory;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
