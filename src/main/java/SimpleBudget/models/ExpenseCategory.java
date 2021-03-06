package SimpleBudget.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class ExpenseCategory {
    @JsonIgnore
    @ManyToOne
    private Budget budget;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private BigDecimal value;

    private String color;

    public Budget getBudget() {
        return budget;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public ExpenseCategory(Budget budget, String name, BigDecimal value, String color) {

        this.budget = budget;
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public ExpenseCategory() {
    }
}
