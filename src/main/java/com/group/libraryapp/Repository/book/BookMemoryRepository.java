package com.group.libraryapp.Repository.book;

import java.util.*;
public class BookMemoryRepository implements BookRepository {
    private final List<String> books = new ArrayList();
    @Override
    public void save(String bookName) {
        books.add(bookName);
    }
}