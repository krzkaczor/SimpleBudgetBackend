package SimpleBudget.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Budget {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Budget() {
    }

    public Budget(String name) {

        this.name = name;
    }
}
