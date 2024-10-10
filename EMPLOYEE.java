package asignment13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

abstract class EMPLOYEE implements IEMPLOYEE {
    private String EmpID;
    private String EmpName;
    private Date EmpDateOfBirth;
    private Date StartDate;
    Scanner sc = new Scanner(System.in);
    
    public String getEmpID() {
        return EmpID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public Date getEmpDateOfBirth() {
        return EmpDateOfBirth;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setEmpID(String empID) {
        this.EmpID = empID;
    }

    public void setEmpName(String empName) {
        this.EmpName = empName;
    }

    public void setEmpDateOfBirth(Date empDateOfBirth) {
        this.EmpDateOfBirth = empDateOfBirth;
    }

    public void setStartDate(Date startDate) {
        this.StartDate = startDate;
    }

    public void Input() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter Employee ID: ");
        this.EmpID = sc.nextLine();
        
        System.out.print("Enter Employee Name: ");
        this.EmpName = sc.nextLine();
        
        System.out.print("Enter Employee Date of Birth (dd/MM/yyyy): ");
        try {
            this.EmpDateOfBirth = df.parse(sc.nextLine());
        } catch (ParseException e) {
            System.out.println("Wrong Format.");
        }
        
        System.out.print("Enter Start Date (dd/MM/yyyy): ");
        try {
            this.StartDate = df.parse(sc.nextLine());
        } catch (ParseException e) {
            System.out.println("Wrong Format");
        }
    }

    public void Output() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Employee ID: " + this.EmpID);
        System.out.println("Employee Name: " + this.EmpName);
        System.out.println("Employee Date of Birth: " + df.format(this.EmpDateOfBirth));
        System.out.println("Start Date: " + df.format(this.StartDate));
    }

    public int CalculateSeniority() {
        Date currentDate = new Date();
        long differenceInMillis = currentDate.getTime() - StartDate.getTime();
        int seniority = (int) (differenceInMillis / (1000 * 60 * 60 * 24 * 365));
        return seniority;
    }
}