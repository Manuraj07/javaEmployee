import java.util.ArrayList;
import java.util.List;

abstract class Employee{
	private String name;
	private int id;
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public abstract double calculateSalary();
	
	@Override
	public String toString() {
		return "Employee[ name = "+name+", id = "+id+",Salary = "+calculateSalary()+"]";
	}
}


class FullTimeEmployee extends Employee
{
	private double  monthlySalary;
	public FullTimeEmployee(String name,int id,double monthlySalary) {
		super(name,id);
		this.monthlySalary = monthlySalary;
		
	}
	@Override
	public double calculateSalary()
	{
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee{
	private int hoursWorks;
	private double hourlyRate;
	public PartTimeEmployee(String name,int id,int hoursWorks,double hourlyRate) {
		super(name,id);
		this.hourlyRate = hourlyRate;
		this.hoursWorks = hoursWorks;
	}
	@Override
	public double calculateSalary()
	{
		return  hourlyRate *hoursWorks;
	}
	
}


class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

//class PayrollSystem {
//	private ArrayList<Employee> employeeList;
//	public PayrollSystem()
//	{
//		employeeList = new ArrayList<>();
//	}
//	
//	public  void addEmployee(Employee employee)
//	{
//		employeeList.add(employee);
//	}
//	public void removeEmployee(int id)
//	{
//		Employee employeeToremove = null;
//		for(Employee x :employeeList)
//		{
//			if(employeeToremove.getId() == id) {
//				employeeToremove = x;
//				break;
//			}
//		}
//		if(employeeToremove != null)
//		{
//			employeeList.remove(employeeToremove);
//		}
//	}
//	
//	public void displayEmployee() {
//		for(Employee x:employeeList)
//		{
//			System.out.println(x);
//		}
//	}
//	
//	
//}






public class Main {

	public static void main(String[] args) {
		
		PayrollSystem py  = new PayrollSystem();
		FullTimeEmployee ft = new FullTimeEmployee("Manoranjan Kumar", 7, 25000);
		FullTimeEmployee ft1 = new FullTimeEmployee("Kishan Kumar", 10, 35000);
		FullTimeEmployee ft2 = new FullTimeEmployee("Raushan Kumar", 11, 45000);
		FullTimeEmployee ft3 = new FullTimeEmployee("Guddu Kumar", 13, 55000);
		FullTimeEmployee ft4 = new FullTimeEmployee("Rajeev", 21, 15000);
		
		py.addEmployee(ft);
		py.addEmployee(ft1);
		py.addEmployee(ft2);
		py.addEmployee(ft3);
		py.addEmployee(ft4);
		System.out.println("The Details of Employee are ...");
		py.displayEmployees();
		
		System.out.println("Remove the Employee...");
		py.removeEmployee(122);
		py.displayEmployees();
		
		
		
		
		
		
	}

}
