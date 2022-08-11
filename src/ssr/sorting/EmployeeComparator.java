package com.ssr.sorting;

import java.util.Comparator;

import com.ssr.dto.Employee;


public class EmployeeComparator<Employee>  implements Comparator<com.ssr.dto.Employee> {

    public int compare(com.ssr.dto.Employee emp1, com.ssr.dto.Employee emp2){
        if(emp1.getEmpName()==emp2.getEmpName())
            return emp1.getDob().compareTo(emp2.getDob());
        else if(emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName())>0)
            return 1;
        else
            return -1;
    }
}
