package SimpleBudget.controllers;

import SimpleBudget.dal.BudgetRepository;
import SimpleBudget.models.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budget/{budgetId}")
public class BudgetController {
    private final BudgetRepository budgetRepository;

    @RequestMapping(method = RequestMethod.GET)
    Budget get(@PathVariable int budgetId) {
        return this.budgetRepository.findOne(budgetId);
    }

    @Autowired
    public BudgetController(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }
}
