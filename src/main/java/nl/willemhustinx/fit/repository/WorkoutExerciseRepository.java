package nl.willemhustinx.fit.repository;

import nl.willemhustinx.fit.model.WorkoutExercise;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class WorkoutExerciseRepository extends AbstractRepository<WorkoutExercise> {

    @Override
    protected Class<WorkoutExercise> getEntityClass() {
        return WorkoutExercise.class;
    }

    public List<WorkoutExercise> findByWorkoutId(Long id) {
        List<WorkoutExercise> workoutExercises = entityManager.createQuery("Select e From WorkoutExercise e Where workout_id = '" + id + "'")
                .getResultList();
        System.out.println(workoutExercises);
        return workoutExercises;
    }
}