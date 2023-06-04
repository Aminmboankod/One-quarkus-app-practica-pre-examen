package edu.craptocraft;



import edu.craptocraft.entity.Usuaria;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/wellcome")
public class ResourcesOlli {

    @Inject
    ServiceOlli service;
    
    public ResourcesOlli() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Wellcome Ollivanders!";
    }

    @GET
    @Path("/usuaria/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gUsuaria(@PathParam("nombre") String nombre) {
        Usuaria usuaria = service.cargaUsuaria(nombre);
        return usuaria.getNombre().isEmpty()? 
            Response.status(Response.Status.NOT_FOUND).build():
            Response.status(Response.Status.OK).entity(usuaria).build();
    }

    

    
}
