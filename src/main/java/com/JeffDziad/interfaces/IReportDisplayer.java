package com.JeffDziad.interfaces;

import com.JeffDziad.classes.models.Sale;

import java.util.List;

public interface IReportDisplayer {
    void displaySalesReport(String title, List<Sale> salesList);
}
