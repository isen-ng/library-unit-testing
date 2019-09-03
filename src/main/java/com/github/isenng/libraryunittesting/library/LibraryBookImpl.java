package com.github.isenng.libraryunittesting.library;

import com.github.isenng.libraryunittesting.library.duedates.DueDateCalculator;
import com.github.isenng.libraryunittesting.library.exceptions.AlreadyCheckedOutException;

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
    public synchronized LocalDate checkOut() throws AlreadyCheckedOutException {
        if (dueDate != null) {
            throw new AlreadyCheckedOutException();
        }

        dueDate = dueDateCalculator.calculateDueDate();
        return dueDate;
    }
}
