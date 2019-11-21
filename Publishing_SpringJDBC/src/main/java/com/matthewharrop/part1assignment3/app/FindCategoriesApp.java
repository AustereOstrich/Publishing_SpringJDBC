package com.matthewharrop.part1assignment3.app;

import com.matthewharrop.part1assignment3.crud.BooksCRUD;
import com.matthewharrop.part1assignment3.dao.BooksDaoImpl;
import com.matthewharrop.part1assignment3.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.lang.reflect.Method;

import java.util.List;

public class FindCategoriesApp {

    private static Logger logger = LoggerFactory.getLogger(
            com.matthewharrop.part1assignment3.app.FindCategoriesApp.class);

    public static void main(String[] args) {

    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("spring/applicationContext.xml");
        context.refresh();

        BooksCRUD booksCRUD = (BooksCRUD) context.getBean("booksCRUD");
        BooksDaoImpl impl = new BooksDaoImpl();



        List categories = impl.findCategories(booksCRUD);
        for (Object category : categories) {
            Category category1 = (Category) category;
            System.out.println(category1.getName());
        }
        for (Object category : categories) {
            Category category1 = (Category) category;
            logger.info(category1.toString());
        }



        System.exit(0);

    }

}
