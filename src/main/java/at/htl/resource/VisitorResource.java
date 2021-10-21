package at.htl.resource;

import at.htl.entity.Visitor;
import at.htl.repository.VisitorRespository;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/visitor")
public class VisitorResource {

    @Inject
    VisitorRespository repo;

    @POST
    @Path("/add")
    public Response addVisitor(
            @FormParam("firstName") String firstname,
            @FormParam("lastName") String lastname,
            @FormParam("email") String email,
            @FormParam("phone") String phoneNumber
    ) {
        var vs = new Visitor(firstname, lastname, email, phoneNumber);
        if(repo.addVisitor(vs))
            return Response
                    .ok()
                    .entity(vs)
                    .header("tag", "Visitor added successfully!")
                    .build();

        return null;
    }
}
