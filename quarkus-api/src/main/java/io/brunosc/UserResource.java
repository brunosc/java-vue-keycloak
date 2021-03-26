package io.brunosc;

import io.brunosc.domain.User;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.keycloak.KeycloakPrincipal;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Principal;

@Path("/users")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    JsonWebToken jwt;

    @GET
    public Response hello() {
        return Response.ok(mapUser()).build();
    }

    private User mapUser() {
        return new User(jwt.getName(), jwt.getClaim("given_name"), jwt.getClaim("family_name"));
    }
}