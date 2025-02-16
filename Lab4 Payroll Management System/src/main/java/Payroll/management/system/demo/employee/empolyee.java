package Payroll.management.system.demo.employee;
import lombok.Setter;
public class empolyee {
    @Setter
    private String name;
    @Setter
    private double salary;
    private static int idCounter = 1; // Start ID from 1
    private int id;
    @Setter
    private String designation;
    public empolyee(String name, double salary, String designation) {
        this.id = idCounter++;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }
}
