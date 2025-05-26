package com.example;

import com.example.model.Product;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {

        Product product1 = new Product("1", "Laptop", 1200.00);
        Product product2 = new Product("2", "Smartphone", 800.00);
        Product product3 = new Product("3", "Tablet", 500.00);
        Product product4 = new Product("4", "Smartwatch", 200.00);
        Product product5 = new Product("5", "Headphones", 150.00);

        //---------------------

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product5);
        products.add(product4);
        products.add(product4);

        // TODO - do learn all list collections methods


        //----------------------------------------------
        // sorting
        //----------------------------------------------

        Collections.sort(products); // using natural order defined in Product class


        // Way-1: Named Local Inner Class
        class PriceComparator implements Comparator<Product> {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() == o2.getPrice())
                    return 0;
                else if (o1.getPrice() < o2.getPrice())
                    return -1;
                else
                    return 1;
            }
        }
        Comparator<Product> priceComparator = new PriceComparator();

        // or

        // way-2: Anonymous Inner Class
        Comparator<Product> priceComparator2 = new Comparator<>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() == o2.getPrice())
                    return 0;
                else if (o1.getPrice() < o2.getPrice())
                    return -1;
                else
                    return 1;
            }
        };

        Collections.sort(products, priceComparator2);
        display(products);

    }

    public static void display(List<Product> products) {
        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

