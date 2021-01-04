package FuckingAlgorithm.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode690 员工的重要性
 */
public class EmployeeImportance {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setImportance(5);
        employee.setSubordinates(Arrays.asList(101));

        Employee employee2 = new Employee();
        employee2.setId(101);
        employee2.setImportance(3);
        employee2.setSubordinates(Arrays.asList());

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);

        int importance = getImportance(employees, 2);
        System.out.println(importance);


    }

    public static int getImportance(List<Employee> employees, int id) {
        int imp = 0;
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).id==id){
                Employee employee = employees.get(i);
                imp += employee.importance;
                List<Integer> subordinates = employee.subordinates;
                for (int j = 0; j < subordinates.size(); j++) {
                    imp += getImportance(employees, subordinates.get(j));
                }
            }
        }
        return imp;
    }
}



class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }
};