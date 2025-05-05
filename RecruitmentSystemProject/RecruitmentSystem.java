import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem implements ActionListener {
    private JTextField vacancyNumberField, designationField, jobTypeField, 
            staffNameField, joiningDateField, qualificationField, 
            appointedByField;
            
    private JTextField salaryField, weeklyFractionalHoursField, 
            workingHourField, wagesPerHourField, shiftsField, 
            displayNumberField;
            
    private JButton addFullTimeBtn, addPartTimeBtn, setSalaryBtn, setShiftBtn, 
            terminateBtn, displayBtn, clearBtn;

    private ArrayList<StaffHire> staffList = new ArrayList<>();

    public RecruitmentSystem() {
        JFrame frame = new JFrame("Recruitment System");
        frame.setSize(800, 700);
        frame.setLayout(new GridLayout(18, 2, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fields and Frame
        vacancyNumberField = createInputField(frame, "Vacancy Number:");
        designationField = createInputField(frame, "Designation:");
        jobTypeField = createInputField(frame, "Job Type:");
        staffNameField = createInputField(frame, "Staff Name:");
        joiningDateField = createInputField(frame, "Joining Date:");
        qualificationField = createInputField(frame, "Qualification:");
        appointedByField = createInputField(frame, "Appointed By:");
        salaryField = createInputField(frame, "Salary:");
        weeklyFractionalHoursField = createInputField(frame, "Weekly Fractional Hours:");
        workingHourField = createInputField(frame, "Working Hour:");
        wagesPerHourField = createInputField(frame, "Wages Per Hour:");
        shiftsField = createInputField(frame, "Shifts:");
        displayNumberField = createInputField(frame, "Display/Terminate Number:");

        // Buttons
        addFullTimeBtn = createButton(frame, "Add Full Time Staff");
        addPartTimeBtn = createButton(frame, "Add Part Time Staff");
        setSalaryBtn = createButton(frame, "Set Salary");
        setShiftBtn = createButton(frame, "Set Working Shift");
        terminateBtn = createButton(frame, "Terminate Part Time");
        displayBtn = createButton(frame, "Display Staff");
        clearBtn = createButton(frame, "Clear");

        frame.setVisible(true);
    }

    private JTextField createInputField(JFrame frame, String label) {
        frame.add(new JLabel(label));
        JTextField field = new JTextField();
        frame.add(field);
        return field;
    }

    private JButton createButton(JFrame frame, String text) {
        JButton btn = new JButton(text);
        btn.addActionListener(this);
        frame.add(btn);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addFullTimeBtn) addFullTimeStaff();
        else if (src == addPartTimeBtn) addPartTimeStaff();
        else if (src == setSalaryBtn) setSalary();
        else if (src == setShiftBtn) setShift();
        else if (src == terminateBtn) terminateStaff();
        else if (src == displayBtn) displayStaff();
        else if (src == clearBtn) clearFields();
    }

    // Action Methods Below

    private void addFullTimeStaff() {
        try {
            int vac = Integer.parseInt(vacancyNumberField.getText());
            double salary = Double.parseDouble(salaryField.getText());
            int hours = Integer.parseInt(weeklyFractionalHoursField.getText());
            StaffHire sh = new FullTimeStaffHire(vac, designationField.getText(),
                           jobTypeField.getText(), staffNameField.getText(), 
                           joiningDateField.getText(), 
                           qualificationField.getText(),
                           appointedByField.getText(), true, salary, hours);
                           
            staffList.add(sh);
            JOptionPane.showMessageDialog(null, "Full-time staff added.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input for full-time staff.");
        }
    }

    private void addPartTimeStaff() {
        try {
            int vac = Integer.parseInt(vacancyNumberField.getText());
            int hours = Integer.parseInt(workingHourField.getText());
            double wage = Double.parseDouble(wagesPerHourField.getText());
            StaffHire sh = new PartTimeStaffHire(vac, designationField.getText(), jobTypeField.getText(),
                    staffNameField.getText(), joiningDateField.getText(), qualificationField.getText(),
                    appointedByField.getText(), true, hours, wage, shiftsField.getText());
            staffList.add(sh);
            JOptionPane.showMessageDialog(null, "Part-time staff added.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input for part-time staff.");
        }
    }

    private void setSalary() {
        try {
            int vac = Integer.parseInt(vacancyNumberField.getText());
            double newSalary = Double.parseDouble(salaryField.getText());
            for (StaffHire s : staffList) {
                if (s instanceof FullTimeStaffHire fts && fts.getVacancyNumber() == vac) {
                    fts.setSalary(newSalary);
                    JOptionPane.showMessageDialog(null, "Salary updated.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Staff not found.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    private void setShift() {
        try {
            int vac = Integer.parseInt(vacancyNumberField.getText());
            String shift = shiftsField.getText();
            for (StaffHire s : staffList) {
                if (s instanceof PartTimeStaffHire pts && pts.getVacancyNumber() == vac) {
                    pts.setShifts(shift);
                    JOptionPane.showMessageDialog(null, "Shift updated.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Staff not found.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    private void terminateStaff() {
        try {
            int vac = Integer.parseInt(displayNumberField.getText());
            for (StaffHire s : staffList) {
                if (s instanceof PartTimeStaffHire pts && pts.getVacancyNumber() == vac) {
                    pts.terminate();
                    JOptionPane.showMessageDialog(null, "Staff terminated.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Staff not found.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    private void displayStaff() {
        try {
            int index = Integer.parseInt(displayNumberField.getText());
            if (index >= 0 && index < staffList.size()) {
                staffList.get(index).display();
            } else {
                JOptionPane.showMessageDialog(null, "Index out of range.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid display number.");
        }
    }

    private void clearFields() {
        JTextField[] fields = {
            vacancyNumberField, designationField, jobTypeField, staffNameField, joiningDateField,
            qualificationField, appointedByField, salaryField, weeklyFractionalHoursField,
            workingHourField, wagesPerHourField, shiftsField, displayNumberField
        };
        for (JTextField f : fields) f.setText("");
    }

    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}
