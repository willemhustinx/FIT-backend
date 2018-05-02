package nl.willemhustinx.fit.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Workout extends HasGeneratedId {

    @NotNull
    private String name;

    private Date date;

    public Workout() {
        super();
    }

    public Workout(String name, Date date) {
        super();
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
