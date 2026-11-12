package com.example;

/**
 * Subclass representing a permanent employee with a basic salary and fixed allowance.
 */
public class PermanentEmployee extends Employee {
    public static final double FIXED_ALLOWANCE = 5000.0;
    private double basicSalary;

    public PermanentEmployee(int employeeId, String employeeName, double basicSalary) {
        super(employeeId, employeeName);
        this.basicSalary = basicSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + FIXED_ALLOWANCE;
    }
}
