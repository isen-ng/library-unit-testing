package com.github.isenng.libraryunittesting.library;

import com.github.isenng.libraryunittesting.library.duedates.DueDateCalculator;
import com.github.isenng.libraryunittesting.library.exceptions.AlreadyCheckedOutException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

class LibraryBookImplTests {
    private LibraryBook libraryBook;
    private DueDateCalculator mockDueDateCalculator;

    @BeforeEach
    void setup() {
        mockDueDateCalculator = mock(DueDateCalculator.class);
        libraryBook = new LibraryBookImpl(mockDueDateCalculator);
    }

    @Nested
    class Constructor {
        @Test
        void ShouldThrowIllegalArgumentExceptionIfDueDateCalculatorIsNull() {
            // act
            Throwable t = catchThrowable(() -> new LibraryBookImpl(null));

            // assert
            assertThat(t).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class CheckOut {
        @Test
        void ShouldThrowAlreadyCheckedOutExceptionIfBookIsCheckedOut() throws Exception {
            // arrange
            when(mockDueDateCalculator.calculateDueDate()).thenReturn(LocalDate.now());
            libraryBook.checkOut();

            // act
            Throwable t = catchThrowable(() -> libraryBook.checkOut());

            // assert
            assertThat(t).isInstanceOf(AlreadyCheckedOutException.class);
        }

        @Test
        void ShouldReturnDueDateIfBookIsNotCheckedOut() throws Exception {
            // arrange
            LocalDate expected = LocalDate.now();
            when(mockDueDateCalculator.calculateDueDate()).thenReturn(expected);

            // act
            LocalDate result = libraryBook.checkOut();

            // assert
            assertThat(result).isEqualTo(expected);
            verify(mockDueDateCalculator).calculateDueDate();
        }
    }
}
