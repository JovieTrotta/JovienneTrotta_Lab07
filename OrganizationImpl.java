import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class represents an organization with employees.
 */

public class OrganizationImpl implements Organization {
    private Employee root;

    public OrganizationImpl(String nameCEO, double pay, Gender gender) {
        root = new InternalEmployee(nameCEO,pay,gender);
    }

    /**
     * The implementation below does not work. Why is that? Inspect the errors and change it around until it does.
     * (This method doesn't work b/c you're creating a copy as a non-manager, and not the original with its accompanying hierarchy)
     */
    @Override
    public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
        Employee newEmployee = new NonManagerEmployee(name,pay,gender);
        root = root.addSupervisee(supervisorName,newEmployee);
    }

    @Override
    public void addEmployee(Employee employee, String supervisorName) {
        root = root.addSupervisee(supervisorName,employee);
    }

    /**
     * The implementation below does not work. Why is that? Inspect the errors and change it around until it does.
     * (This method doesn't work b/c you're creating a copy as a non-manager, and not the original with its accompanying hierarchy)
     */
    @Override
    public void addContractEmployee(String name, double pay, Gender gender, int
            endDate, int endMonth, int endYear, String supervisorName) {
        Employee newEmployee = new ContractEmployee(name,pay,gender,endDate,endMonth,
                endYear);
        root = root.addSupervisee(supervisorName,newEmployee);
    }

    @Override
    public void addContractEmployee(Employee employee, String supervisorName){
        root = root.addSupervisee(supervisorName, employee);
    }

    @Override
    public int getSize() {
        return root.count(b -> true);
    }

    @Override
    public int getSize(Predicate<Employee> test) {
        return root.toList().stream()
                .map(e -> (test.test(e) ? Integer.valueOf(1) :Integer.valueOf(0)))
                .reduce(0, (a,b)->a+b);
    }

    /**
     * New method for this implementation.
     * Get the number of employees of a specified pay in this organization.
     * @param pay the double that you're checking for.
     * @return the number of employees that qualify in the organization.
     */
    public int getSizeByPay(Double pay) {
        return root.count(b -> b.getAnnualPay() == pay);
    }

    @Override
    public void printEmployees() {
        root.printEmployees();
    }

    @Override
    public int getSizeByGender(Gender gender) {
        return root.count(b -> b.getGender() == gender);
    }

    @Override
    public String allEmployees() {
        //This just returns a string rather than a list.
        return root.toList().stream().map(e->e.getName()).collect(Collectors.joining());

        /*Below would return a list of names rather than just a single string.
        return root.toList().stream().map(e->e.getName()).collect(Collectors
                .toList());
         */
    }

    @Override
    public int countPayAbove(double amount) {
        return root.count(b -> b.getAnnualPay() > amount);
    }

    @Override
    public int terminatedBefore(int date,int month,int year) {
        LocalDate threshold;

        try {
            threshold = LocalDate.of(year,month,date);
        }
        catch (DateTimeException e) {
            return 0;
        }
        return root.count(b->{
            if (b.getEmploymentEndDate().equals("XXXXXXXX"))
                return false;
            else {
                LocalDate d = LocalDate.parse(b.getEmploymentEndDate(),
                        DateTimeFormatter.ofPattern("MMddyyyy"));
                return d.compareTo(threshold)<0;
            }
        });
    }
}