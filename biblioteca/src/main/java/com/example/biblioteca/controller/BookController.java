package com.example.biblioteca.controller;

import com.example.biblioteca.model.Book;
import com.example.biblioteca.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*") // permite chamadas de dev/proxy; ajuste conforme necessário
public class BookController {

	private final BookService service;

	public BookController(BookService service) {
		this.service = service;
	}

	@GetMapping
	public List<Book> list() {
		return service.getAll();
	}

	@PostMapping
	public ResponseEntity<Book> create(@RequestBody Book book) {
		if (book.getTitle() == null || book.getTitle().trim().isEmpty()
			|| book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		Book created = service.create(book);
		return ResponseEntity.ok(created);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		boolean removed = service.remove(id);
		return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}

	@DeleteMapping
	public ResponseEntity<Void> clear() {
		service.clearAll();
		return ResponseEntity.noContent().build();
	}
}
