package com.ssr.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Cloneable {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private String empId;
    private String empName;
    private Date dob;       //Mutable field

    public Employee(String empId, String empName, String dob) {
        this.empId = empId;
        this.empName = empName;

        //Parsing the given String to Date object
        try {
            this.dob = formatter.parse(dob);
        } catch (ParseException e) {
            this.dob = null;
            e.printStackTrace();
        }
    }
    public Employee(Employee emp) {
        this.empId = emp.empId;
        this.empName = emp.empName;
        //Copy new date object to cloned method
        this.setDob((Date) emp.getDob().clone());
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        String strDate = dob==null ? "NULL" : formatter.format(dob);
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empDob='" + strDate + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Employee clone = null;
        clone = (Employee) super.clone();
        //Copy new date object to cloned method
        clone.setDob((Date) this.getDob().clone());
        return clone;
    }
}
