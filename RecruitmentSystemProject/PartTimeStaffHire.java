
public class PartTimeStaffHire extends StaffHire
{
    
//Fields
private int workingHour;
private double wagesPerHour;
private String shifts;
private boolean terminated;

//Constructor 
public PartTimeStaffHire (int vacancyNumber,String designation,
                    String jobType,String staffName,String joiningDate,
                    String qualification,String appointedBy,boolean joined,
                    int workingHour,double wagesPerHour,String shifts) {
                    
//Call parent class 
  super(vacancyNumber,designation, jobType, staffName, joiningDate, qualification,
          appointedBy, joined);
         
 { this.workingHour = workingHour;
   this.wagesPerHour = wagesPerHour;
   this.shifts = shifts;
   this.terminated = false; }
}
public void setShifts(String shifts){
      this.shifts = shifts;
  }
public void terminate() {
    if (!terminated) {  
    this.terminated = true;
  }
}
  @Override
  public void display() 
  {
      super.display();
      System.out.println("Working Hours:"+ workingHour);
      System.out.println("Wages Per Hour:"+ wagesPerHour);
      System.out.println("Shifts:"+ shifts);
      System.out.println("Terminated:"+ terminated);
  }
}

