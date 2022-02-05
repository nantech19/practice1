package com.nandu.pro.javapractice1.resources;

import com.nandu.pro.javapractice1.model.Plane;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Plane sayPlainTextHello() {
        return new Plane("BA","BA101");
    }

}
