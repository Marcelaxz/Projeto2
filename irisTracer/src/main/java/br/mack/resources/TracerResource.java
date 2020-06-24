package br.mack.resources;

import br.mack.entidade.Tracer;
import br.mack.persistencia.TracerDAOMySQL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("Tracer")
@Produces(MediaType.APPLICATION_JSON)
public class TracerResource {
    TracerDAOMySQL dao;

    public TracerResource(TracerDAOMySQL dao){
        this.dao = dao;
    }

    @POST
    public void createTracer(Tracer tracer) {
        if (tracer == null) {
            throw new BadRequestException("product data missing");
        }
        dao.create(tracer);
    }

    @GET
    public void getTracer() {
        dao.read();
    }

    @DELETE
    @Path("/{id}")
    public void deleteTracer(@PathParam("id") int id){
        dao.delete(id);
    }

    @PUT
    public void updateTracer(Tracer tracer){
        if (tracer == null) {
            throw new BadRequestException("product data missing");
        }
        dao.update(tracer);
    }
}
