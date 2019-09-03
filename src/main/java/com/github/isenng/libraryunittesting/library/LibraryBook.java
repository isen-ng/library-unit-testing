package com.github.isenng.libraryunittesting.library;

import com.github.isenng.libraryunittesting.library.exceptions.AlreadyCheckedOutException;
import com.github.isenng.libraryunittesting.library.exceptions.NotCheckedOutException;

import java.time.LocalDate;

/**
 * A book that can be checked out of the library
 */
public interface LibraryBook {
    /**
     * Gets the due date of this book
     * @return the due date of this book
     * @throws NotCheckedOutException when this book is not checked out
     */
    LocalDate getDueDate() throws NotCheckedOutException;

    /**
     * Checks out a book
     * @return the due date
     * @throws AlreadyCheckedOutException when this book is already checked out
     */
    LocalDate checkOut() throws AlreadyCheckedOutException;

    /**
     * Returns a book
     * @throws NotCheckedOutException when this book is not checked out
     */
    void checkIn() throws NotCheckedOutException;
}
