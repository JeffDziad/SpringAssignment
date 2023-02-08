package com.JeffDziad.classes.reports;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.IReportDisplayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SalesReportByLocation implements IReportDisplayer {
    @Override
    public void displaySalesReport(String title, List<Sale> salesList) {

        JFrame frame = new JFrame();
        frame.setTitle("Shipping Policy: " + title);

        String[] columns = { "Country", "Amount ($)", "Tax ($)", "Shipping ($)" };
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
        frame.setSize(500, 200);
        frame.setVisible(true);

    }

    private String[][] formattedData(List<Sale> salesList) {
        List<String> locations = new ArrayList<>();
        for(Sale s: salesList) {
            if(!locations.contains(s.getLocation())) {
                locations.add(s.getLocation());
            }
        }

        // Hardcoded amount, tax, shipping :(
        Float[][] values = new Float[locations.size()][];
        for(String loc: locations) {
            float amount = 0;
            float tax = 0;
            float shipping = 0;

            for(Sale s: salesList) {
                if(loc.equals(s.getLocation())) {
                    amount += s.getSalePrice();
                    tax += s.getSaleTax();
                    shipping += s.getSaleShipping();
                }
            }
            values[locations.indexOf(loc)] = new Float[]{ amount, tax, shipping };
        }

        String[][] out = new String[locations.size()][values.length];
        for(String loc: locations) {
            Float[] v = values[locations.indexOf(loc)];
            out[locations.indexOf(loc)] = new String[]{ loc,
                    String.format("%.2f", v[0]),
                    String.format("%.2f", v[1]),
                    String.format("%.2f", v[2]),
            };
        }

        return out;
    }
}