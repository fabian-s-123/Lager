package at.fabiansinz;

import java.util.LinkedList;

public class Trolley {

    private int maxWeight;
    private int currentWeight;
    private int xPos;
    private int yPos;
    private LinkedList<Product> productsLoaded;


    public Trolley (int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.xPos = 0;
        this.yPos = 0;
        this.productsLoaded = new LinkedList<>();
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public LinkedList<Product> getProductsLoaded() {
        return productsLoaded;
    }


}
