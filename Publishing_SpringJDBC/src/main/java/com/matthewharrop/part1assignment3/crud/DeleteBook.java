package com.matthewharrop.part1assignment3.crud;

import com.matthewharrop.part1assignment3.domain.Book;

public class DeleteBook extends BooksCRUD {

    public void deleteBook(BooksCRUD booksCRUD, Book book) {
        booksCRUD.jdbcTemplate.update("delete from BOOKS where ID = ?", book.id);
    }

}
