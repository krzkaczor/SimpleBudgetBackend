package SimpleBudget.dal;

import SimpleBudget.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    Optional<Budget> findByName(String name);
}
