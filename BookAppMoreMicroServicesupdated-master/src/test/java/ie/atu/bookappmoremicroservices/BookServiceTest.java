package ie.atu.bookappmoremicroservices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBookExistsByBookId_Exists() {
        String bookId = "123";
        when(bookRepository.existsByBookId(bookId)).thenReturn(true);

        boolean result = bookService.bookExistsByBookId(bookId);

        assertTrue(result);
        verify(bookRepository, times(1)).existsByBookId(bookId);
    }

    @Test
    void testBookExistsByBookId_NotExists() {
        String bookId = "456";
        when(bookRepository.existsByBookId(bookId)).thenReturn(false);

        boolean result = bookService.bookExistsByBookId(bookId);

        assertFalse(result);
        verify(bookRepository, times(1)).existsByBookId(bookId);
    }

    @Test
    void testDeleteBookByBookId_Exists() {
        String bookId = "789";
        when(bookRepository.existsByBookId(bookId)).thenReturn(true);

        bookService.deleteBookByBookId(bookId);

        verify(bookRepository, times(1)).deleteByBookId(bookId);
    }

    @Test
    void testDeleteBookByBookId_NotExists() {
        String bookId = "101";
        when(bookRepository.existsByBookId(bookId)).thenReturn(false);

        bookService.deleteBookByBookId(bookId);

        verify(bookRepository, never()).deleteByBookId(bookId);
    }

    @Test
    public void testAllBooks() {
        // Mocking data
        Book book1 = createSampleBook("1", "Sample Title 1", "Author 1", "2022-01-01", "http://example.com/review1", "http://example.com/poster1", Arrays.asList("Genre1", "Genre2"), Arrays.asList("Backdrop1", "Backdrop2"));
        Book book2 = createSampleBook("2", "Sample Title 2", "Author 2", "2022-01-02", "http://example.com/review2", "http://example.com/poster2", Arrays.asList("Genre3", "Genre4"), Arrays.asList("Backdrop3", "Backdrop4"));
        List<Book> mockBooks = Arrays.asList(book1, book2);

        // Mocking repository method
        when(bookRepository.findAll()).thenReturn(mockBooks);

        // Call the service method
        List<Book> result = bookService.allBooks();

        // Assert the result
        assertEquals(mockBooks.size(), result.size());
    }
    private Book createSampleBook(String bookId, String title, String author, String releaseDate, String reviewLink, String poster, List<String> genres, List<String> backdrops) {
        Book book = new Book();
        book.setBookId(bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setReleaseDate(releaseDate);
        book.setReviewLink(reviewLink);
        book.setPoster(poster);
        book.setGenres(genres);
        book.setBackdrops(backdrops);
        return book;
    }
}