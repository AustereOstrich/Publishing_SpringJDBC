package com.matthewharrop.part1assignment3.app;

import com.matthewharrop.part1assignment3.crud.BooksCRUD;
import com.matthewharrop.part1assignment3.dao.BooksDaoImpl;
import com.matthewharrop.part1assignment3.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class UpdateBookApp {

    private static Logger logger = LoggerFactory.getLogger(
            com.matthewharrop.part1assignment3.app.UpdateBookApp.class);

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/applicationContext.xml");
        context.refresh();

        BooksCRUD booksCRUD = (BooksCRUD) context.getBean("booksCRUD");
        BooksDaoImpl impl = new BooksDaoImpl();
        int bookID = 1;
        float newPrice = (float) 10.99;

        logger.info("=================Testing Adding Book Start=================");

        logger.info("---------------Listing Book Start---------------");
        logger.info(impl.findBookById(booksCRUD, bookID).toString());
        logger.info("---------------Listing Book End---------------");


        impl.updateBookData(booksCRUD, bookID, newPrice);
        logger.info("Existing book updated with ID: " + bookID
                + ", Price set to: " + newPrice);

        logger.info("---------------Listing Book Start---------------");
        logger.info(impl.findBookById(booksCRUD, bookID).toString());
        logger.info("---------------Listing Book End---------------");
        logger.info("=================Testing Adding Book End=================");

        System.exit(0);
    }

}
