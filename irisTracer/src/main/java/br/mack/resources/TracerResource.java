package br.mack.resources;

import br.mack.api.Tracer;
import br.mack.persistencia.TracerDAOMySQL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Tracer")
@Produces(MediaType.APPLICATION_JSON)
public class TracerResource {
    TracerDAOMySQL dao;

    public TracerResource(TracerDAOMySQL dao){
        this.dao = dao;
    }

    @POST
    public Tracer createTracer(Tracer tracer) {
        if (tracer == null) {
            throw new BadRequestException("product data missing");
        }
        this.dao.create(tracer);
        return tracer;
    }

    @GET
    public List<Tracer> getTracer() {
        return this.dao.read();
    }

    @DELETE
    @Path("{id}")
    public void deleteTracer(@PathParam("id") int id){
        dao.delete(id);
    }

    @PUT
    @Path("{id}")
    public void updateTracer(Tracer tracer){
        if (tracer == null) {
            throw new BadRequestException("product data missing");
        }
        dao.update(tracer);
    }
}
