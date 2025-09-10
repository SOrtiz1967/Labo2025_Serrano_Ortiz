package objetos;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employe>employes = new ArrayList<>();
    private int ultimoempleadoagregadoIndex= -1;

    public Department(String name, ArrayList<Employe> employes) {
        this.name = name;
        this.employes = employes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(ArrayList<Employe> employes) {
        this.employes = employes;
    }

    public void addEmp(Employe anEmployee){
        if(ultimoempleadoagregadoIndex<employes.size()){
            ultimoempleadoagregadoIndex++;
            employes.add(anEmployee);
        }
    }


    public ArrayList<Employe> getEmploye(){
        ArrayList<Employe> actualizarEmpleados = new ArrayList<>();

        for (Employe e: employes){
            actualizarEmpleados.add(e);
        }
        return actualizarEmpleados;
    }

    public int getEmployescount(){
        return ultimoempleadoagregadoIndex+1;
    }

    public Employe getEmployeeById(int empId){
        for(Employe e: employes){

            if(empId==e.getID()){
                return e;
            }
        }
        return null;
    }


    public double getTotalSalary(){
        double totalSalario=0.0;
        for (Employe e: employes){
            totalSalario+=e.getSalary();
        }
        return totalSalario;
    }

    public double getAverageSalary(){
        if(ultimoempleadoagregadoIndex>-1){
            return getTotalSalary()/employes.size();
        }
        return 0.0;
    }
    public String toString(){
        return name;
    }
}
