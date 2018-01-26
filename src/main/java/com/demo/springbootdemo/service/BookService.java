package com.demo.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springbootdemo.dao.BookDao;
import com.demo.springbootdemo.dto.BookDto;


@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<BookDto> getBooks() {
        return bookDao.getBooks();
    }

    public Optional<BookDto> getBookById(String id) {
        //BookValidator.validate("id", id);
        return bookDao.getBookById(id);
    }

    public Optional<BookDto> deleteBook(String id) {
        //BookValidator.validate("id", id);
        return bookDao.deleteBook(id);
    }

    public BookDto createBook(String title, String author, String genre) {
        //BookValidator.validate(title, author, genre);
        return bookDao.createBook(title, author, genre);
    }

    public Optional<BookDto> updateBook(String id, String title, String author, String genre) {
        //BookValidator.validate(id, title, author, genre);
        return bookDao.updateBook(id, title, author, genre);
    }
}
