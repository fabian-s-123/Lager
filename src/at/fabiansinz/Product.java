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

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
