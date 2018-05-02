package nl.willemhustinx.fit.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Exercise extends HasGeneratedId {

    @NotNull
    private String name;

    public Exercise() {
        super();
    }

    public Exercise(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                '}';
    }
}
