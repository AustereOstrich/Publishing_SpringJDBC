package com.matthewharrop.part1assignment3.app;

import com.matthewharrop.part1assignment3.crud.BooksCRUD;
import com.matthewharrop.part1assignment3.dao.BooksDaoImpl;
import com.matthewharrop.part1assignment3.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class AddBookApp {

    private static Logger logger = LoggerFactory.getLogger(
            com.matthewharrop.part1assignment3.app.AddBookApp.class);

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/applicationContext.xml");
        context.refresh();

        BooksCRUD booksCRUD = (BooksCRUD) context.getBean("booksCRUD");
        BooksDaoImpl impl = new BooksDaoImpl();
        Book bookToAdd = (Book) context.getBean("book4");

        logger.info("=================Testing Adding Book Start=================");
        impl.addBook(booksCRUD, bookToAdd);
        logger.info("New book inserted with ID: " + bookToAdd.categoryID);
        logger.info("---------------Listing Book Start---------------");
        logger.info(bookToAdd.toString());
        logger.info("---------------Listing Book End---------------");
        logger.info("=================Testing Adding Book End=================");


        System.exit(0);
    }

}
