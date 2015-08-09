package SimpleBudget.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
public class Budget {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer expenseLimit;

    @OneToMany(mappedBy = "budget")
    private Set<ExpenseCategory> expenseCategories;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getExpenseLimit() {
        return expenseLimit;
    }

    public Set<ExpenseCategory> getExpenseCategories() {
        return expenseCategories;
    }

    public Budget(String name, Integer expenseLimit) {
        this.name = name;
        this.expenseLimit = expenseLimit;
    }

    public Budget() {
    }
}
