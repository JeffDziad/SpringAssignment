package com.JeffDziad.classes.readers;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.ISalesReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesCSVReader implements ISalesReader {
    private Scanner scanner;

    public SalesCSVReader(String path) {
        try {
            this.scanner = new Scanner(new File(path));
        } catch(FileNotFoundException e) {
            System.out.println("The file at: " + path + " could not be found.");
        }
    }

    @Override
    public List<Sale> getSales() {
        List<Sale> out = new ArrayList<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            out.add(new Sale(fields[0], fields[1], Float.parseFloat(fields[2]), Float.parseFloat(fields[3])));
        }
        return out;
    }
}
