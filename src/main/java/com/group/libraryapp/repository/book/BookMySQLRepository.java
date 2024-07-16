package com.group.libraryapp.repository.book;


import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
public class BookMySQLRepository implements BookRepository {
    @Override
    public void saveBook() {
        System.out.println("MySQLRepository");
    }
}
