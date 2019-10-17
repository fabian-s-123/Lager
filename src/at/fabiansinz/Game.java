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

        int sumWeightAllProducts = 0;
        for (int i = 0; i < allProducts.size(); i++) {
            sumWeightAllProducts += allProducts.get(i).getWeight();
        }
        System.out.println("sum weight of all products: " + sumWeightAllProducts);

        Field[][] array = new Field[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                array[x][y] = new Field();
            }
        }

        for (int i = 0; i < allProducts.size(); i++) {
            Product currentProduct = allProducts.get(i);
            int xPosProd = currentProduct.getxPos();
            int yPosProd = currentProduct.getyPos();
            array[xPosProd][yPosProd].getProductList().addLast(currentProduct);
        }

        array[0][0].setTrolley(trolley);
        Renderer renderer = new Renderer(array);
        renderer.render();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int xPosTrolleyBefore = trolley.getxPos();
            int yPosTrolleyBefore = trolley.getyPos();
            int xPosTrolleyAfter = trolley.getxPos();
            int yPosTrolleyAfter = trolley.getyPos();
            switch (input.toLowerCase()) {
                case "w":
                    if (yPosTrolleyBefore == 0) {
                        System.out.println("movement not possible");
                    } else {
                        yPosTrolleyAfter--;
                    }
                    break;
                case "s":
                    if (yPosTrolleyBefore == 9) {
                        System.out.println("movement not possible");
                    } else {
                        yPosTrolleyAfter++;
                    }
                    break;
                case "a":
                    if (xPosTrolleyBefore == 0) {
                        System.out.println("movement not possible");
                    } else {
                        xPosTrolleyAfter--;
                    }
                    break;
                case "d":
                    if (xPosTrolleyBefore == 9) {
                        System.out.println("not possible");
                    } else {
                        xPosTrolleyAfter++;
                    }
                    break;
            }
            trolley.setxPos(xPosTrolleyAfter);
            trolley.setyPos(yPosTrolleyAfter);
            array[xPosTrolleyBefore][yPosTrolleyBefore].setTrolley(null);
            array[xPosTrolleyAfter][yPosTrolleyAfter].setTrolley(trolley);
            if (xPosTrolleyAfter == 0 && yPosTrolleyAfter == 0) {
                if (trolley.getProductsLoaded().size() > 0) {
                    LinkedList<Product> productsOnTrolley = trolley.getProductsLoaded();
                    while (productsOnTrolley.size() > 0) {
                        Product currentProduct = productsOnTrolley.pop();
                        array[0][0].getProductList().add(currentProduct);
                    }
                    trolley.setCurrentWeight(0);
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
            } else if (array[xPosTrolleyAfter][yPosTrolleyAfter].getProductList().size() > 0) {
                System.out.println("product found on this field");
                //übernehmen der gefundenen Produktliste in foundProducts
                LinkedList<Product> foundProducts = array[xPosTrolleyAfter][yPosTrolleyAfter].getProductList();
                //herausfinden des aktuellen Gewichts der gefundenen Produkte
                int currentWeightFoundProducts = 0;
                for (int i = 0; i < foundProducts.size(); i++) {
                    currentWeightFoundProducts = currentWeightFoundProducts + foundProducts.get(i).getWeight();
                }
                //herausfinden der aktuellen Zuladekapazität des Trolleys
                int currentWeightTrolley = trolley.getCurrentWeight();
                int currentCapacityTrolley = trolley.getMaxWeight() - currentWeightTrolley;
                if (currentWeightFoundProducts > currentCapacityTrolley) {
                    System.out.println("unable to add this product to the trolley\ncurrent load trolley: " + currentWeightTrolley + " -> open capacity trolley: " + currentCapacityTrolley +
                            "\nweight product on this field: " + currentWeightFoundProducts);
                } else {
                    System.out.println("load trolley before adding the product: " + currentWeightTrolley +
                            "\nweight product on this field: " + currentWeightFoundProducts + " -> product successfully added to trolley");
                    currentWeightTrolley = currentWeightTrolley + currentWeightFoundProducts;
                    trolley.setCurrentWeight(currentWeightTrolley);
                    System.out.println("load trolley after adding the product: " + currentWeightTrolley);

                    for (int i = 0; i < foundProducts.size(); i++) {
                        Product currentProduct = array[xPosTrolleyAfter][yPosTrolleyAfter].getProductList().pop();
                        trolley.getProductsLoaded().add(currentProduct);
                    }
                }
            }
            renderer.render();
        }
    }

/*    private Field getFieldAtPosition(int x, int y) {
        return array[x][y]
    }

    private Point move(){*/

    }
