import java.util.ArrayList;
import java.util.List;

class BudgetCategory {
    private String name;
    private double budgetLimit;
    private List<Expense> expenses;

    public BudgetCategory(String name, double budgetLimit) {
        this.name = name;
        this.budgetLimit = budgetLimit;
        this.expenses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBudgetLimit() {
        return budgetLimit;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}