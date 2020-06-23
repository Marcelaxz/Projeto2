package br.mack.db;

import br.mack.api.Book;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book>{

    @Override
    public Book map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Book(
                rs.getInt("id"),
                rs.getInt("qtd"),
                rs.getDate("week")
        );
    }
}