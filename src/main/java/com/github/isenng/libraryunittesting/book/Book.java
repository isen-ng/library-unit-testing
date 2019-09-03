package com.github.isenng.libraryunittesting.book;

/**
 * A book
 */
public interface Book {
    /**
     * Gets the title of the book
     * @return the title of the book
     */
    String getTitle();

    /**
     * Gets the author of the book
     * @return the author of the book
     */
    String getAuthor();

    /**
     * Gets the text of the book
     * @return the content of the book
     */
    String getText();
}
