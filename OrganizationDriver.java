/*
This is your starting point and your testing file. 
Except for task 3 the code should work without modifications once you have everything else implemented.
*/

class OrganizationDriver
{
	public static void main(String [] args)
	{
		/** The following are the employees you'll need to add to the organization.
		 * Decide who should be a non-manager employee, who should be a supervisor,
		 * and who should be a supervisee for this hierarchy to work. Review the module
		 * and talk with your classmates if you get stuck.
		 *
		 * Remember to add any missing parameters based on the type of employee you make them.
		 * Include at least one contract employee and at least two supervisors. You can generate
		 * more employees and change around this structure if you wish.
		 */

		ContractEmployee m1 = new ContractEmployee("Hank Hill", 300.00, Gender.Male, 26, 6, 2030);
		Supervisor m2 = new Supervisor("Ron Swanson", 350.00, Gender.Female);
		ContractEmployee m3 = new ContractEmployee("Norman Norton", 50.00, Gender.Male, 29, 10, 2040);
		InternalEmployee m4 = new InternalEmployee("Fred Kostos", 550.00, Gender.Male);
		Supervisor m5 = new Supervisor("Sarah Hemsworth", 1000.00, Gender.Female);
		InternalEmployee m6 = new InternalEmployee("Howard Scott", 300.00, Gender.Male);
		InternalEmployee m7 = new InternalEmployee("George Gant", 300.00, Gender.Male);
		Supervisor m8 = new Supervisor("Lin Dorset", 300.00, Gender.Female);
		InternalEmployee m9 = new InternalEmployee("Betty Ross", 300.00, Gender.Female);

		/**
		 * this will generate the organization, but double check:
		 * Do we need to make this person, Boss Boss, an employee as well?
		 */
		OrganizationImpl TestCorp = new OrganizationImpl("Boss Boss", 300000.00,Gender.UnDisclosed);

		/**
		 * The employees have been generated.
		 * Check to see if the hierarchy works!
		 */
		//This was part of the sample code provided by the module
		TestCorp.addEmployee(m2,"Boss Boss");
		TestCorp.addEmployee(m5,"Boss Boss");
		TestCorp.addEmployee(m8,"Boss Boss");
		TestCorp.addContractEmployee(m1, "Ron Swanson");
		TestCorp.addContractEmployee(m3, "Ron Swanson");
		TestCorp.addContractEmployee(m4, "Ron Swanson");
		TestCorp.addContractEmployee(m6, "Sarah Hemsworth");
		TestCorp.addContractEmployee(m7, "Sarah Hemsworth");
		TestCorp.addContractEmployee(m9, "Lin Dorset");
		System.out.println(TestCorp.getSize());

		//Task 1: 
		//Build an implementation that does this: Print all the employees along with all their information
		TestCorp.printEmployees();
		
		//Task 2:
		//Design a code segment to return a single int value: the number of employees who make 300.00 annually
		//Examine existing code to help with this task. getSizeByGender is a good example of this.
		//There was also an example implementation similar in the module.

		//There's three ways to do this. All of these should return the same result.
		//Josh helped me solve the first method, then walked me through the second two just for fun.

		//METHOD ONE: uses the getSizeByPay method in the OrganizationImpl, modeled after getSizeByGender.
		System.out.println(TestCorp.getSizeByPay(300.00));

		//METHOD TWO: builds out the predicate as a separate PayTestClass class...
		//...and uses overloaded getSize method that takes a predicate and counts the number of "true" returns.
		//PayTestClass test = new PayTestClass((300.00));
		//System.out.println(TestCorp.getSize(test));

		//METHOD THREE: uses the method overload getSize in OrganizationImpl...
		//...and passes a lambda statement as an argument instead of the Predicate class.
		//System.out.println(TestCorp.getSize(m->m.getAnnualPay()==300.00));
		
		//Task 3: 
		//Print out a list of just employee names using allEmployees()
		//This function should return a string of all employee names that you can then print as output
		System.out.println(TestCorp.allEmployees());
	}
}