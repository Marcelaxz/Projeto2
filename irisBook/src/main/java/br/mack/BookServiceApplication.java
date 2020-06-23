package br.mack;

import br.mack.db.BookDao;
import br.mack.resources.BookResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class BookServiceApplication extends Application<BookServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BookServiceApplication().run(args);

    }

    @Override
    public String getName() {
        return "BookService";
    }

    @Override
    public void run(final BookServiceConfiguration configuration, final Environment environment) {

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        BookDao bookDao = jdbi.onDemand(BookDao.class);

        //Resources
        BookResource bookResource = new BookResource(bookDao);
        environment.jersey().register(bookResource);

    }

    @Override
    public void initialize(final Bootstrap<BookServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<BookServiceConfiguration>() {
            @Override
            public void run(BookServiceConfiguration bookServiceConfiguration, Environment environment) throws Exception {
            }

            @Override
            public DataSourceFactory getDataSourceFactory(BookServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }

            @Override
            public String name() {
                return "db";
            }
        });
    }
}

