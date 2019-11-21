package com.matthewharrop.part1assignment3.app;

import com.matthewharrop.part1assignment3.crud.BooksCRUD;
import com.matthewharrop.part1assignment3.dao.BooksDaoImpl;
import com.matthewharrop.part1assignment3.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class DeleteBookApp {

    private static Logger logger = LoggerFactory.getLogger(
            com.matthewharrop.part1assignment3.app.DeleteBookApp.class);

    public static void listBooks(BooksCRUD booksCRUD) {
        List books = new BooksDaoImpl().findBooks(booksCRUD);
        for (Object book : books) {
            Book book1 = (Book) book;
            logger.info(book1.toString());
        }
    }

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/applicationContext.xml");
        context.refresh();

        BooksCRUD booksCRUD = (BooksCRUD) context.getBean("booksCRUD");
        BooksDaoImpl impl = new BooksDaoImpl();

        listBooks(booksCRUD);

        Book bookToDelete = (Book) context.getBean("book4");
        bookToDelete.id = booksCRUD.jdbcTemplate.queryForObject("select ID from BOOKS where TITLE = ?",
                new Object[]{bookToDelete.title}, int.class);
        logger.info("bookToDelete ID: " + (bookToDelete.id));

        impl.deleteBook(booksCRUD, bookToDelete);
        logger.info("Deleted book with ID: " + bookToDelete.id);

        listBooks(booksCRUD);

    }



}
