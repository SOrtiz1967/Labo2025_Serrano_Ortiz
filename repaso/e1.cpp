#include <iostream>
#include <vector>
using namespace std;
/*
Crear la estructura Empleado que tiene un nombre, apellido, fecha de nacimiento,
sexo y salario.Se pide la función empleadoConMayorSueldo que recibe por parámetro 
un vector con todos los empleados de la empresa y otro vector vacío donde se
guardarán los empleados que tienen salario menor o igual a $400.000.La función deberá
recorrer todos los empleados de la empresa y retornar el de mayor sueldo. Además, a medida
que va recorriendo los empleados, debe agregar al otro vector los empleados cuyo salario
es menor o igual a $400.000.Por lo tanto, luego de llamar a la función,
se quiere mostrar en el main el empleado con mayor sueldo y mostrar el nombre
y apellido de todos los empleados con salario menor o igual a $400.000.
*/
//agregar la struct fecha para ser mas eficiente
struct empleado {
    string nombre;
    string apellido;
    int f_nacimiento;
    string sexo;
    int salario;
};
void ingreso(vector <empleado> &nomina){
    while(true){
        string var;
        empleado aux;
        cout<<"queres hacer un ingreso"<<endl;
        cin>>var;
        if(var=="no")
        {
            break;
        }
        cout<<"ingresa el nombre del empleado"<<endl;
        cin>>aux.nombre;
        cout<<"ingresa el apellido"<<endl;
        cin>>aux.apellido;
        cout<<"ingresa el nacimiento del empleado"<<endl;
        cin>>aux.f_nacimiento;
        cout<<"ingresa el sexo del empleado"<<endl;
        cin>>aux.sexo;
        cout<<"ingresa el sueldo del empleado"<<endl;
        cin>>aux.salario;

        
        nomina.push_back(aux);
    }
    };
    empleado empleadoConMayorSueldo(vector <empleado> nomina, vector <empleado> &nomina_barata)
    {
        empleado sobre=nomina[0];
        for (int i = 0; i < nomina.size(); i++)
        {
            if(sobre.salario<nomina[i].salario){
                sobre=nomina[i];
            }
            if(nomina[i].salario<=400000){
                nomina_barata.push_back(nomina[i]);
            }
        }
        
        return sobre;
    }
int main (){
    vector <empleado> nomina;
    vector <empleado> nomina_barata;
    empleado prime;
    cout<<"ingreso de empleados"<<endl;
    ingreso(nomina);
    prime=empleadoConMayorSueldo(nomina, nomina_barata);

    cout<<"el empleado que mas cobra es: "<<prime.nombre<<" y cobra: "<<prime.salario<<" pesos al mes"<<endl;
    cout<< "y los empleados que cobran menos de 400 k al mes son"<<endl;
    for(empleado ju : nomina_barata){
        cout<<ju.nombre<< " ";
        cout<<ju.apellido<<endl;
    }

}
