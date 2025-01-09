package org.example;

import org.example.objects.Library;

public class ConsoleHandler {
    void handleChoice(Integer choice, Library library) throws Exception {
        switch (choice) {
            case 1:
                handleAddBook(library);
                break;
            case 2:
                handleSearchBook(library);
                break;
            case 3:
                handleListBooks(library);
                break;
            case 4:
                handleBorrowBook(library);
                break;
            case 5:
                handleReturnBook(library);
                break;
        }
    }

    private void handleAddBook(Library library) throws Exception {
        System.out.println("-----------------------------------");
        System.out.print("Enter book title:");
        String title = System.console().readLine();
        System.out.print("Enter book author:");
        String author = System.console().readLine();
        library.addBook(title, author);
        System.out.println("-----------------------------------");
    }

    private void handleSearchBook(Library library) throws Exception {
        System.out.println("-----------------------------------");
        System.out.print("Enter book title/author:");
        String key = System.console().readLine();
        library.searchBook(key)
                .ifPresent(
                        value -> System.out.println("your search match this book: " + value.getTitle())
                );
        System.out.println("-----------------------------------");
    }

    private void handleListBooks(Library library) {
        System.out.println("-----------------------------------");
        System.out.println("Available books:");
        library.listBooks().forEach(b -> System.out.println(b.getTitle()));
        System.out.println("-----------------------------------");
    }

    private void handleBorrowBook(Library library) throws Exception {
        System.out.println("-----------------------------------");
        System.out.print("Enter book title for borrow:");
        String title = System.console().readLine();
        library.borrowBook(title);
        System.out.println("-----------------------------------");
    }

    private void handleReturnBook(Library library) throws Exception {
        System.out.println("-----------------------------------");
        System.out.print("Enter book title to return:");
        String title = System.console().readLine();
        library.returnBook(title);
        System.out.println("-----------------------------------");
    }
}
