package com.example;

import java.util.List;

public interface DataBaseConnectionI
{
    void SaveToDatabase(List<Invoice> items);
}
