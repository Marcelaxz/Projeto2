package br.mack.db;

import br.mack.api.Book;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
@RegisterRowMapper(BookMapper.class)

public interface BookDao {
        @SqlUpdate("insert into book (qtd, week) values (:qtd, :week)")
        @GetGeneratedKeys
        long insert(@BindBean Book book);

        @SqlQuery("select * from book")
        List<Book> getAllBooks();

        @SqlQuery("select * from book where id = :id")
        Book findById(@Bind("id") long id);

        @SqlUpdate("delete from book where id = :id")
        void delete(@Bind("id") long bookId);
}
