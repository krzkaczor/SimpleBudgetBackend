package SimpleBudget;

import SimpleBudget.dal.BudgetRepository;
import SimpleBudget.dal.ExpenseCategoryRepository;
import SimpleBudget.models.Budget;
import SimpleBudget.models.ExpenseCategory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    @Bean
    CommandLineRunner init(BudgetRepository budgetRepository, ExpenseCategoryRepository expenseCategoryRepository) {
        return (evt) -> {
            Budget myBudget = new Budget("My Budget", new BigDecimal(1000));
            budgetRepository.save(myBudget);
            expenseCategoryRepository.save(new ExpenseCategory(myBudget, "Grocery", new BigDecimal(150), "#F7464A"));
            expenseCategoryRepository.save(new ExpenseCategory(myBudget, "Alcohol", new BigDecimal(100), "#46BFBD"));
        };
    }

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

    @Primary
    @Bean
    public ObjectMapper mapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(BigDecimal.class, new ToStringSerializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}