import java.time.LocalDate;

class RecurringExpense extends Expense {
    private int frequency;

    public RecurringExpense(double amount, String category, LocalDate date, int frequency) {
        super(amount, category, date);
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}