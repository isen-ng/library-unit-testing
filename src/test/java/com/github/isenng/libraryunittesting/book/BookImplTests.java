package com.github.isenng.libraryunittesting.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class BookImplTests {
    private String mockTitle;
    private String mockAuthor;
    private String mockText;

    @BeforeEach
    void setup() {
        mockTitle = "my mock title";
        mockAuthor = "my mock author";
        mockText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua.";
    }

    @Nested
    class Constructor {
        @Test
        void ShouldThrowIllegalArgumentExceptionIfTitleIsNull() {
            // act
            Throwable t = catchThrowable(() -> new BookImpl(null, mockAuthor, mockText));

            // assert
            assertThat(t).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void ShouldThrowIllegalArgumentExceptionIfAuthorIsNull() {
            // act
            Throwable t = catchThrowable(() -> new BookImpl(mockTitle, null, mockText));

            // assert
            assertThat(t).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void ShouldThrowIllegalArgumentExceptionIfTextIsNull() {
            // act
            Throwable t = catchThrowable(() -> new BookImpl(mockTitle, mockAuthor, null));

            // assert
            assertThat(t).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class GetTitle {
        @Test
        void ShouldReturnTitle() {
            // arrange
            Book book = new BookImpl(mockTitle, mockAuthor, mockText);

            // act
            String result = book.getTitle();

            // assert
            assertThat(result).isEqualTo(mockTitle);
        }
    }

    @Nested
    class GetAuthor {
        @Test
        void ShouldReturnAuthor() {
            // arrange
            Book book = new BookImpl(mockTitle, mockAuthor, mockText);

            // act
            String result = book.getAuthor();

            // assert
            assertThat(result).isEqualTo(mockAuthor);
        }
    }

    @Nested
    class GetText {
        @Test
        void ShouldReturnText() {
            // arrange
            Book book = new BookImpl(mockTitle, mockAuthor, mockText);

            // act
            String result = book.getText();

            // assert
            assertThat(result).isEqualTo(mockText);
        }
    }
}
