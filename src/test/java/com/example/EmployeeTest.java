package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit 5 test suite for Employee Payroll System.
 */
public class EmployeeTest {

    private PermanentEmployee permanentEmployee;
    private ContractEmployee contractEmployee;

    @BeforeEach
    void setUp() {
        permanentEmployee = new PermanentEmployee(101, "Alice Johnson", 30000.0);
        contractEmployee = new ContractEmployee(102, "Bob Smith", 160, 200.0);
    }

    @Test
    @DisplayName("Verify PermanentEmployee salary calculation adds fixed allowance of 5000.0")
    void testPermanentEmployeeSalary() {
        double expectedSalary = 30000.0 + 5000.0; // 35000.0
        assertEquals(expectedSalary, permanentEmployee.calculateSalary(), 0.001,
                "Permanent employee salary must be basic salary + 5000.0");
        assertTrue(permanentEmployee.calculateSalary() > permanentEmployee.getBasicSalary(),
                "Permanent employee calculated salary should exceed basic salary by allowance");
    }

    @Test
    @DisplayName("Verify PermanentEmployee with 0.0 basic salary returns fixed allowance 5000.0")
    void testPermanentEmployeeZeroBasic() {
        PermanentEmployee zeroBasicEmp = new PermanentEmployee(103, "Charlie Brown", 0.0);
        assertEquals(5000.0, zeroBasicEmp.calculateSalary(), 0.001,
                "Permanent employee with 0.0 basic salary must return 5000.0 allowance");
        assertTrue(zeroBasicEmp.calculateSalary() == 5000.0,
                "Calculated salary must be strictly equal to 5000.0");
    }

    @Test
    @DisplayName("Verify ContractEmployee salary calculation multiplies workingHours by hourlyRate")
    void testContractEmployeeSalary() {
        double expectedSalary = 160 * 200.0; // 32000.0
        assertEquals(expectedSalary, contractEmployee.calculateSalary(), 0.001,
                "Contract employee salary must be workingHours * hourlyRate");
        assertTrue(contractEmployee.calculateSalary() == 32000.0,
                "Calculated salary for 160 hrs @ 200.0 must be 32000.0");
    }

    @Test
    @DisplayName("Verify ContractEmployee with 0 working hours returns 0.0")
    void testContractEmployeeZeroHours() {
        ContractEmployee zeroHoursEmp = new ContractEmployee(104, "David Miller", 0, 250.0);
        assertEquals(0.0, zeroHoursEmp.calculateSalary(), 0.001,
                "Contract employee with 0 working hours must return 0.0 salary");
        assertTrue(zeroHoursEmp.calculateSalary() == 0.0,
                "Calculated salary with 0 hours must evaluate to 0.0");
    }

    @Test
    @DisplayName("Verify object instantiation and non-null data members")
    void testEmployeeDetailsNotNull() {
        assertNotNull(permanentEmployee, "PermanentEmployee instance must not be null");
        assertNotNull(contractEmployee, "ContractEmployee instance must not be null");
        assertNotNull(permanentEmployee.getEmployeeName(), "Permanent employee name must not be null");
        assertNotNull(contractEmployee.getEmployeeName(), "Contract employee name must not be null");
        assertTrue(permanentEmployee.getEmployeeId() > 0, "Permanent employee ID must be positive");
        assertTrue(contractEmployee.getEmployeeId() > 0, "Contract employee ID must be positive");
    }
}
