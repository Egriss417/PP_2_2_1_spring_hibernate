package hiber.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name = "car")
@Component
@Scope("prototype")
public class Car {


    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String model;
    @Column
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
    public Car() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "\nmodel: " + model + "\nseries: " + series;
    }
}
