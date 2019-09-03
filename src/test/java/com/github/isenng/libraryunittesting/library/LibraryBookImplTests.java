package com.github.isenng.libraryunittesting.library;

import com.github.isenng.libraryunittesting.library.duedates.DueDateCalculator;
import com.github.isenng.libraryunittesting.library.exceptions.AlreadyCheckedOutException;
import com.github.isenng.libraryunittesting.library.exceptions.NotCheckedOutException;
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
    class GetDueDate {
        @Test
        void ShouldThrowNotCheckedOutExceptionIfBookIsNotCheckedOut() {
            // act
            Throwable t = catchThrowable(() -> libraryBook.getDueDate());

            // assert
            assertThat(t).isInstanceOf(NotCheckedOutException.class);
        }

        @Test
        void ShouldReturnDueDateIfBookIsCheckedOut() throws Exception {
            // arrange
            LocalDate expected = LocalDate.now();
            when(mockDueDateCalculator.calculateDueDate()).thenReturn(expected);
            libraryBook.checkOut();

            // act
            LocalDate result = libraryBook.getDueDate();

            // assert
            assertThat(result).isEqualTo(expected);
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

    @Nested
    class CheckIn {
        @Test
        void ShouldThrowNotCheckedOutExceptionIfBookIsCheckedOut() throws Exception {
            // act
            Throwable t = catchThrowable(() -> libraryBook.checkIn());

            // assert
            assertThat(t).isInstanceOf(NotCheckedOutException.class);
        }

        @Test
        void ShouldSucceedIfBookIsCheckedOut() throws Exception {
            // arrange
            when(mockDueDateCalculator.calculateDueDate()).thenReturn(LocalDate.now());
            libraryBook.checkOut();

            // act
            Throwable t = catchThrowable(() -> libraryBook.checkIn());

            // assert
            assertThat(t).isNull();
        }
    }
}
