package com.github.isenng.libraryunittesting.library;

import com.github.isenng.libraryunittesting.library.exceptions.AlreadyCheckedOutException;

import java.time.LocalDate;

/**
 * A book that can be checked out of the library
 */
public interface LibraryBook {
    /**
     * Checks out a book
     * @return the due date
     * @throws AlreadyCheckedOutException when this book is already checked out
     */
    LocalDate checkOut() throws AlreadyCheckedOutException;
}
