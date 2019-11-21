package com.matthewharrop.part1assignment3.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {

    public int id;
    public String isbn;
    public String title;
    public Float price;
    public int categoryID;

    private static Logger logger = LoggerFactory.getLogger(
            Book.class);

    public void setId(int id) {
        this.id = id;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setCategoryID(int id) { this.categoryID = id; }

    public void reading() {
        logger.info("Reading " + title + " book");
    }

    public void throwException() throws RuntimeException {
        throw new RuntimeException("Book Bean Exception");
    }


    public String toString() {
        String bookString = "Book - ID: " + id + " CategoryID: " + categoryID + ", ISBN: " + isbn + ", Title: " + title +
                ", Price: " + price;
        return bookString;
    }

    public Book() {
    }

    public Book(int id, String isbn, String title, Float price) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    public Book(Integer categoryID, String title, String isbn, Float price) {
        this.categoryID = categoryID;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

}
