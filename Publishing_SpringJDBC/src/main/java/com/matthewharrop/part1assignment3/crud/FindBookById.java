package com.matthewharrop.part1assignment3.crud;

import com.matthewharrop.part1assignment3.domain.Book;

import java.util.List;

public class FindBookById extends BooksCRUD {

    public Book findBookById(BooksCRUD bookscrud, int bookId) {
        return (Book) bookscrud.jdbcTemplate.queryForObject("select * from BOOKS where ID = ?", new Object[] {bookId}, bookMapper);
    }

}
