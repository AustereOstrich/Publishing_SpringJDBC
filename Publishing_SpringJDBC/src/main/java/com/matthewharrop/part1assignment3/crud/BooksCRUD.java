package com.matthewharrop.part1assignment3.crud;

import com.matthewharrop.part1assignment3.dao.BooksDao;
import com.matthewharrop.part1assignment3.domain.Book;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.matthewharrop.part1assignment3.domain.Category;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

public class BooksCRUD {
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplate;

    public RowMapper bookMapper = new RowMapper() {
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book = new Book();
            book.setId(resultSet.getInt("ID"));
            book.setCategoryID(resultSet.getInt("CATEGORY_ID"));
            book.setIsbn(resultSet.getString("ISBN"));
            book.setPrice(resultSet.getFloat("PRICE"));
            book.setTitle(resultSet.getString("TITLE"));
            return book;
        }
    };

    public RowMapper categoryMapper = new RowMapper() {
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Category category = new Category();
            category.setId(resultSet.getLong("ID"));
            category.setName(resultSet.getString("NAME"));
            return category;
        }
    };

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        this.jdbcTemplate = jdbcTemplate;
    }

//    public String findByCategoryName(String category) {
//        Category categoryForSearch = jdbcTemplate.queryForObject("select ID from CATEGORY where NAME=?",
//                new Object[]{category}, Category.class);
////        return jdbcTemplate.queryForObject("select * from BOOKS where ")
//        return null;
//    }
//
//    public List findCategories() {
//        List categories = jdbcTemplate.query("select * from CATEGORY", categoryMapper);
//        return categories;
//    }
//
//    public String findBooks() {
//        return null;
//    }
//
//    public void addBook(Book book) {
//
//    }
//
//    public void updateBookData(String property, String data) {
//
//    }
//
//    public void updateBookData(String property, int data) {
//
//    }
//
//    public void deleteBook(Book book) {
//
//    }
}
