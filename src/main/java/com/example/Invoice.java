package com.example;

import java.util.ArrayList;
import java.util.List;

public class Invoice
{
    private final String client;
    private final List<InvoiceItem> items = new ArrayList<>();


    public Invoice(String client)
    {
        this.client = client;
    }

    public void addItem(InvoiceItem item)
    {
       items.add(item);
    }
    public double countPrice()
    {
        double price = 0;

        for (InvoiceItem item : items)
        {
            price += item.calcTheCost();
        }

        return price;
    }

    @Override
    public String toString()
    {
        StringBuilder sB = new StringBuilder();

        sB.append("Invoice for client ").append(client).append("\n");
        sB.append("Elementy faktury: \n");

        items.forEach(item -> sB.append("\t").append(item).append("\n"));

        sB.append("Suma: ").append(countPrice()).append(" PLN").append("\n");

        return sB.toString();
    }



}

