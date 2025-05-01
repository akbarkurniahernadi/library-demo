package com.library.service;

import com.library.model.dto.BookDTO;
import com.library.model.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO registerBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthorId(bookDTO.getAuthorId());
        book.setPublicationYear(bookDTO.getPublicationYear());
        Book savedBook = bookRepository.save(book);
        return new BookDTO(savedBook.getId(), savedBook.getTitle(), savedBook.getPublicationYear(), savedBook.getAuthorId());
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(book -> new BookDTO(book.getId(), book.getTitle(), book.getPublicationYear(), book.getAuthorId()))
                .orElse(null);
    }

    public Page<BookDTO> listBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookRepository.findAll(pageable);
        return books.map(book -> new BookDTO(book.getId(), book.getTitle(), book.getPublicationYear(), book.getAuthorId()));
    }
}

