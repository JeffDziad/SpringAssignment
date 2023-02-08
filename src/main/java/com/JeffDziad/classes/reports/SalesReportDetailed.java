package com.JeffDziad.classes.reports;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.IReportDisplayer;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class SalesReportDetailed implements IReportDisplayer {

    @Override
    public void displaySalesReport(String title, List<Sale> salesList) {

        JFrame frame = new JFrame();
        frame.setTitle("Shipping Policy: " + title);

        String[] columns = { "Customer", "Country", "Amount ($)", "Tax ($)", "Shipping ($)" };
        String[][] rows = formattedData(salesList);

        final int font_size = 20;
        Font f = new Font("Serif", Font.PLAIN, font_size);
        JTable table = new JTable(rows, columns);
        table.setBounds(30, 40, 200, 200);
        table.setFont(f);
        table.getTableHeader().setFont(f);
        table.setRowHeight(table.getRowHeight() + font_size/2);
        table.setEnabled(false);

        JScrollPane sp = new JScrollPane(table);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(sp);
        frame.setSize(1000, 400);
        frame.setVisible(true);

    }

    private String[][] formattedData(List<Sale> salesList) {
        String[][] out = new String[salesList.size()][salesList.get(0).toFieldArray().length];
        Iterator<Sale> iterator = salesList.listIterator();
        int i = 0;
        while(iterator.hasNext()) {
            Sale s = iterator.next();
            out[i] = s.toFieldArray();
            i++;
        }
        return out;
    }

}
