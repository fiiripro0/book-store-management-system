package com.LibraryMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.LibraryMS.entity.Book;
import com.LibraryMS.entity.MyBookList;
import com.LibraryMS.service.BookService;
import com.LibraryMS.service.MyBookListService;

import java.util.List;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private MyBookListService myBookService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}


@GetMapping("/available_books")
public String getAllBook(Model model, @RequestParam(value = "keyword", required = false) Integer keyword) {
	List<Book> list = service.getAllBookById(keyword);
	model.addAttribute("book", list);       // Add the list of books to the model
	model.addAttribute("keyword", keyword); // Add the keyword to the model
	return "bookList";                      // Return the view name
}


	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPublishDate());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
