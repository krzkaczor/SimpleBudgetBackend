package SimpleBudget;

import SimpleBudget.dal.BudgetRepository;
import SimpleBudget.dal.ExpenseCategoryRepository;
import SimpleBudget.models.Budget;
import SimpleBudget.models.ExpenseCategory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    @Bean
    CommandLineRunner init(BudgetRepository budgetRepository, ExpenseCategoryRepository expenseCategoryRepository) {
        return (evt) -> {
            Budget myBudget = new Budget("My Budget", 1000);
            budgetRepository.save(myBudget);
            expenseCategoryRepository.save(new ExpenseCategory(myBudget, "Grocery", 150, "#009933"));
            expenseCategoryRepository.save(new ExpenseCategory(myBudget, "Alcohol", 100, "#FF3300"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}