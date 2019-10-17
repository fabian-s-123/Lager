package at.fabiansinz;

import java.util.LinkedList;

public class Field {

    private Trolley trolley;
    private LinkedList<Product> productList;

    public Field() {
        //this.trolley
        this.productList = new LinkedList<>();
    }

    public Trolley getTrolley() {
        return trolley;
    }

    public void setTrolley(Trolley trolley) {
        this.trolley = trolley;
    }

    public LinkedList<Product> getProductList() {
        return productList;
    }

    public LinkedList<Product> getProducts() {
        return productList;
    }

    public boolean isEmpty() {
        if (productList.size() == 0 && trolley == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String temp1 = "Field Trolley = [" + trolley.getCurrentPosition().getX() + "][" + trolley.getCurrentPosition().getY() + "]";
        String temp2 = "\nTrolley has loaded: ";
        for (int i = 0; i < trolley.getProductsLoaded().size(); i++) {
            temp2 = temp2 + trolley.getProductsLoaded().get(i).getName() + ", weight: " + trolley.getProductsLoaded().get(i).getWeight() + "; ";
        }
        return temp1 + temp2;

    }

    public void setProductList(LinkedList<Product> productList) {
        this.productList = productList;
    }

}
