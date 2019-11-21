package com.matthewharrop.part1assignment3.crud;

import com.matthewharrop.part1assignment3.domain.Book;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class SelectBooksByCategoryName extends MappingSqlQuery<Book> {

    public List selectBooksByCategoryName(BooksCRUD booksCRUD, String categoryName) {

        int categoryID = booksCRUD.jdbcTemplate.queryForObject("select ID from CATEGORY where NAME = ?",
                new Object[]{categoryName}, int.class);
        SelectBooksByCategoryName selectCategoryQuery = new SelectBooksByCategoryName(booksCRUD.dataSource);
        return selectCategoryQuery.execute(new Object[] {categoryID});
    }



    public SelectBooksByCategoryName(DataSource ds) {

        super(ds, "select * from BOOKS where CATEGORY_ID = ?");
        super.declareParameter(new SqlParameter("CATEGORY_ID", Types.INTEGER));
        compile();
    }

    @Override
    protected Book mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book = new Book();
            book.setId(resultSet.getInt("ID"));
            book.setCategoryID(resultSet.getInt("CATEGORY_ID"));
            book.setIsbn(resultSet.getString("ISBN"));
            book.setPrice(resultSet.getFloat("PRICE"));
            book.setTitle(resultSet.getString("TITLE"));
            return book;
    }
}
