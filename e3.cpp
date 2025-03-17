#include <iostream>
#include <vector>
using namespace std;
struct carro{
    string produ;
    int cantidad;
    float precio;
};

struct pedido{
    int n_pedido;
    int n_cliente;
    vector <carro> carrito;

};
/*
Se quiere hacer un sistema de gestión de pedidos de un Restaurante. Cada pedido tiene un número de pedido,
el nombre del cliente, una lista de productos, cantidades y precios. El sistema debe permitir:
Agregar un nuevo pedido con sus productos.

Cancelar un pedido buscando por el número de pedido.

Mostrar todos los pedidos en curso con el total de cada uno.

Calcular el ingreso total del día sumando los totales de todos los pedidos completados.


*/
void ing_pedido(vector<pedido> &pedidos){
    while(true){
        pedido aux;
        string opcion;
        cout<<"numero de pedido?"<<endl;
        cin>>aux.n_pedido;
        cout<<"nombre del cliente"<<endl;
        cin>>aux.n_cliente;
        while(true){
            carro auxiliar1;
            string pregunta;
            cout<<"nombre del producto"<<endl;
            cin>>auxiliar1.produ;
            cout<<"cantidad"<<endl;
            cin>>auxiliar1.cantidad;
            cout<<"precio?";
            cin>>auxiliar1.precio;
            cout<<"queres hacer otro ingreso?"<<endl;
            cin>>pregunta;
            aux.carrito.push_back(auxiliar1);
            if(pregunta !="si"){
                break;
            } 
        }
        pedidos.push_back(aux);
        cout<<"queres haver otro ingrso"<<endl;
        cin>>opcion;
        if(opcion!="si"){
            break;
        }
    }
};
void borrar_pedido(vector <pedido> &pedidos, int borrar){
    for (int i = 0; i <= pedidos.size(); i++)
    {
        if(borrar==pedidos[i].n_pedido){
            pedidos.erase(pedidos.begin() + i);
        }
    }
    
}
void mostrar_pedido(vector <pedido> pedidos){
    for (int i = 0; i <= pedidos.size(); i++)
    {
        cout<<"n° pedido: "<<pedidos[i].n_pedido<<endl;
        cout<<"nombre cliente: "<<pedidos[i].n_cliente<<endl;
        cout<<"el monto total sera: ";
        int monto_total=0;
        for (int j = 0; j <= pedidos[i].carrito.size(); j++)
        {
            monto_total += (pedidos[i].carrito[j].cantidad * pedidos[i].carrito[j].precio);
        }
         cout<<"el monto total sera: "<< monto_total;
        
    }
    
}
int total(vector <pedido> pedidos ){
    int monto_max=0;
     for (int i = 0; i <= pedidos.size(); i++){
        int monto_total=0;
        for (int j = 0; j <= pedidos[i].carrito.size(); j++)
        {
            monto_total += (pedidos[i].carrito[j].cantidad * pedidos[i].carrito[j].precio);
        }
        monto_max+=monto_total;
        
     }
     return monto_max;
}


int main(){
    vector <pedido> pedidos;
    while(true){
        string opcion1, opcion2;
        string var1;
        cout<<"quere ingresar?"<<endl;
        cin>>var1;
        if(var1=="si"){
            ing_pedido(pedidos);    
        }
        cout<<"queres cancelar un pedido"<<endl;
        cin>>opcion1;
        if(opcion1=="si"){
            int borra;
            cout<<"que pedido queres borrar"<<endl;
            cin>>borra;
            borrar_pedido(pedidos, borra);
        }
        cout<<"queres ver los pedidos"<<endl;
        cin>>opcion2;
         if(opcion2=="si"){
            mostrar_pedido(pedidos);
         }
         cout<<"el ingreso total del dia es: "<<total(pedidos);
         string bolli;
         cout<<"queres salir del sistema?"<<endl;
         cin>>bolli;
         if(bolli == "si"){
            break;
         }



    }
    


}