package com.matthewharrop.part1assignment3.crud;

import com.matthewharrop.part1assignment3.domain.Book;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import java.sql.Types;

public class AddBook extends SqlUpdate {

    public void addBook(BooksCRUD booksCRUD, Book book) {

        setDataSource(booksCRUD.dataSource);
        setSql("insert into BOOKS (CATEGORY_ID, TITLE, ISBN, PRICE) values (?, ?, ?, ?)");
        declareParameter(new SqlParameter("CATEGORY_ID", Types.INTEGER));
        declareParameter(new SqlParameter("TITLE", Types.VARCHAR));
        declareParameter(new SqlParameter("ISBN", Types.VARCHAR));
        declareParameter(new SqlParameter("PRICE", Types.DECIMAL));
        compile();

        update(book.categoryID, book.title, book.isbn, book.price);

    }

}
