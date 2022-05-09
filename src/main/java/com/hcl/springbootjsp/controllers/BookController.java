package com.hcl.springbootjsp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    /*private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/viewBooks")
    public String viewBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "view-books";
    }

    @GetMapping("/addBook")
    public String addBookView(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/addBook")
    public RedirectView addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/book/addBook", true);
        Book savedBook = bookService.addBook(book);
        redirectAttributes.addFlashAttribute("savedBook", savedBook);
        redirectAttributes.addFlashAttribute("addBookSuccess", true);
        return redirectView;
    }*/
	
	@GetMapping("/viewBooks")
    public String viewBooks(Model model) {
		List<BookData> initData = new ArrayList<>();
        initData.add( new BookData("ISBN-1", "Book 1", "Book 1 Author"));
        initData.add(new BookData("ISBN-2", "Book 2", "Book 2 Author"));
        initData.add(new BookData("ISBN-3", "Book 3", "Book 3 Author"));
        
        model.addAttribute("books", initData);
        return "view-books";
    }
}