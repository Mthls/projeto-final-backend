package com.example.biblioteca.service;

import com.example.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookService {
	// armazenamento simples em memória
	private final Map<String, Book> store = new ConcurrentHashMap<>();

	public List<Book> getAll() {
		return new ArrayList<>(store.values());
	}

	public Book create(Book b) {
		String id = UUID.randomUUID().toString();
		Book book = new Book(id, b.getTitle(), b.getAuthor(), b.getYear());
		store.put(id, book);
		return book;
	}

	public boolean remove(String id) {
		return store.remove(id) != null;
	}

	public void clearAll() {
		store.clear();
	}
}
