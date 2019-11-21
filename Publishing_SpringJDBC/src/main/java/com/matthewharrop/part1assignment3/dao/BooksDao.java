package com.matthewharrop.part1assignment3.dao;

import com.matthewharrop.part1assignment3.crud.BooksCRUD;
import com.matthewharrop.part1assignment3.domain.Book;

import java.util.List;

public interface BooksDao {
    public List findByCategoryName(BooksCRUD booksCRUD, String categoryName);
    public List findCategories(BooksCRUD booksCRUD);
    public List findBooks(BooksCRUD booksCRUD);
    public void addBook(BooksCRUD booksCRUD, Book book);
    public void updateBookData(BooksCRUD booksCRUD, int bookID, float newPrice);
    public void deleteBook(BooksCRUD booksCRUD, Book book);
    public Book findBookById(BooksCRUD booksCRUD, int id);
}