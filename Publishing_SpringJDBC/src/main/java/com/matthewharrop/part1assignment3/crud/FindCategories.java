package com.matthewharrop.part1assignment3.crud;

import com.matthewharrop.part1assignment3.domain.Category;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;


public class FindCategories extends BooksCRUD {

    public List findCategories(BooksCRUD bookscrud) {
        return bookscrud.jdbcTemplate.query("select * from CATEGORY", categoryMapper);
    }

}
