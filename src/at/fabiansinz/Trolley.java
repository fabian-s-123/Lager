package at.fabiansinz;

import java.util.LinkedList;

public class Trolley {

    private int maxWeight;
    private int currentWeight;
    private PositionTrolley currentPosition;
    private LinkedList<Product> productsLoaded;


    public Trolley(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.currentPosition = new PositionTrolley(0, 0);
        this.productsLoaded = new LinkedList<>();
    }


    public void moveUp() {
        if (currentPosition.getY() == 0) {
            System.out.println("movement not possible");
        } else {
            int temp = currentPosition.getY();
            temp--;
            currentPosition.setY(temp);
        }
    }

    public void moveDown() {
        if (currentPosition.getY() == 9) {
            System.out.println("movement not possible");
        } else {
            int temp = currentPosition.getY();
            temp++;
            currentPosition.setY(temp);
        }
    }

    public void moveLeft() {
        if (currentPosition.getX() == 0) {
            System.out.println("movement not possible");
        } else {
            int temp = currentPosition.getX();
            temp--;
            currentPosition.setX(temp);
        }
    }

    public void moveRight() {
        if (currentPosition.getX() == 9) {
            System.out.println("movement not possible");
        } else {
            int temp = currentPosition.getX();
            temp++;
            currentPosition.setX(temp);
        }
    }

    public void unload(Field[][] array, int sumWeightAllProducts) {
        if (getProductsLoaded().size() > 0) {
            LinkedList<Product> productsOnTrolley = getProductsLoaded();
            while (productsOnTrolley.size() > 0) {
                Product currentProduct = productsOnTrolley.pop();
                array[0][0].getProductList().add(currentProduct);
            }
            setCurrentWeight(0);
            int sumWeightAllProducts00 = 0;
            for (int i = 0; i < array[0][0].getProductList().size(); i++) {
                sumWeightAllProducts00 += array[0][0].getProductList().get(i).getWeight();
                System.out.println(array[0][0].getProductList().get(i).getName() + " " + array[0][0].getProductList().get(i).getWeight());
            }
            System.out.println("sum weight of all products at x[0] y[0]: " + sumWeightAllProducts00);
            if (sumWeightAllProducts == sumWeightAllProducts00) {
                System.out.println("Yay, all products successfully collected!");
                System.exit(0);
            }
        }
    }

    public void load (Field [][] array) {
        System.out.println("product found on this field");
        //übernehmen der gefundenen Produktliste in foundProducts
        LinkedList<Product> foundProducts = array[currentPosition.getX()][currentPosition.getY()].getProductList();
        //herausfinden des aktuellen Gewichts der gefundenen Produkte
        int currentWeightFoundProducts = 0;
        for (int i = 0; i < foundProducts.size(); i++) {
            currentWeightFoundProducts = currentWeightFoundProducts + foundProducts.get(i).getWeight();
        }
        //herausfinden der aktuellen Zuladekapazität des Trolleys
        int currentCapacityTrolley = getMaxWeight() - getCurrentWeight();
        if (currentWeightFoundProducts > currentCapacityTrolley) {
            System.out.println("unable to add this product to the trolley\ncurrent load trolley: " + getCurrentWeight() + " -> open capacity trolley: " + currentCapacityTrolley +
                    "\nweight product on this field: " + currentWeightFoundProducts);
        } else {
            System.out.println("load trolley before adding the product: " + getCurrentWeight() +
                    "\nweight product on this field: " + currentWeightFoundProducts + " -> product successfully added to trolley");
            setCurrentWeight(getCurrentWeight() + currentWeightFoundProducts);
            System.out.println("load trolley after adding the product: " + getCurrentWeight());
            while (foundProducts.size() > 0) {
                Product currentProduct = array[currentPosition.getX()][currentPosition.getY()].getProductList().pop();
                getProductsLoaded().add(currentProduct);
            }
        }
    }


    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public PositionTrolley getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(PositionTrolley currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setProductsLoaded(LinkedList<Product> productsLoaded) {
        this.productsLoaded = productsLoaded;
    }

    public LinkedList<Product> getProductsLoaded() {
        return productsLoaded;
    }

}
