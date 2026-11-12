package com.example;

/**
 * Main application class to demonstrate Employee Payroll System.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         EMPLOYEE PAYROLL MANAGEMENT SYSTEM       ");
        System.out.println("==================================================");

        // Instantiate Permanent Employee
        PermanentEmployee permanentEmployee = new PermanentEmployee(101, "Alice Johnson", 30000.0);

        // Instantiate Contract Employee
        ContractEmployee contractEmployee = new ContractEmployee(102, "Bob Smith", 160, 200.0);

        System.out.println("\n--- Permanent Employee Record ---");
        permanentEmployee.displayDetails();

        System.out.println("\n--- Contract Employee Record ---");
        contractEmployee.displayDetails();

        System.out.println("\n==================================================");
        System.out.println("Payroll processing completed successfully.");
        System.out.println("==================================================");
    }
}
