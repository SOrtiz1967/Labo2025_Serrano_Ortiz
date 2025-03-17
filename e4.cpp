#include <iostream>
#include <vector>
using namespace std;

/*Se quiere hacer un sistema de gestión de pacientes en una clínica. Cada paciente tiene los siguientes datos: nombre, edad, número de historia clínica, y fecha de próxima cita (día, mes y año como una estructura de tipo Fecha). El sistema debe permitir:
Registrar nuevos pacientes y asignarles una fecha de cita.

Cancelar una cita buscando al paciente por número de historia clínica.

Mostrar todas las citas programadas para un día específico.

Buscar y mostrar información de un paciente usando su número de historia clínica.*/
struct fecha{
    int dia;
    int mes;
    int anio;
};
struct paciente{
    string nombre;
    int edad;
    int n_h_cl;
    fecha fecha_p_c;

};
void registro_de_datos_citas(vector <paciente> &pacientes){
    paciente paciente_generico;
    bool condicion=true;
    int numero=1;
    while(condicion==true){
        cout<<"Ingrese el nombre del paciente: "<<endl;
        cin>>paciente_generico.nombre;
        cout<<"Ingrese la edad del paciente: "<<endl;
        cin>>paciente_generico.edad;
        cout<<"Ingrese el numero de historia clinica del paciente:"<<endl;
        cin>>paciente_generico.n_h_cl;
        cout<<"Ingrese dia, mes y año de la fecha de proxima cita: "<<endl;
        cin>>paciente_generico.fecha_p_c.dia;
        cin>>paciente_generico.fecha_p_c.mes;
        cin>>paciente_generico.fecha_p_c.anio;
        pacientes.push_back(paciente_generico);
        cout<<"Desea continuar ingresando pacientes, de ser así ingrese 1 y de no serlo ingrese 2: ";
        cin>>numero;
        if(numero==2){
            condicion=false;
            break;
        }
    }
}
void cancelar_cita(vector <paciente> &pacientes){
    int numero_paciente;
    cout<<"ingrese el numero de paciente al cual desea cancelarle la cita: "<<endl;
    cin>>numero_paciente;
    for(int i=0;i<pacientes.size();i++){
        if(pacientes[i].n_h_cl==numero_paciente){
            pacientes[i].fecha_p_c.dia=0;
            pacientes[i].fecha_p_c.mes=0;
            pacientes[i].fecha_p_c.anio=0;
        }
    }
}
void mostrar_citas_programadas(vector<paciente>pacientes){
    fecha dias;
    cout<<"ingrese dia: "<<endl;
    cin>>dias.dia;
    cout<<"ingrese mes: "<<endl;
    cin>>dias.mes;
    cout<<"ingrese anio: "<<endl;
    cin>>dias.anio;

    for(int i=0;i<pacientes.size();i++){
        if(pacientes[i].fecha_p_c.dia==dias.dia&&pacientes[i].fecha_p_c.mes==dias.mes&&pacientes[i].fecha_p_c.anio==dias.anio){
            cout<<"numero de paciente: "<<pacientes[i].n_h_cl<<endl;
        }
    }        
}
void mostrar_info(vector <paciente>pacientes){
    int numero_paciente;
    cout<<"ingrese el numero de paciente al cual desea ver informacion: "<<endl;
    cin>>numero_paciente;
    for(int i=0;i<pacientes.size();i++){
        if(pacientes[i].n_h_cl==numero_paciente){
            cout<<"nombre: "<<pacientes[i].nombre<<endl;
            cout<<"edad: "<<pacientes[i].edad<<endl;
            cout<<"numero: "<<pacientes[i].n_h_cl<<endl;
        }
    }
}

int main(){

    vector <paciente> pacientes;
    bool condicion=true;
    int numero;
    while(condicion){
        cout<<"1.registro"<<endl;
        cout<<"2.cancelar cita"<<endl;
        cout<<"3.mostrar citas programadas"<<endl;
        cout<<"4.mostrar info"<<endl;
        cout<<"5.salir"<<endl;
        cin>>numero;
    switch(numero){
        case 1:
            registro_de_datos_citas(pacientes);
            break;
        case 2:
            cancelar_cita(pacientes);
            break;
        case 3:
            mostrar_citas_programadas(pacientes);
            break;
        case 4:
            mostrar_info(pacientes);
            break;
        case 5:
            condicion=false;
            break;                

    }    
    
}
}