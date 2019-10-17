package at.fabiansinz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Game {

    private Trolley trolley;
    private Product product;

    public void playGame() throws IOException {

        Trolley trolley = new Trolley(5);
        LinkedList<Product> allProducts = createProductList();
        int sumWeightAllProducts = calculateSumWeightAllProducts(allProducts);
        Field[][] array = createArray(10, 10);
        setProductsToArray(allProducts, array);
        array[0][0].setTrolley(trolley); //Setzen der Startposition des Trolleys im Array auf 0,0
        Renderer renderer = new Renderer(array);
        renderer.render();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            PositionTrolley beforeTrolleyMove = new PositionTrolley(trolley.getCurrentPosition().getX(), trolley.getCurrentPosition().getY());

            switch (input.toLowerCase()) {
                case "w":
                    trolley.moveUp();
                    break;
                case "s":
                    trolley.moveDown();
                    break;
                case "a":
                    trolley.moveLeft();
                    break;
                case "d":
                    trolley.moveRight();
                    break;
            }

            PositionTrolley afterTrolleyMove = new PositionTrolley(trolley.getCurrentPosition().getX(), trolley.getCurrentPosition().getY());
            array[beforeTrolleyMove.getX()][beforeTrolleyMove.getY()].setTrolley(null);
            array[afterTrolleyMove.getX()][afterTrolleyMove.getY()].setTrolley(trolley);

            if (afterTrolleyMove.getX() == 0 && afterTrolleyMove.getY() == 0) {
                trolley.unload(array, sumWeightAllProducts);
            } else if (array[afterTrolleyMove.getX()][afterTrolleyMove.getY()].getProductList().size() > 0) {
                trolley.load(array);
            }
            renderer.render();
        }
    }

    public LinkedList<Product> createProductList() {
        LinkedList<Product> allProducts = new LinkedList<>();

        allProducts.add(new Product("product1", 1));
        allProducts.add(new Product("product2", 2));
        allProducts.add(new Product("product3", 3));
        allProducts.add(new Product("product4", 1));
        allProducts.add(new Product("product5", 2));
        allProducts.add(new Product("product6", 3));
        allProducts.add(new Product("product7", 1));
        allProducts.add(new Product("product8", 2));
        allProducts.add(new Product("product9", 3));
        return allProducts;
    }

    public int calculateSumWeightAllProducts(LinkedList<Product> allProducts) {
        int sumWeightAllProducts = 0;
        for (int i = 0; i < allProducts.size(); i++) {
            sumWeightAllProducts += allProducts.get(i).getWeight();
        }
        System.out.println("sum weight of all products: " + sumWeightAllProducts);
        return sumWeightAllProducts;
    }

    public Field[][] createArray(int x1, int y1) {
        Field[][] array = new Field[x1][y1];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                array[x][y] = new Field();
            }
        }
        return array;
    }

    public void setProductsToArray(LinkedList<Product> allProducts, Field[][] array) {
        for (int i = 0; i < allProducts.size(); i++) {
            Product currentProduct = allProducts.get(i);
            int xPosProd = currentProduct.getxPos();
            int yPosProd = currentProduct.getyPos();
            array[xPosProd][yPosProd].getProductList().addLast(currentProduct);
        }
    }

}
