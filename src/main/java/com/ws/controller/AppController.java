package com.ws.controller;

import com.ws.model.Countries;
import com.ws.model.Person;
import com.ws.service.ICountriesService;
import com.ws.service.IPersonService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
@RequiredArgsConstructor
public class AppController {

    private final IPersonService personService;
    private final ICountriesService countriesService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPerson() {
        return Response.ok(personService.findAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePerson(Person person) {
        return Response.ok(personService.save(person)).build();
    }



    @GET()
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContries() {
        return Response.ok(countriesService.findAll()).build();
    }


    @POST
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCountries(Countries countries) {
        return Response.ok(countriesService.save(countries)).build();
    }
}