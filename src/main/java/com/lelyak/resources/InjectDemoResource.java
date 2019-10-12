package com.lelyak.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotation(@MatrixParam("param") String matrixParam,
                                           @HeaderParam("customHeaderValue") String header,
                                           @CookieParam("name") String cookie) {
        return String.format("Matrix param: %s; Header param: %s; Cookie: %s", matrixParam, header, cookie);
    }

    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {

        String path = uriInfo.getAbsolutePath().toString();
        String cookies = httpHeaders.getCookies().toString();

        return String.format("Path: %s; Cookies: %s", path, cookies);
    }
}
