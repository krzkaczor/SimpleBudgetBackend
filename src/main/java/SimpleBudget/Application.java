package SimpleBudget;

import SimpleBudget.dal.BudgetRepository;
import SimpleBudget.models.Budget;
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
    CommandLineRunner init(BudgetRepository budgetRepository) {
        return (evt) -> {
            budgetRepository.save(new Budget("MOJ BUDZET"));
            budgetRepository.save(new Budget("NIE MOJ BUDZET"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}