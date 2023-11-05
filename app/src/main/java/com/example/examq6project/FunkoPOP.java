package com.example.examq6project;

public final class FunkoPOP {
    private int popNumber;
    private String popName;
    private String popType;
    private String fandom;
    private Boolean on;
    private String ultimate;
    private double price;

    public FunkoPOP(String popName, int popNumber, String popType, String fandom, boolean on, String ultimate, double price) {
        this.popName = popName;
        this.popNumber = popNumber;
        this.popType = popType;
        this.fandom = fandom;
        this.on = on;
        this.ultimate = ultimate;
        this.price = price;
    }

    public int getPopNumber() {
        return popNumber;
    }

    public String getPopName() {
        return popName;
    }

    public String getPopType() {
        return popType;
    }

    public String getFandom() {
        return fandom;
    }

    public Boolean getOn() {
        return on;
    }

    public String getUltimate() {
        return ultimate;
    }

    public double getPrice() {
        return price;
    }

    public void setPopName(String popName){
        this.popName = popName;
    }
    public void setPopNumber(int popNumber){
        this.popNumber=popNumber;
    }

    public void setPopType(String popType){
        this.popType=popType;
    }

    public void setFandom(String fandom){
        this.fandom=fandom;
    }

    public void setOn(Boolean on){
        this.on = on;
    }

    public void setUltimate(String ultimate){
        this.ultimate=ultimate;
    }

    public void setPrice(double price){
        this.price=price;
    }

    @Override
    public String toString() {
        return "FunkoPOP{" +
                "popName='" + popName + '\'' +
                ", popNumber=" + popNumber +
                ", popType='" + popType + '\'' +
                ", fandom='" + fandom + '\'' +
                ", on=" + on +
                ", ultimate='" + ultimate + '\'' +
                ", price=" + price +
                '}';
    }


}
