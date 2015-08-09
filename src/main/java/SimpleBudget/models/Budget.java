package SimpleBudget.models;

import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;


@Entity
public class Budget {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private BigDecimal expenseLimit;

    @OneToMany(mappedBy = "budget")
    private Set<ExpenseCategory> expenseCategories;


    @Formula("(select EXPENSE_LIMIT - SUM(c.VALUE) from EXPENSE_CATEGORY c where c.BUDGET_ID = ID)")
    private BigDecimal leftToSpend;

    //TODO:rewrite
    @Formula("(select (select EXPENSE_LIMIT - SUM(c.VALUE) from EXPENSE_CATEGORY c where c.BUDGET_ID = ID)/(DATEDIFF('d', CURDATE(), DATEADD('month', 1, CURDATE())) - DAY(CURDATE())) FROM BUDGET)")
    private BigDecimal dailyLimit;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getExpenseLimit() {
        return expenseLimit;
    }

    public Set<ExpenseCategory> getExpenseCategories() {
        return expenseCategories;
    }

    public BigDecimal getLeftToSpend() {
        return leftToSpend;
    }

    public BigDecimal getDailyLimit() {
        return dailyLimit;
    }

    public Budget(String name, BigDecimal expenseLimit) {
        this.name = name;
        this.expenseLimit = expenseLimit;
    }

    public Budget() {
    }
}
