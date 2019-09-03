package com.github.isenng.libraryunittesting.library.duedates;

import java.time.LocalDate;

public class SuperComplexDueDateCalculator implements DueDateCalculator {
    @Override
    public LocalDate calculateDueDate() {
        return LocalDate.now().plusDays(14);
    }
}
