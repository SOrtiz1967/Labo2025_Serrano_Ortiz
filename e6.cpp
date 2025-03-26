#include <iostream>
#include <vector>
using namespace std;

/*

Realizar un sistema para la organización de un torneo de futbol. El torneo está compuesto por 24 equipos, cada uno está conformado por: un nombre, 11 jugadores (1 jugador es el arquero), la cantidad de goles a favor y en contra, la posición en el torneo (Determinada por los resultados de los partidos: Las Victorias suman : +3, los Empates suman: +1 y las Derrotas suman: +0) y el historial de partidos (Se guardará en formato: V, E, D).

Ademas, cada partido debe registrar los siguientes datos: El nombre de los equipos (Local y Visitante), cantidad de goles anotados por cada equipo, la fecha y el estadio donde se disputó.
Requerimientos:

    Se deberá implementar al menos 3 estructuras y 4 funciones.

Funcionalidades:

    El usuario deberá poder ingresar todos los equipos al sistema.

    El usuario deberá poder registrar todos los datos de cada partido, actualizando la información de los equipos que jugaron.

    El usuario deberá poder mostrar por pantalla, la información de un partido especifico, seleccionando los nombres de los equipos que se enfrentaron.

    El usuario deberá poder mostrar la tabla de posiciones del torneo, ordenada de mayor a menor según la puntuación. En caso de empate en la puntuación, el desempate se realizara en base a la Cantidad de goles a favor (De mayor a menor). La tabla debe mortrar: Posición - Nombre del equipo - Cantidad de goles a favor - Cantidad de goles en contra - Historial de partidos.

*/
struct fecha{
    int dia, mes, anio;
};
struct jugador{
    string nombre, posicion;
};

struct equipo{
    string nombre;
    jugador jugadores[11];
    int gol_f, gol_c, posicion, puntos;


};

struct partido{
    string nombre_l, nombre_v, estadio;
    int gol_l, gol_v;
    fecha fechita;
};

void ingresar_equipos(equipo torneo[],int tamanio){
    for(int i=0;i<tamanio;i++){
        cout<<"Ingrese los datos del equipo:"<<endl;
        cout<<"nombre: "<<endl;
        cin>>torneo[i].nombre;
        for(int j=0;j<11;j++){
            cout<<"Ingrese el nombre y la posicion(10 jugadores y 1 arquero): "<<endl;
            cout<<"nombre: "<<endl;
            cin>>torneo[i].jugadores[j].nombre;
            cout<<"posicion: "<<endl;
            cin>>torneo[i].jugadores[j].posicion;
        }
    }
}
void partido_jugado(equipo torneo[],int tamanio,vector <partido> &partidos){
    bool condicion=1;
    partido partido_a;
    while(condicion){
        cout<<"Ingrese nombre equipo local: "<<endl;
        cin>>partido_a.nombre_l;
        cout<<"Ingrese nombre equipo visitante: "<<endl;
        cin>>partido_a.nombre_v;
        cout<<"Ingrese nombre del estadio: "<<endl;
        cin>>partido_a.estadio;
        cout<<"Ingrese goles del local: "<<endl;
        cin>>partido_a.gol_l;
        cout<<"Ingrese goles del visitantes: "<<endl;
        cin>>partido_a.gol_v;
        cout<<"Ingrese el dia: "<<endl;
        cin>>partido_a.fechita.dia;
        cout<<"Ingrese el mes: "<<endl;
        cin>>partido_a.fechita.mes;
        cout<<"Ingrese el año: "<<endl;
        cin>>partido_a.fechita.anio;
        for(equipo equip:torneo){
            if(equip.nombre==partido_a.nombre_l){
                equip.gol_f+=partido_a.gol_l;
                equip.gol_c+=partido_a.gol_v;
                if(partido_a.gol_l>partido_a.gol_v){
                    equip.puntos+=3;
                }
                else if(partido_a.gol_l==partido_a.gol_v){
                    equip.puntos+=1;
                }
            }
            if(equip.nombre==partido_a.nombre_v){
                equip.gol_f+=partido_a.gol_v;
                equip.gol_c+=partido_a.gol_l;
                if(partido_a.gol_l<partido_a.gol_v){
                    equip.puntos+=3;
                }
                else if(partido_a.gol_l==partido_a.gol_v){
                    equip.puntos+=1;
                }
            }
        }
        partidos.push_back(partido_a);
        cout<<"ingrese 1 si quiere seguir y 0 si quiere dejar de ingresar partidos: "<<endl;
        cin>>condicion;
        break;
    }
}
void ver_info_partido(vector<partido> partidos){
    string equipo_local, equipo_visitante;
    cout<<"ingrese el nombre del equipo local y visitante: "<<endl;
    cin>>equipo_local;
    cin>>equipo_visitante;
    for(partido parti:partidos){
        if(parti.nombre_l==equipo_local&&parti.nombre_v==equipo_visitante){
            cout<<"nombre del equipo local:"<<parti.nombre_l<<endl;
            cout<<"nombre del equipo visitante:"<<parti.nombre_v<<endl;
            cout<<"nombre del estadio:"<<parti.estadio<<endl;
            cout<<"goles del local:"<<parti.gol_l<<endl;
            cout<<"goles del visitante:"<<parti.gol_l<<endl;
            cout<<"fecha:"<<parti.fechita.dia<<"/"<<parti.fechita.mes<<"/"<<parti.fechita.anio<<endl;
        }
    }
}
int main(){
    const int tamanio=24;
    vector <partido> partidos;
    equipo torneo[tamanio];
    ingresar_equipos(torneo, tamanio);
}