package com.example;

import java.util.Scanner;

public class OperationHandler
{
    private final Store store;
    boolean isRunning = true;
    public OperationHandler(Store store)
    {
        this.store = store;
    }

    public void handleOperation(InvoiceOperationsEnum operationsEnum, Scanner scanner)
    {
        switch (operationsEnum){
            case CREATE_CLIENT -> 
            { 
                System.out.print("Podaj nazwę klienta: ");
                String client = scanner.nextLine();
                store.addInvoice(client);
                System.out.println("Faktura dla klienta " + client + " została dodana.");
            }
            
            case ADD_ARTICLE_TO_INVOICE -> 
            {
                try
                {
                    System.out.print("Podaj indeks faktury: ");
                    int index = scanner.nextInt();
                    System.out.print("Podaj artykuł: ");
                    String article = scanner.next();
                    System.out.print("Podaj ilość: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Podaj cenę: ");
                    double price = scanner.nextDouble();

                    store.addItemToInvoice(index, article, quantity, price);
                }
                catch (Exception e)
                {
                    System.out.print(e.getMessage());
                    
                }

                System.out.println("Element faktury został dodany.");
            }
            case PRINT_INVOICE ->
            {
                int index = 0;
                System.out.print("Podaj indeks faktury: ");

                try
                {
                    index = scanner.nextInt();
                }
                catch (Exception e)
                {
                    System.out.print(e.getMessage());
                    
                }

                System.out.println(store.printInvoice(index));
            }

            case CLOSE_PROGRAM -> isRunning = false;

            case SAVE_TO_DATABASE -> store.save();

            case UNKNOWN ->
                    System.out.println("Nieprawidłowa opcja. Wybierz jeszcze raz.");
        }
            }
        }
    
            
