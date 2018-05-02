package nl.willemhustinx.fit.rest;

import nl.willemhustinx.fit.model.WorkoutExercise;
import nl.willemhustinx.fit.repository.WorkoutExerciseRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/workoutexercises")
public class WorkoutExerciseService {

    @Inject
    WorkoutExerciseRepository es;

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public WorkoutExercise getWorkoutExerciseById(@PathParam("id") long id) {
        WorkoutExercise exercise = es.findById(id);
        if (exercise == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return exercise;
    }

    @GET
    @Path("/fromWorkout/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<WorkoutExercise> getWorkoutExercisesFormWorkout(@PathParam("id") long id) {
        return es.findByWorkoutId(id);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public WorkoutExercise updateWorkoutExercise(WorkoutExercise exercise) {
        System.out.println("update");
        System.out.println(exercise);
        return es.merge(exercise);
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteWorkoutExercise(@PathParam("id") long id) {
        WorkoutExercise exercise = es.findById(id);
        if (exercise == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        es.remove(exercise);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public WorkoutExercise addWorkoutExercise(WorkoutExercise exercise) {
        return es.persist(exercise);
    }

}