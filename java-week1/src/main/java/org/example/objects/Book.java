package org.example.objects;

public class Book {
    private final String title;
    private final String author;
    private boolean isBorrowed = false;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void borrowBook() throws Exception {
        if (this.isBorrowed) throw new Exception("Book already borrowed");
        this.isBorrowed = true;
    }

    public void returnBook() throws Exception {
        if (!this.isBorrowed) throw new Exception("Book not borrowed to be returned");
        this.isBorrowed = false;
    }

    public boolean isAvailable() {
        return !this.isBorrowed;
    }
}
