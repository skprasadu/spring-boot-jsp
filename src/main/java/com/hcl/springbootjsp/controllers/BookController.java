package com.hcl.springbootjsp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/book")
public class BookController {
	private List<BookData> initData = new ArrayList<>();

    /*private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }*/
	
	public BookController() {
	    initData.add( new BookData("ISBN-1", "Book 1", "Book 1 Author"));
	    initData.add(new BookData("ISBN-2", "Book 2", "Book 2 Author"));
	    initData.add(new BookData("ISBN-3", "Book 3", "Book 3 Author"));	
	}

	//To render the form for the book
    @GetMapping("/addBook")
    public String addBookView(Model model) {
        model.addAttribute("book", new BookData());
        return "add-book";
    }

    //This one was called when you POST from a form tag
    @PostMapping("/addBook")
    public RedirectView addBook(@ModelAttribute("book") BookData book, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/book/addBook", true);
        /*Book savedBook = bookService.addBook(book);*/
        initData.add(book);
        
        redirectAttributes.addFlashAttribute("savedBook", book);
        redirectAttributes.addFlashAttribute("addBookSuccess", true);
        return redirectView;
    }
	
	@GetMapping("/viewBooks")
    public String viewBooks(Model model) {
       
        model.addAttribute("books", initData);
        return "view-books";
    }
}