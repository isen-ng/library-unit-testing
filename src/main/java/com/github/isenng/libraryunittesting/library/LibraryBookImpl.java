package com.github.isenng.libraryunittesting.library;

import com.github.isenng.libraryunittesting.library.duedates.DueDateCalculator;
import com.github.isenng.libraryunittesting.library.exceptions.AlreadyCheckedOutException;
import com.github.isenng.libraryunittesting.library.exceptions.NotCheckedOutException;

import java.time.LocalDate;

public class LibraryBookImpl implements LibraryBook {
    private DueDateCalculator dueDateCalculator;
    private LocalDate dueDate;

    public LibraryBookImpl(DueDateCalculator dueDateCalculator) {
        if (dueDateCalculator == null) {
            throw new IllegalArgumentException();
        }

        this.dueDateCalculator = dueDateCalculator;
        this.dueDate = null;
    }

    @Override
    public LocalDate getDueDate() throws NotCheckedOutException {
        if (dueDate == null) {
            throw new NotCheckedOutException();
        }

        return null;
    }

    @Override
    public synchronized LocalDate checkOut() throws AlreadyCheckedOutException {
        if (dueDate != null) {
            throw new AlreadyCheckedOutException();
        }

        dueDate = dueDateCalculator.calculateDueDate();
        return dueDate;
    }

    @Override
    public synchronized void checkIn() throws NotCheckedOutException {
        if (dueDate == null) {
            throw new NotCheckedOutException();
        }

        dueDate = null;
    }
}
