package nl.willemhustinx.fit.rest;

import nl.willemhustinx.fit.model.Exercise;
import nl.willemhustinx.fit.repository.ExerciseRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/exercises")
public class ExerciseService {

    @Inject
    ExerciseRepository es;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercise> getAll() {
        return es.findAll();
    }
}