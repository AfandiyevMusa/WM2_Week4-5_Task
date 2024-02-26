package az.edu.ada.wm2.week4.task1.controller;

import az.edu.ada.wm2.week4.task1.model.Book;
import az.edu.ada.wm2.week4.task1.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping({"", "/"})
    public String listBooks(Model model){
        var list = bookService.listBooks();
        model.addAttribute("books", list);
        return "all_books";
    }

    @GetMapping("/create")
    public String createBook(Model model){
        model.addAttribute("book", new Book("", "", "", ""));
        return "new_book";
    }

    @PostMapping("/save")
    public String createBook(@ModelAttribute("book") Book newBook){
        bookService.createBook(newBook);
        return "redirect:/books";
    }

    @GetMapping("/delete/{idx}")
    public String deleteBook(@PathVariable Integer idx ){
        bookService.deleteBook(idx);
        return "redirect:/books";
    }

    @GetMapping("/update/{idx}")
    public String updateBook(@PathVariable Integer idx, Model model) {
        if (idx < 0 || idx >= bookService.listBooks().size()) {
            return "redirect:/books";
        }
        Book existedBook = bookService.listBooks().get(idx);
        model.addAttribute("book", existedBook);
        model.addAttribute("bookIndex", idx);
        return "update_book";
    }

    @PostMapping("/update/{idx}")
    public String updateBook(@PathVariable Integer idx, @ModelAttribute("book") Book updatedBook){
        bookService.updatedBook(idx, updatedBook);
        return "redirect:/books";
    }
}
