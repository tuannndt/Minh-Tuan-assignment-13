package asignment13;

import java.util.ArrayList;
import java.util.Scanner;

class EMP_LIST {

    private final ArrayList<EMPLOYEE> list = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void AddNew(EMPLOYEE emp) {
        list.add(emp);
    }

    public void Update(String EmpID) {
        EMPLOYEE emp = Find(EmpID);
        if (emp != null) {
            System.out.println("Updating employee...");
            emp.Input();
        } else {
            System.out.println("Employee not found!");
        }
    }

    public void Delete(String EmpID) {
        EMPLOYEE emp = Find(EmpID);
        if (emp != null) {
            list.remove(emp);
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found!");
        }
    }

    public EMPLOYEE Find(String EmpID) {
        for (EMPLOYEE emp : list) {
            if (emp.getEmpID().equals(EmpID)) {
                return emp;
            }
        }
        return null;
    }

    public void Menu() {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add new full-time employee");
            System.out.println("2. Add new part-time employee");
            System.out.println("3. Update employee details");
            System.out.println("4. Delete employee");
            System.out.println("5. Find employee by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    EMP_FULLTIME fullTimeEmp = new EMP_FULLTIME();
                    fullTimeEmp.Input();
                    AddNew(fullTimeEmp);
                    break;
                case 2:
                    EMP_PARTTIME partTimeEmp = new EMP_PARTTIME();
                    partTimeEmp.Input();
                    AddNew(partTimeEmp);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    String updateID = sc.nextLine();
                    Update(updateID);
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteID = sc.nextLine();
                    Delete(deleteID);
                    break;
                case 5:
                    System.out.print("Enter Employee ID to find: ");
                    String findID = sc.nextLine();
                    EMPLOYEE emp = Find(findID);
                    if (emp != null) {
                        emp.Output();
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 0:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Option wrong.");
                    break;
            }
        } while (choice != 0);
    }
}
