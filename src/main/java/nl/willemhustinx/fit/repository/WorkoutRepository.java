package nl.willemhustinx.fit.repository;

import nl.willemhustinx.fit.model.Workout;

import javax.ejb.Stateless;

@Stateless
public class WorkoutRepository extends AbstractRepository<Workout> {

    @Override
    protected Class<Workout> getEntityClass() {
        return Workout.class;
    }
}