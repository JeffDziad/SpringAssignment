package com.JeffDziad.classes.readers;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.ISalesReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesConsoleReader implements ISalesReader {

    private boolean complete = false;
    private List<Sale> collected = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private void printStartMessage() {
        System.out.println("+-------------------------------+");
        System.out.println("| Please populate the database. |");
        System.out.println("+-------------------------------+");
    }

    private String promptFor(String str, boolean isFloat) {
        boolean valid = false;
        String out = "";
        while(!valid) {
            System.out.print("\tEnter a " + str + ": ");
            out = scanner.nextLine();

            if(isFloat) {
                try {
                    float test = Float.parseFloat(out);
                } catch (NumberFormatException nfe) {
                    System.out.println("\nPlease enter a numeric value for " + str + ". Try again...\n");
                    continue;
                }
            }

            if(out.length() > 0) {
                valid = true;
            } else {
                System.out.println("\n" + str + "'s length must be longer than 0. Try again...\n");
                continue;
            }



        }
        return out;
    }

    @Override
    public List<Sale> getSales() {
        printStartMessage();

        while(!complete) {
            System.out.println("+-------------------------------+");
            System.out.println("| Sale #" + (collected.size()+1) + "\n");
            String name = promptFor("Full Name", false);
            String country = promptFor("Country", false);
            float amount = Float.parseFloat(promptFor("Sale Price", true));
            float tax = Float.parseFloat(promptFor("Sale Tax", true));
            collected.add(new Sale(name, country, amount, tax));

            System.out.print("\nAdd another? (Y/n): ");
            String cont = scanner.nextLine();
            if(cont.equals("n") || cont.equals("N")) {
                complete = true;
            }
            System.out.println("\n");
        }
        return collected;
    }
}
