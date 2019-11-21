package com.matthewharrop.part1assignment3.crud;

import com.matthewharrop.part1assignment3.domain.Book;

import java.util.List;

public class FindBooks extends BooksCRUD {

    public List findBooks(BooksCRUD bookscrud) {
        return bookscrud.jdbcTemplate.query("select * from BOOKS", bookMapper);
    }

}
