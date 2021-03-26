package io.brunosc.config;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsConfig implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext containerRespCtx) throws IOException {
        containerRespCtx.getHeaders().add("Access-Control-Allow-Origin","http://localhost:8080");
        containerRespCtx.getHeaders().add("Access-Control-Allow-Headers", "accept, origin, authorization, content-type, x-requested-with");
        containerRespCtx.getHeaders().add("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
        containerRespCtx.getHeaders().add("Access-Control-Max-Age", "1209600");
    }

}
