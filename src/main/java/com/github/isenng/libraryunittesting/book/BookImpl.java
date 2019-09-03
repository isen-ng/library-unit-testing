package com.github.isenng.libraryunittesting.book;

public class BookImpl implements Book {
    private String title;
    private String author;
    private String text;

    public BookImpl(String title, String author, String text) {
        if (title == null) {
            throw new IllegalArgumentException("Title should not be null");
        }
        if (author == null) {
            throw new IllegalArgumentException("Author should not be null");
        }
        if (text == null) {
            throw new IllegalArgumentException("Text should not be null");
        }

        this.title = title;
        this.author = author;
        this.text = text;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getText() {
        return text;
    }
}
