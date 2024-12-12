package com.sqe.week9.designpattern;

class Product {
    private String name;
    private double price;
    private String category;

    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
    }

    public static class Builder {
        private String name;
        private double price;
        private String category;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
    }
}

// Usage
public class BuilderPatternDemo {
    public static void main(String[] args) {
        Product product = new Product.Builder()
                .setName("Laptop")
                .setPrice(1200.50)
                .setCategory("Electronics")
                .build();

        System.out.println(product);
    }
}

