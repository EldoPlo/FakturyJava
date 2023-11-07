package com.example;

import java.util.ArrayList;
import java.util.List;

public class Store
{
    private final List<Invoice> invoices = new ArrayList<>();

    private final DataBaseConnectionI dataBaseConnection;

    public Store(DataBaseConnectionI dataBaseConnection)
    {
        this.dataBaseConnection = dataBaseConnection;
    }

    public void addInvoice(String clientName)
    {
        invoices.add(new Invoice(clientName));
    }

    public void addItemToInvoice(int index, String article, int quantity, double price) throws Exception
    {
        if (!doesInvoiceExist(index))
        {
            throw new Exception("This invoice does not exits");
        }

        invoices.get(index).addItem(new InvoiceItem(article, price, quantity));
    }

    public String printInvoice(int invoiceIndex)
    {
        if (doesInvoiceExist(invoiceIndex))
        {
            Invoice invoice = invoices.get(invoiceIndex);
            return invoice.toString();
        }
        else
        {
            return "This invoice does not exits";
        }
    }

    private boolean doesInvoiceExist(int index)
    {
        return !invoices.isEmpty() && (index >= 0 && index < invoices.size());
    }

    public void save()
    {
        dataBaseConnection.SaveToDatabase(invoices);
    }

    public List<Invoice> getInvoices()
    {
        return invoices;
    }
}
