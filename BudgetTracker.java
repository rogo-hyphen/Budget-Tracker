import java.time.LocalDate;
import java.util.Scanner;

public class BudgetTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your monthly income: ");
        double income = scanner.nextDouble();
        scanner.nextLine();
        Budget budget = new Budget(income);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Recurring Expense");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter category name: ");
                    String categoryName = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter expense date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());

                    Expense expense = new Expense(amount, categoryName, date);
                    addExpenseToCategory(budget, categoryName, expense);
                    break;
                case 2:
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter expense date (yyyy-mm-dd): ");
                    date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter frequency (1 for weekly, 2 for monthly, 3 for yearly): ");
                    int frequency = scanner.nextInt();
                    scanner.nextLine();

                    RecurringExpense recurringExpense = new RecurringExpense(amount, categoryName, date, frequency);
                    addExpenseToCategory(budget, categoryName, recurringExpense);
                    break;
                case 3:
                    budget.viewSummary();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExpenseToCategory(Budget budget, String categoryName, Expense expense) {
        for (BudgetCategory category : budget.getCategories()) {
            if (category.getName().equals(categoryName)) {
                category.addExpense(expense);
                return;
            }
        }

        BudgetCategory newCategory = new BudgetCategory(categoryName, 0);
        newCategory.addExpense(expense);
        budget.addCategory(newCategory);
    }
}