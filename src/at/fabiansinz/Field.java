package at.fabiansinz;

import java.util.LinkedList;

public class Field {

    private Trolley trolley;
    private LinkedList<Product> productList;

    public Field () {
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

    public boolean isEmpty () {
        if (productList.size() == 0 && trolley==null) {
            return true;
        } else {
            return false;
        }
    }

    public void setProductList(LinkedList<Product> productList) {
        this.productList = productList;
    }
}
