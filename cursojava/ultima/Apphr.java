package objetos;

import java.util.ArrayList;

public class HRApp {
    public static void main(String[] args) {
        System.out.println("HRApp Starts");

        Employe e1 = new Employe(1001010, "toto",100000);
        Employe e2 = new Employe(1091919,"juan",90000);



        Department dept = new Department("Education",new ArrayList<>());
        dept.addEmp(e1);
        dept.addEmp(e2);


        System.out.println("Emp"+e1);
        System.out.println("Emp"+e2);
        ArrayList<Employe>emps=dept.getEmploye();

        for (Employe e: emps){
            System.out.println("Emp"+e);
        }
        System.out.println("Total"+dept.getTotalSalary());
        System.out.println("Promedio"+dept.getAverageSalary());
        System.out.println("Emp"+dept.getEmployeeById(1001010));
    }
}
