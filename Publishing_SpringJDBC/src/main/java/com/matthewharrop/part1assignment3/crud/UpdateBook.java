package com.matthewharrop.part1assignment3.crud;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import java.sql.Types;

public class UpdateBook extends SqlUpdate {

    public void updateBookPrice(BooksCRUD booksCRUD, int bookID, float newPrice) {

        setDataSource(booksCRUD.dataSource);
        setSql("update BOOKS set PRICE = ? where ID = ?");
        declareParameter(new SqlParameter("PRICE", Types.DECIMAL));
        declareParameter(new SqlParameter("ID", Types.INTEGER));
        compile();

        update(newPrice, bookID);

    }

}
