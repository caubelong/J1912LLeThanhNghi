package com.mycompany.aptech.models;
/*

CREATE TABLE tblProduct(
    id integer primary key auto_increment,
    name varchar(500) NOT NULL,
    price double NOT NULL,
    amount integer
);

 */
public class Product {
    private String name;
    private Double price;
    private Integer amount;

    public Product(String name, Double price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
