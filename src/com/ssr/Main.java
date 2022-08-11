package com.ssr;

import com.ssr.anonymous.DummyParentClass;
import com.ssr.dto.Employee;
import com.ssr.lambda.*;
import com.ssr.sorting.EmployeeComparator;

import java.util.*;
import java.util.stream.Collectors;


public class Main{
    public static void main_anonymous(String[] args){
        DummyParentClass anonymous = new DummyParentClass(){
                                            public void method1(String s){
                                                System.out.println("This is implementation of anonymous class");
                                            }
                                            public void method3(){
                                                System.out.println("This is implementation of anonymous class, but I can override it.");
                                            }
                                        };
        anonymous.method1("ssr");
        anonymous.method2();
        anonymous.method3();
    }
    public static void main_lamda_expressions_01(String[] args){
        // lambda expression to define the calculate method
        Square lamda_01 = (int x)->{
            System.out.println("This is implementation of lambda expression");
            return x*x;
        };
        int square_of_num = lamda_01.calculate(5);
        System.out.println("Out put of lambda expression: "+ square_of_num);

        /*
        In case of single line body of function, you can remove "{", "}", "arguments type" and "return statment".
        */
        // Square lamda_02 = (int x)->  x*x;
        // Square lamda_02 = (x)->  x*x; // you can remove arg's data type also
        Square lamda_02 = x->  x*x; // you can remove arg's () also in case of single argument
        square_of_num = lamda_02.calculate(2);
        System.out.println("Out put of lambda expression: "+ square_of_num);

        /*
        @FunctionalInterface annotation is not mandatory to use this annotation.
        */
        Cube lamda_03 = (int x)->  x*x*x;
        int cube_of_num = lamda_03.calculate(3);
        System.out.println("Out put of lambda expression: "+ cube_of_num);
    }

    public static void main_arraylist_sort(String[] args) throws CloneNotSupportedException {
        List<Employee> employeeListClone = new ArrayList<Employee>();

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.addAll(Arrays.asList(
                        new Employee("E001","Dhruv", "10/07/2001"),
                        new Employee("E002","Abhi","10/07/1999"),
                        new Employee("E003","Yaman", "10/07/2005"),
                        new Employee("E004","James","10/07/2003"),
                        new Employee("E005","Rishi", "10/07/2010"),
                        new Employee("E006","Abhi","10/07/1990")
                    ));

        Iterator<Employee> iterator = employeeList.iterator();
        while(iterator.hasNext()){
            employeeListClone.add((Employee) iterator.next().clone()); //Add the object clones
        }

        //clone with java 8
        List<Employee> clonedEmployeeList = employeeList.stream().map(Employee::new).collect(Collectors.toList());
        List<Employee> clonedEmployeeList2 = employeeList.stream().map(Employee::new).collect(Collectors.toList());
        List<Employee> clonedEmployeeList3 = employeeList.stream().map(Employee::new).collect(Collectors.toList());


        System.out.println(employeeList);
        EmployeeComparator comparator = new EmployeeComparator();
        Collections.sort(employeeList, comparator);
        System.out.println(employeeList);

        System.out.println("-------------------------------");

        System.out.println(employeeListClone);
        Collections.sort(employeeListClone, new EmployeeComparator(){
            public int compare(Employee emp1, Employee emp2){
                if(emp1.getEmpName()==emp2.getEmpName())
                    return emp2.getDob().compareTo(emp1.getDob());
                else if(emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName())>0)
                    return 1;
                else
                    return -1;
            }
        });
        System.out.println(employeeListClone);

        System.out.println("-------------------------------");

        System.out.println(clonedEmployeeList);
        Collections.sort(clonedEmployeeList, (Employee emp1, Employee emp2) -> {
            if(emp1.getEmpName()==emp2.getEmpName())
                return emp1.getDob().compareTo(emp2.getDob());
            else if(emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName())>0)
                return 1;
            else
                return -1;
        });
        System.out.println(clonedEmployeeList);

        System.out.println("-------------------------------");

        System.out.println(clonedEmployeeList2);
        // Collections.sort(clonedEmployeeList2, (Employee emp1, Employee emp2) -> {
        //     return emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName());
        // });
        Collections.sort(clonedEmployeeList2, (emp1, emp2) -> emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName()));
        System.out.println(clonedEmployeeList2);

        System.out.println("-------------------------------");
        // using Method Refrance
        System.out.println(clonedEmployeeList3);
        // Collections.sort(clonedEmployeeList2, (Employee emp1, Employee emp2) -> {
        //     return emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName());
        // });
        //Collections.sort(clonedEmployeeList2, (emp1, emp2) -> emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName()));
        Collections.sort(clonedEmployeeList3,  Comparator.comparing(Employee::getEmpName));
        System.out.println(clonedEmployeeList3);


    }

    public static void main(String[] args) {
        //        Main.main_anonymous(args);
        //        System.out.println("---------------------------------------");
        //        Main.main_lamda_expressions_01(args);
        //        System.out.println("---------------------------------------");
        try {
            Main.main_arraylist_sort(args);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
/*
package com.ssr;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
 */