package nl.willemhustinx.fit.model;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Startup
@Singleton
public class DataStore {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    void init() {

        List<Object> mockdata = new ArrayList<>();

        Workout w1 = new Workout("Fitness", new Date());
        mockdata.add(w1);
        mockdata.add(new Workout("Krachttraining", new Date()));
        mockdata.add(new Workout("Krachttraining", new Date()));

        WorkoutExercise e1 = new WorkoutExercise("Leg press", w1, new ArrayList<WorkoutExerciseSet>());

        e1.addExerciseSets(new WorkoutExerciseSet(12, 12));
        e1.addExerciseSets(new WorkoutExerciseSet(12, 12));
        e1.addExerciseSets(new WorkoutExerciseSet(12, 12));
        mockdata.add(e1);
        mockdata.add(new WorkoutExercise("Bench press", w1, new ArrayList<WorkoutExerciseSet>()));
        mockdata.add(new WorkoutExercise("Pullup", w1, new ArrayList<WorkoutExerciseSet>()));

        for (Object o : mockdata) {
            em.persist(o);
        }

    }
}