package com.example.model;

public class Product extends Object implements Comparable<Product> {

    private String id;
    private String name;
    private double price; // natutal property

    @Override
    public int compareTo(Product o) {
        if (this.price == o.price)
            return 0;
        else if (this.price < o.price)
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


}
