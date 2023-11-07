package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Metoda GRASP: Creator (Twórca)
// Klasa Main tworzy instancje Faktura w przypadku dodawania faktury.
// Odpowiedzialność za tworzenie obiektów faktur pozostaje w rękach kontrolera.

// Metoda GRASP: Controller
// Klasa Main pełni rolę kontrolera, obsługując interakcję z użytkownikiem poprzez konsolowy interfejs.

// Metoda GRASP: Low Coupling
// Klasa Main nie jest zależna od konkretnych klas elementów faktury.
// Oczekuje, że faktury składają się z elementów, ale nie wymaga konkretnej implementacji.
// Dzięki temu zmiany w klasach elementów faktury nie wpłyną na logikę głównego kontrolera.

// Metoda GRASP : Indirection
// Klasa Main działa jako pośrednik między użytkownikiem a klasami Invoice i InvoiceItem.
// Kontroluje przepływ operacji i zarządza nimi, przekazując odpowiednie polecenia do właściwych obiektów.
public class Main {
    public static void main(String[] args) {
        DataBaseConnectionI mockingDatabase = items
                -> System.out.println("\u001B[33m" + "Saved to database" + "\u001B[0m");

        Scanner scanner = new Scanner(System.in);
        Store store = new Store(mockingDatabase);
        OperationHandler operationHandler = new OperationHandler(store);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Wybierz operację:");
            System.out.println("\t 1. Dodaj fakturę");
            System.out.println("\t 2. Dodaj element faktury");
            System.out.println("\t 3. Wyświetl fakturę");
            System.out.println("\t 4. Zapisz do bazy danych");
            System.out.println("\t 5. Wyjście");
            System.out.print("Numer operacji: ");
            int opcja = scanner.nextInt();
            scanner.nextLine();
            InvoiceOperationsEnum operation = InvoiceOperationsEnum.GetOperation(opcja);
            operationHandler.handleOperation(operation, scanner);

//            switch (InvoiceOperationsEnum.GetOperation(opcja))
//            {
//                case CREATE_CLIENT ->
//                {
//                    System.out.print("Podaj nazwę klienta: ");
//                    String client = scanner.nextLine();
//                    store.addInvoice(client);
//                    System.out.println("Faktura dla klienta " + client + " została dodana.");
//                }
//
//                case ADD_ARTICLE_TO_INVOICE ->
//                {
//                    try
//                    {
//                        System.out.print("Podaj indeks faktury: ");
//                        int index = scanner.nextInt();
//                        System.out.print("Podaj artykuł: ");
//                        String article = scanner.next();
//                        System.out.print("Podaj ilość: ");
//                        int quantity = scanner.nextInt();
//                        System.out.print("Podaj cenę: ");
//                        double price = scanner.nextDouble();
//
//                        store.addItemToInvoice(index, article, quantity, price);
//                    }
//                    catch (Exception e)
//                    {
//                        System.out.print(e.getMessage());
//                        continue;
//                    }
//
//                    System.out.println("Element faktury został dodany.");
//                }
//
//                case PRINT_INVOICE ->
//                {
//                    int index;
//                    System.out.print("Podaj indeks faktury: ");
//
//                    try
//                    {
//                        index = scanner.nextInt();
//                    }
//                    catch (Exception e)
//                    {
//                        System.out.print(e.getMessage());
//                        continue;
//                    }
//
//                    System.out.println(store.printInvoice(index));
//                }
//
//                case CLOSE_PROGRAM -> isRunning = false;
//
//                case SAVE_TO_DATABASE -> store.save();
//
//                case UNKNOWN ->
//                    System.out.println("Nieprawidłowa opcja. Wybierz jeszcze raz.");
//            }
        }
    }
}
