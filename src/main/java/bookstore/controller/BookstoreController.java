package bookstore.controller;

import bookstore.model.Book;
import bookstore.service.BookService;
import bookstore.service.ShoppingCartService;
import bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bookstore")
public class BookstoreController {

    private final ShoppingCartService shoppingCartService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BookstoreController(ShoppingCartService shoppingCartService, BookService bookService, UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.createBook(book));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) {
        Optional<Book> maybeBook = bookService.getBook(bookId);

        if (maybeBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(maybeBook.get());
    }
 }
