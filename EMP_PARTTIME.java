package asignment13;

class EMP_PARTTIME extends EMPLOYEE {

    private int numberOfWorkdays;

    public int getNumberOfWorkdays() {
        return numberOfWorkdays;
    }

    public void setNumberOfWorkdays(int numberOfWorkdays) {
        this.numberOfWorkdays = numberOfWorkdays;
    }

    @Override
    public void Input() {
        super.Input();
        System.out.print("Enter Number of Workdays: ");
        this.numberOfWorkdays = sc.nextInt();
    }

    @Override
    public void Output() {
        super.Output();
        System.out.println("Number of Workdays: " + this.numberOfWorkdays);
    }

    @Override
    public double CalculateSalary() {
        return (BASIC_SALARY * numberOfWorkdays) / 26 + CalculateAllowance();
    }

    @Override
    public double CalculateAllowance() {
        int seniority = CalculateSeniority();
        if (seniority >= 10) {
            return 500000;
        } else if (seniority >= 5) {
            return 300000;
        } else {
            return 0;
        }
    }
}
