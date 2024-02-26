package az.edu.ada.wm2.week4.task1.service;

import az.edu.ada.wm2.week4.task1.model.Book;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>(List.of(
            new Book("To Kill a Mockingbird", "Harper Lee", "A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by virulent prejudice.", "1960"),
            new Book("1984", "George Orwell", "A dystopian novel set in Airstrip One, formerly Great Britain, a province of the superstate Oceania.", "1949"),
            new Book("The Great Gatsby", "F. Scott Fitzgerald", "A novel set in the fictional town of West Egg on prosperous Long Island in the summer of 1922.", "1925"),
            new Book("Pride and Prejudice", "Jane Austen", "A romantic novel of manners set in early 19th-century England, centered on the Bennet family.", "1813"),
            new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "The first novel in the Harry Potter series, which follows Harry Potter, a young wizard who discovers his magical heritage.", "1997"),
            new Book("The Catcher in the Rye", "J.D. Salinger", "A story following Holden Caulfield, a teenager from New York City, as he navigates his way through adolescence and the adult world.", "1951"),
            new Book("The Lord of the Rings", "J.R.R. Tolkien", "An epic high-fantasy novel set in the fictional world of Middle-earth, following the quest to destroy the One Ring.", "1954"),
            new Book("The Hobbit", "J.R.R. Tolkien", "A fantasy novel set in a time 'between the Dawn of Færie and the Dominion of Men', following the journey of Bilbo Baggins.", "1937"),
            new Book("Jane Eyre", "Charlotte Brontë", "A novel that follows the experiences of its eponymous heroine, including her growth to adulthood and her love for Mr. Rochester.", "1847"),
            new Book("To the Lighthouse", "Virginia Woolf", "A novel that centers on the Ramsay family and their visits to the Isle of Skye in Scotland between 1910 and 1920.", "1927")
    ));

    public List<Book> listBooks(){
        return books;
    }

    public void createBook(Book book) {
        if(book == null) return;
        if(book.getTitle() == null ||  book.getTitle().isBlank() ) return;
        if(book.getAuthor() == null ||  book.getAuthor().isBlank() ) return;
        if(book.getDescription() == null ||  book.getDescription().isBlank() ) return;
        if(book.getYear() == null ||  book.getYear().isBlank() ) return;

        books.add(book);
    }

    public void deleteBook(Integer idx){
        if(idx == null || idx < 0 || idx >= books.size()) return;
        books.remove(idx.intValue());
    }

    public void updatedBook(Integer idx, Book updatedBook){
        if(idx < 0 || idx >= books.size() || updatedBook == null) return;
        books.set(idx, updatedBook);
    }
}
