package Payroll.management.system.demo.controller;

import Payroll.management.system.demo.employee.empolyee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class employeecontroller {

    private empolyee[] Employee = new empolyee[10];
    private int count = 3;

    public employeecontroller() {

        Employee[0] = new empolyee("Umar Ali", 40000, "Backend Developer");
        Employee[1] = new empolyee("Adnan Shah", 55000, "DevOps Engineer");
        Employee[2] = new empolyee("Talha Ishaque", 70000, "Frontend Developer");
    }


    @GetMapping("/all")
    public empolyee[] getallemployee() {
        return Employee;
    }


    @GetMapping("/all/{id}")
    public empolyee getemployeebyid(@PathVariable int id) {
        for (int i = 0; i < count; i++) {
            if (Employee[i] != null && Employee[i].getId() == id) {
                return Employee[i];
            }
        }
        return null;
    }


    @PostMapping("/newemp")
    public empolyee addEmployee(@RequestBody empolyee newEmp) {
        if (count < Employee.length) { // Prevent overflow
            Employee[count] = new empolyee(newEmp.getName(), newEmp.getSalary(), newEmp.getDesignation());
            return Employee[count++];
        }
        return null;
    }


    @PutMapping("/update/{id}")
    public empolyee updateEmployee(@PathVariable int id, @RequestBody empolyee updatedEmp) {
        for (int i = 0; i < count; i++) {
            if (Employee[i] != null && Employee[i].getId() == id) {
                Employee[i].setName(updatedEmp.getName());
                Employee[i].setSalary(updatedEmp.getSalary());
                Employee[i].setDesignation(updatedEmp.getDesignation());
                return Employee[i];
            }
        }
        return null;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        for (int i = 0; i < count; i++) {
            if (Employee[i] != null && Employee[i].getId() == id) {
                Employee[i] = null;
                return "Employee with ID " + id + " deleted successfully!";
            }
        }
        return "Employee not found!";
    }


    @PutMapping("/increment/{id}")
    public empolyee incrementSalary(@PathVariable int id, @RequestParam double percentage) {
        for (int i = 0; i < count; i++) {
            if (Employee[i] != null && Employee[i].getId() == id) {
                double newSalary = Employee[i].getSalary() * (1 + percentage / 100);
                Employee[i].setSalary(newSalary);
                return Employee[i];
            }
        }
        return null;
    }
}
