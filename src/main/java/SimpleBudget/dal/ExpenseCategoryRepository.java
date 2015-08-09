package SimpleBudget.dal;

import SimpleBudget.models.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by krzkaczor on 8/9/15.
 */
public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Integer> {
}
