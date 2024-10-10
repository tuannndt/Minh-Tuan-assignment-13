package asignment13;

class EMP_FULLTIME extends EMPLOYEE {
    private double coefficientSalary;

    public double getCoefficientSalary() {
        return coefficientSalary;
    }

    public void setCoefficientSalary(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    @Override
    public void Input() {
        super.Input();
        System.out.print("Enter Coefficient Salary: ");
        this.coefficientSalary = sc.nextDouble();
    }

    @Override
    public void Output() {
        super.Output();
        System.out.println("Coefficient Salary: " + this.coefficientSalary);
    }

    @Override
    public double CalculateSalary() {
        return BASIC_SALARY * coefficientSalary + CalculateAllowance();
    }

    @Override
    public double CalculateAllowance() {
        int seniority = CalculateSeniority();
        if (seniority >= 10) {
            return 1000000;
        } else if (seniority >= 5) {
            return 500000;
        } else {
            return 0;
        }
    }
}