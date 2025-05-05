public class FullTimeStaffHire extends StaffHire 
{
//Fields
private double salary;
private int weeklyFractionalHours;

// Constructure 
public FullTimeStaffHire (int vacancyNumber,String designation,String jobType,
                    String staffName,String joiningDate,String qualification,
                    String appointedBy,boolean joined,double salary,
                    int weeklyFractionalHours)
{
  //Call parent class 
    super(vacancyNumber,designation,jobType,staffName,joiningDate,qualification,
          appointedBy,joined);
          
     this.salary = salary;
     this.weeklyFractionalHours = weeklyFractionalHours;
  }
  public void setSalary(double salary){
      this.salary = salary;
  }
  @Override
  public void display() {
      super.display();
      System.out.println("Salary:"+salary);
      System.out.println("Weekly Fractional Hours:"+weeklyFractionalHours);
  }
}