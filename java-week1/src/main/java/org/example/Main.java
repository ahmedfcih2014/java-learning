package org.example;

import org.example.objects.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        ConsoleHandler handler = new ConsoleHandler();

        System.out.println("=== Library Management System (LMS) ===");

        while (true) {
            System.out.println("""
                    \
                    1. Add a book
                    2. Search for a Book
                    3. List All Books
                    4. Borrow a Book
                    5. Return a Book
                    6. Exit"""
            );
            try {
                System.out.print("Enter your choice:");
                Integer choice = Integer.valueOf(System.console().readLine());
                if (choice.equals(6)) break;
                if (choice > 6 || choice < 1) throw new NumberFormatException();
                handler.handleChoice(choice, library);
            } catch (NumberFormatException nEx) {
                System.out.println("Please enter a valid choice from list (integer only from 1 to 6)");
            } catch (Exception ex) {
                System.out.println("Something went wrong, check the below message: " + ex.getMessage());
                System.out.println("-----------------------------------");
            }
        }
        System.out.println("Thanks for using LMS");
    }
}