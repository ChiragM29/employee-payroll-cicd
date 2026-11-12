package com.example;

/**
 * Abstract class representing a general Employee in the Payroll System.
 */
public abstract class Employee {
    protected int employeeId;
    protected String employeeName;

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Abstract method to calculate the monthly/contractual salary.
     * @return calculated salary as double
     */
    public abstract double calculateSalary();

    /**
     * Concrete method to display employee details and calculated salary.
     */
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.printf("Calculated Salary: Rupees %.2f%n", calculateSalary());
    }
}
