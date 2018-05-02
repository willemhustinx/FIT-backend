package nl.willemhustinx.fit.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WorkoutExercise extends HasGeneratedId {
    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<WorkoutExerciseSet> workoutExerciseSets = new ArrayList<WorkoutExerciseSet>();

    public WorkoutExercise() {
        super();
    }

    public WorkoutExercise(String name, Workout workout, List<WorkoutExerciseSet> workoutExerciseSets) {
        this.name = name;
        this.workout = workout;
        this.workoutExerciseSets = workoutExerciseSets;
    }

    public void addWorkoutExerciseSets(WorkoutExerciseSet workoutExerciseSet) {
        this.workoutExerciseSets.add(workoutExerciseSet);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public List<WorkoutExerciseSet> getWorkoutExerciseSets() {
        return workoutExerciseSets;
    }

    public void setWorkoutExerciseSets(List<WorkoutExerciseSet> workoutExerciseSets) {
        this.workoutExerciseSets = workoutExerciseSets;
    }

    @Override
    public String toString() {
        return "WorkoutExercise{" +
                "name='" + name + '\'' +
                ", workout=" + workout +
                ", workoutExerciseSets=" + workoutExerciseSets +
                '}';
    }
}
