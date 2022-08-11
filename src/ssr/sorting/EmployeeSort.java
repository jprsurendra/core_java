package com.ssr.sorting;
import com.ssr.dto.Employee;

public class EmployeeSort {
    public static int sortEmployeeList(Employee emp1, Employee emp2){
        if(emp1.getEmpName()==emp2.getEmpName())
            return emp1.getDob().compareTo(emp2.getDob());
        else if(emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName())>0)
            return 1;
        else
            return -1;
    }
}
