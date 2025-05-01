package com.library.service;

import com.library.model.dto.BookDTO;
import com.library.model.entity.Book;
import com.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private BookDTO bookDTO;
    private Book book;

    @BeforeEach
    public void setUp() {
        bookDTO = new BookDTO(1L, "Test Book", 2023, 1L);
        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setPublicationYear(2023);
        book.setAuthorId(1L);
    }

    @Test
    public void testRegisterBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookDTO result = bookService.registerBook(bookDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Book", result.getTitle());
        assertEquals(2023, result.getPublicationYear());
        assertEquals(1L, result.getAuthorId());

        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    public void testGetBookById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        BookDTO result = bookService.getBookById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Book", result.getTitle());
        assertEquals(2023, result.getPublicationYear());
        assertEquals(1L, result.getAuthorId());

        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetBookById_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        BookDTO result = bookService.getBookById(1L);

        assertNull(result);

        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    public void testListBooks() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Book> books = List.of(book);
        Page<Book> page = new PageImpl<>(books, pageable, books.size());

        when(bookRepository.findAll(pageable)).thenReturn(page);

        Page<BookDTO> result = bookService.listBooks(0, 10);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals("Test Book", result.getContent().get(0).getTitle());

        verify(bookRepository, times(1)).findAll(pageable);
    }
}
