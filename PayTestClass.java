import java.util.function.Predicate;

public class PayTestClass implements Predicate<Employee> {
    private double pay;

    public PayTestClass(double pay) {
        this.pay = pay;
    }
    public boolean test(Employee employee) {
        if (employee.getAnnualPay() == pay) {
            return true;
        } else {
            return false;
        }
    }

}