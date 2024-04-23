import java.util.ArrayList;
import java.util.List;

class Budget {
    private double income;
    List<BudgetCategory> categories;

    public Budget(double income) {
        this.income = income;
        this.categories = new ArrayList<>();
    }

    public void addCategory(BudgetCategory category) {
        categories.add(category);
    }

    public void addExpense(String categoryName, Expense expense) {
        for (BudgetCategory category : categories) {
            if (category.getName().equals(categoryName)) {
                category.getExpenses().add(expense);
                break;
            }
        }
    }

    public void viewSummary() {
        double totalExpenses = 0;
        for (BudgetCategory category : categories) {
            double categoryExpenses = 0;
            for (Expense expense : category.getExpenses()) {
                categoryExpenses += expense.getAmount();
            }
            totalExpenses += categoryExpenses;
            System.out.println(category.getName() + " expenses: " + categoryExpenses);
        }
        System.out.println("Total expenses: " + totalExpenses);
        System.out.println("Remaining budget: " + (income - totalExpenses));
    }

    public List<BudgetCategory> getCategories() {
        return categories;
    }
}