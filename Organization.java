import java.util.function.Predicate;

/**
 * This interface represents an organization. It includes methods that an
 * organization is expected to offer.
 */

public interface Organization {
  /**
   * Add an employee to this organization with the given specifics and
   * supervisor. This employee will not be added to the organization if the
   * supervisor cannot be found.
   * @param name name of employee to be added
   * @param pay the annual pay of this employee
   * @param gender the gender of this employee
   * @param supervisorName the name of the supervisor. The supervisor should
   *                       be an existing employee
   */
  void addEmployee(String name, double pay, Gender gender, String supervisorName);

  /**Add an employee from an existing employee object.
   * @param employee Employee object to be added.
   * @param supervisorName the name of the supervisor. The supervisor should be an existing employee.
   */
  void addEmployee(Employee employee, String supervisorName);

  /**
   * Add a contract employee to this organization with the given specifics
   * and supervisor. This employee will not be added to the organization if the
   * supervisor cannot be found.
   * @param name name of employee to be added
   * @param pay the annual pay of this employee
   * @param gender the gender of this employee
   * @param endDate the date on which this employee's contract ends
   * @param endMonth the month in which this employee's contract ends
   * @param endYear the year in which this employee's contract ends
   * @param supervisorName the name of the supervisor. The supervisor should
   *                       be an existing employee
   */
  void addContractEmployee(String name, double pay, Gender gender, int
          endDate, int endMonth, int endYear, String supervisorName);

  /**Add a contract employee from an existing ContractEmployee object.
   * @param employee the existing ContractEmployee object.
   * @param supervisorName the name of the supervisor. The supervisor should be an existing employee
   */
  void addContractEmployee(Employee employee, String supervisorName);

  /**
   * Get the size of the organization, i.e. the total number of employees in
   * this organization.
   * @return the number of employees in this organization
   */
  int getSize();

  /**
   * Get the size of the organization, i.e. the total number of employees in
   * this organization.
   * @param test is the Predicate test for employees
   * @return the number of employees in this organization
   */
  int getSize(Predicate<Employee> test);

  /**
   * Print the information for all the employees in the organization.
   * @return a list of information for all the employees in the organization.
   */
  void printEmployees();

  /**
   * Get the number of employees of the specified gender in this organization.
   * @param gender the specific gender that must be counted
   * @return the number of employees of the specified gender in this
   * organization
   */
  int getSizeByGender(Gender gender);

  /**
   * Get a String of names of all employees in this organization.
   * @return a String of names of all employees.
   */
   String allEmployees();

  /**
   * Get a list of names of all employees in this organization.
   * @return a list of names of all employees as a list of {@link String}
   * This is the original implementation. I created a new method (above) that just returns a String, per the directions.
   */
  //List<String> allEmployees();

  //Removed for new implementation
  // List<String> allEmployees(Predicate<Employee> predicate);

  /**
   * Return the number of employees whose annual pay is above the specified
   * amount
   * @param amount the lower threshold of the annual pay
   * @return the number of employees whose annual pay is above the specified
   * amount
   */
   //Removed for new implementation
  int countPayAbove(double amount);

  /**
   * Return the number of employees who are scheduled to be terminated before
   * a specific date
   * @param date the date of termination
   * @param month the month of termination
   * @param year the year of termination
   * @return the number of employees who will be scheduled before this
   * specific date
   */
   //Removed for new implementation
  int terminatedBefore(int date, int month, int year);
}