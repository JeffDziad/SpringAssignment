package com.JeffDziad.classes.reports;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.IReportDisplayer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SalesReportByLocation implements IReportDisplayer {
    @Override
    public void displaySalesReport(String title, List<Sale> salesList) {

        JFrame frame = new JFrame();
        frame.setTitle("Shipping Policy: " + title);

        String[] columns = { "Country", "Amount ($)", "Tax ($)", "Shipping ($)" };
        String[][] rows = formattedData(salesList);

        JTable table = new JTable(rows, columns);
        table.setBounds(30, 40, 200, 200);
        table.setEnabled(false);

        JScrollPane sp = new JScrollPane(table);
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
                    Float.toString(v[0]),
                    Float.toString(v[1]),
                    Float.toString(v[2])
            };
        }

        return out;
    }
}