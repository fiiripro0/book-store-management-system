package com.LibraryMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibraryMS.entity.Book;
import com.LibraryMS.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;

	public void save(Book b) {
		bRepo.save(b);
	}

	public List<Book> getAllBookById(Integer id) {
		if (id != null) {
			return bRepo.searchById(id);
		}else {
			return bRepo.findAll();
		}
//		return bRepo.findAll();
	}

	public Book getBookById(int id) {
		return bRepo.findById(id).orElse(null);
	}

	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
