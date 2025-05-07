public class FullTimeStaffHire extends StaffHire 
{
//Attributes
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
  //Get and set
  public double getSalary(double salary){
     return salary;
    }
  public void setSalary(double salary){
     salary = salary;
    }
  public int getWeeklyFractionalHours(int weeklyFractionalHours){
     return weeklyFractionalHours;
    }
  public void setWeeklyFractionalHours(int weeklyFractionalHours){
     weeklyFractionalHours = weeklyFractionalHours;
    }
  @Override
  public void display() {
      super.display();
      System.out.println("Salary:"+salary);
      System.out.println("Weekly Fractional Hours:"+weeklyFractionalHours);
  }
}