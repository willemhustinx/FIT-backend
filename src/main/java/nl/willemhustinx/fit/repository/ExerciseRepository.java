package nl.willemhustinx.fit.repository;

import nl.willemhustinx.fit.model.Exercise;

import javax.ejb.Stateless;

@Stateless
public class ExerciseRepository extends AbstractRepository<Exercise> {
    @Override
    protected Class<Exercise> getEntityClass() {
        return Exercise.class;
    }
}