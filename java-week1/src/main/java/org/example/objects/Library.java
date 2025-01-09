package org.example.objects;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;
    private final Map<String, Integer> booksByTitle;
    private final Map<String, Integer> booksByAuthor;

    public Library() {
        this.books = new ArrayList<>();
        this.booksByTitle = new HashMap<>();
        this.booksByAuthor = new HashMap<>();
    }

    public void addBook(String title, String author) throws Exception {
        Optional<Book> bookExists = this.books.stream().filter(b -> b.getTitle().equals(title)).findAny();
        if (bookExists.isPresent()) throw new Exception("You try to add an exists book");
        this.books.add(
                new Book(title, author)
        );
        Integer index = this.books.size() - 1;
        this.booksByTitle.put(title, index);
        this.booksByAuthor.put(author, index);
    }

    public Optional<Book> searchBook(String key) {
        Integer indexByTitle = this.booksByTitle.get(key);
        if (indexByTitle != null) return Optional.ofNullable(this.books.get(indexByTitle));
        Integer indexByAuthor = this.booksByAuthor.get(key);
        if (indexByAuthor != null) return Optional.ofNullable(this.books.get(indexByAuthor));
        return Optional.empty();
    }

    public List<Book> listBooks() {
        return this.books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public void borrowBook(String key) throws Exception {
        Integer indexByTitle = this.booksByTitle.get(key);
        if (indexByTitle != null) {
            this.books.get(indexByTitle).borrowBook();
        }
        throw new Exception("Book not found");
    }

    public void returnBook(String key) throws Exception {
        Integer indexByTitle = this.booksByTitle.get(key);
        if (indexByTitle != null) {
            this.books.get(indexByTitle).returnBook();
        }
        throw new Exception("Book not found");
    }
}
