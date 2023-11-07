package com.example;

public class InvoiceItem
{
    private final String article;
    private final double price;
    private final int quantity;
    public InvoiceItem(String article, double price, int quantity)
    {
        this.article = article;
        this.price = price;
        this.quantity = quantity;
    }
    public double calcTheCost()
    {
        return quantity * price;
    }

    @Override
    public String toString()
    {
        return "Artykuł: " + article + ", Ilość: " + quantity + ", Cena: " + "po " + price + " PLN";
    }
}
