package at.fabiansinz;

import java.util.Random;

public class Product {

    private String name;
    private int weight;
    private int xPos;
    private int yPos;

    Random random = new Random();

    public Product (String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.xPos = (int) ((Math.random()*9) + 1);
        this.yPos = (int) ((Math.random()*9) + 1);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

}
