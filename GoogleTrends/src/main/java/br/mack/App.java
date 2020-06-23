package br.mack;

import br.mack.dao.TrendsDao;
import br.mack.resource.TrendsResource;

import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.Application;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class App extends Application<Configuration> {
    public static void main( String[] args ) {
        try{
            (new App()).run(args);
        }catch (Exception er){
            er.printStackTrace();
        }
    }

    public void initialize(Bootstrap <Configuration> bootstrap){
        AssetsBundle assetsBundle = new AssetsBundle("/site","/","index.html");
        bootstrap.addBundle(assetsBundle);
    }

    public void run(Configuration configuration, Environment environment) throws Exception{

        //CORS headers
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        //Configurando os parâmetros do CORS
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With, Content-Type, Accept, Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS, GET, PUT, POST, DELETE, HEAD");

        //Adicionando um mapeamento da URL
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/");

        //Registrando os Recursos
        TrendsDao dao = new TrendsDao();
        TrendsResource trendsResource = new TrendsResource(dao);
        environment.jersey().register(trendsResource);

        //Mudando as rotas dos recursos
        environment.jersey().setUrlPattern("/api/");
    }
}
