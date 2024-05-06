package com.group.libraryapp.Service.book;

import com.group.libraryapp.Repository.book.BookMemoryRepository;
import com.group.libraryapp.Repository.book.BookRepository;
import org.apache.catalina.authenticator.SavedRequest;

public class BookService {

    private final BookRepository bookRepository = new BookMemoryRepository();

}

