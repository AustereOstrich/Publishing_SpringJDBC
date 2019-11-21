package com.matthewharrop.part1assignment3.app;

import com.matthewharrop.part1assignment3.crud.BooksCRUD;
import com.matthewharrop.part1assignment3.dao.BooksDaoImpl;
import com.matthewharrop.part1assignment3.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SelectBooksByCategoryNameApp {

    private static Logger logger = LoggerFactory.getLogger(
            com.matthewharrop.part1assignment3.app.SelectBooksByCategoryNameApp.class);

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/applicationContext.xml");
        context.refresh();

        BooksCRUD booksCRUD = (BooksCRUD) context.getBean("booksCRUD");
        BooksDaoImpl impl = new BooksDaoImpl();

        logger.info("====================Finding Books By Category====================");
        logger.info("--------------Listing Books Start--------------");

        List books = impl.findByCategoryName(booksCRUD, "Literature");
        for (Object book : books) {
            Book book1 = (Book) book;
            logger.info(book1.toString());
        }

        logger.info("--------------Listing Books End--------------");
        logger.info("====================End of Finding Books By Category====================");

        System.exit(0);

    }

}
