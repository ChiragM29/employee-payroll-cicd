package com.example;

/**
 * Subclass representing a contract employee whose salary is calculated by working hours and hourly rate.
 */
public class ContractEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public ContractEmployee(int employeeId, String employeeName, int workingHours, double hourlyRate) {
        super(employeeId, employeeName);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }
}
