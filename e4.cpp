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
}
struct paciente{
    string nombre;
    int edad;
    int n_h_cl;
    fecha fecha_p_c;

}
void registro_de_datos_citas(vector <paciente> &pacientes){
    paciente paciente_generico;
    while()
}

int main(){
    vector <paciente> pacientes;
}