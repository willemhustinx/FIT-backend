package nl.willemhustinx.fit.model;

import javax.persistence.Entity;

@Entity
public class WorkoutExerciseSet extends HasGeneratedId {
    private int amount;

    private int weight;

    public WorkoutExerciseSet() {
        super();
    }

    public WorkoutExerciseSet(int amount, int weight) {
        super();
        this.amount = amount;
        this.weight = weight;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ExerciseSet{" +
                "amount=" + amount +
                ", weight=" + weight +
                '}';
    }
}
