package com.JeffDziad.classes;

import com.JeffDziad.interfaces.IDBReader;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CSVReader implements IDBReader {
    private String path;
    private int fields;
    private Scanner scanner;
    public CSVReader(String path, int fields) {
        this.path = path;
        this.fields = fields;
        this.scanner = new Scanner(path);
    }

    private String[] getParsedCSV(String line) {
        System.out.println(line);

        String[] arr = new String[fields];
        return arr;
    }

    @Override
    public List<Sale> getData() {
        List<Sale> out = new ArrayList<>();
        while(scanner.hasNext()) {
            String[] parsed = getParsedCSV(scanner.nextLine());

        }
        return out;
    }
}
