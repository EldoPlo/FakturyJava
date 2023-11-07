package com.example;

public enum InvoiceOperationsEnum
{
    CREATE_CLIENT,

    ADD_ARTICLE_TO_INVOICE,

    PRINT_INVOICE,

    CLOSE_PROGRAM,

    SAVE_TO_DATABASE,

    UNKNOWN;

    public static InvoiceOperationsEnum GetOperation(int i)
    {
        return switch (i)
        {
            case 1 -> CREATE_CLIENT;
            case 2 -> ADD_ARTICLE_TO_INVOICE;
            case 3 -> PRINT_INVOICE;
            case 4 -> SAVE_TO_DATABASE;
            case 5 -> CLOSE_PROGRAM ;
            default -> UNKNOWN;
        };
    }
}

