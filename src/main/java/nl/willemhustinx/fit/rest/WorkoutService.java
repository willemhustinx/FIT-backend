package nl.willemhustinx.fit.rest;

import nl.willemhustinx.fit.model.Workout;
import nl.willemhustinx.fit.repository.WorkoutRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/workouts")
public class WorkoutService {

    @Inject
    WorkoutRepository ws;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Workout> getAll() {
        return ws.findAll();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Workout getWorkoutById(@PathParam("id") long id) {
        Workout workout = ws.findById(id);
        if (workout == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return workout;
    }

}