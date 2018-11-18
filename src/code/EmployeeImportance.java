package code;

import java.util.List;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class EmployeeImportance {

    static class Solution {
        public int getImportance(List<Employee> employees, int id) {
            return 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
