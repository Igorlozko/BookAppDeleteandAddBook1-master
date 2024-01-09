package ie.atu.bookappmoremicroservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        if (bookService.bookExistsByBookId(book.getBookId())) {
            return ResponseEntity.badRequest().body(null);
        }

        Book addedBook = bookService.addBook(book);
        return ResponseEntity.ok(addedBook);
    }
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable String bookId) {
        bookService.deleteBookByBookId(bookId);
        return ResponseEntity.ok().build();
    }
}