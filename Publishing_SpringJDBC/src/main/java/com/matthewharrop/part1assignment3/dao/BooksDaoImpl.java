package com.matthewharrop.part1assignment3.dao;

import com.matthewharrop.part1assignment3.crud.*;
import com.matthewharrop.part1assignment3.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BooksDaoImpl implements BooksDao {

    public DataSource dataSource;
    public JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List findByCategoryName(BooksCRUD booksCRUD, String categoryName) {
        SelectBooksByCategoryName selectClass = new SelectBooksByCategoryName(booksCRUD.dataSource);
        return selectClass.selectBooksByCategoryName(booksCRUD, categoryName);
    }

    @Override
    public List findCategories(BooksCRUD booksCRUD) {
        return new FindCategories().findCategories(booksCRUD);
    }

    @Override
    public List findBooks(BooksCRUD booksCRUD) {
        return new FindBooks().findBooks(booksCRUD);
    }

    @Override
    public void addBook(BooksCRUD booksCRUD, Book book) {
        new AddBook().addBook(booksCRUD, book);
    }

    @Override
    public void updateBookData(BooksCRUD booksCRUD, int bookID, float newPrice) {
        new UpdateBook().updateBookPrice(booksCRUD, bookID, newPrice);
    }

    @Override
    public void deleteBook(BooksCRUD booksCRUD, Book book) {
        new DeleteBook().deleteBook(booksCRUD, book);
    }

    @Override
    public Book findBookById(BooksCRUD booksCRUD, int id) {
        return new FindBookById().findBookById(booksCRUD, id);
    }
}
