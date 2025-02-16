package Payroll.management.system.demo.employee;

public class empolyee {
    private String name;
    private double salary;
    private static int idCounter = 1; // Start ID from 1
    private int id;
    private String designation;

    // Constructor that assigns an auto-incremented ID
    public empolyee(String name, double salary, String designation) {
        this.id = idCounter++; // Assign ID and increment the counter
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

    // Getters (No setter for ID because it should be auto-generated)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
