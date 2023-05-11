package patikaStore.products;

import patikaStore.tradeMark.TradeMark;

import java.util.ArrayList;
import java.util.Scanner;

public class NoteBook extends Products{
    private String ram;
    private String hardDisk;
    private String screenSize;

    public NoteBook(int id, String name,int price, int disCount, int stock, TradeMark tradeMark, String ram, String hardDisk, String screenSize) {
        super(id, name,price, disCount, stock, tradeMark);
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.screenSize = screenSize;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}
