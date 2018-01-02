package geek.ma1uta.matrix.rest.client.api;

import geek.ma1uta.matrix.rest.client.model.admin.AdminResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/_matrix/client/r0/admin")
public interface AdminApi {

    @GET
    @Path("/whois/{userId}")
    AdminResponse whois(@PathParam("userId") String userId);
}
