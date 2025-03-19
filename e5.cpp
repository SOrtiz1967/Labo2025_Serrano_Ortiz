#include <iostream>
#include <vector>
using namespace std;
/*
Realizar un sistema para la gestión de un McDonald’s. El sistema cuenta con un menú de
20 productos diferentes, cada uno esta conformado por: Un nombre, si tiene promoción o no,
cantidad de ventas, el precio y la categoría a la que pertenece (Hamburguesa, Bebida, Postre,
etc.). Ademas, cada pedido realizado debe registrar los siguientes datos: El nombre del
cliente, productos pedidos, cantidad de cada producto, la fecha que se pidió y el precio total.
Requerimientos:

Se deberá implementar al menos 2 estructuras y 4 funciones.

Funcionalidades:

    El usuario, antes de poder realizar cualquier acción en el sistema, 
    deberá ingresar todos los productos al mismo.

    Luego de cargar los productos al sistema, el usuario deberá poder registrar
    un pedido, calculando automáticamente el precio total, considerando las promociones
    activas (Para los productos que tienen promociones activas, se les aplicará un descuento
    del 20% al precio del producto).

    El usuario deberá poder consultar un pedido específico por el nombre del cliente. 
    Mostrando por pantalla la información del pedido.

    El sistema deberá mostrar por pantalla los productos ordenados por ventas de mayor a menor.
*/

struct producto{
    string nombre;
    bool promocion;
    int cVentas;
    int precio;
    string cat;
};
struct fp{
    int dia;
    int mes;
    int año;
};
struct carro{
    string prod;
    int cantidad;
};
struct pedido{
    string nombre;
    vector <carro> carrito;
    fp fPedido;
    int montoT;

};

void calcularMonto(pedido &aux, producto productos[20]){
    int monto=0; 
    for (int i = 0; i < aux.carrito.size(); i++)
    {
        for (int j = 0; j < 20; j++)
        {
            if(aux.carrito[i].prod== productos[j].nombre){
                monto+= productos[j].precio * aux.carrito[i].cantidad;
                if(productos[j].promocion==true){
                    monto=monto/0.20;
                }
            }
        }
        
    }
    aux.montoT=monto;
    
};
void ingPedido (vector <pedido> &pedidos, producto productos[20]){
    pedido aux;
    bool opcion=true;
    cout<<"cual es tu nombre"<<endl;
    cin>>aux.nombre;
    while(opcion){
        
        int contador=0;
        carro agre;
        string prod;
        cout<<"q produ quere"<<endl;
        cin>>prod;
        for (int i = 0; i < 20; i++)
        {
            if(prod == productos[i].nombre){
                agre.prod=prod;
                cout<<"cantidad?"<<endl;
                cin>>agre.cantidad;
                contador+=1;
                aux.carrito.push_back(agre);
                productos[i].cVentas+=agre.cantidad;
            } 
        }
        if (contador==0)
        {
            cout<<"el producto no esta en el catologo"<<endl; 
            break;           /* code */
        }
        cout<<"sigo en el ingreso? pone 0 si no"<<endl;
        cin>>opcion;
    }
    cout<<"fecha"<<endl;
    cin>>aux.fPedido.dia>>aux.fPedido.mes>>aux.fPedido.año;
    calcularMonto(aux, productos);
    pedidos.push_back(aux);



};
void chusma(string nombre, vector <pedido> pedidos){
    for (int i = 0; i < pedidos.size(); i++)
    {
        if(nombre==pedidos[i].nombre){
            cout<<"la fecha es:"<<pedidos[i].fPedido.dia<<"/"<<pedidos[i].fPedido.mes<<"/"<<pedidos[i].fPedido.año<<endl;
            cout<<"el monto total es: "<<pedidos[i].montoT<<endl;
            cout<<"carrito: "<<endl;
            for (int j = 0; j < pedidos[i].carrito.size(); j++)
            {
                cout<<pedidos[i].carrito[j].prod<<" "<<pedidos[i].carrito[j].cantidad<<endl;
            }
            
        }
    }
    
};
void ordenarPorVentas(producto productos[], int tam) {
    for (int i = 0; i < tam - 1; ++i) {
        for (int j = 0; j < tam - i - 1; ++j) {
            if (productos[j].cVentas < productos[j + 1].cVentas) {
                producto temp = productos[j];
                productos[j] = productos[j + 1];
                productos[j + 1] = temp;
            }
        }
    }
}
void mostrarProductos(producto productos[], int tam) {
    for (int i = 0; i < tam; ++i) {
        cout << "Producto: " << productos[i].nombre << ", "
             << "Promoción: " <<productos[i].promocion << ", "
             << "Ventas: " << productos[i].cVentas << ", "
             << "Precio: $" << productos[i].precio << ", "
             << "Categoría: " << productos[i].cat << endl;
    }
}


int main(){
    //para ahorrarme la funcion de ingreso se los pido a GPT
    producto productos[20] = {
        {"Laptop", true, 150, 1200, "Electrónica"},
        {"CamisetaNike", false, 300, 30, "Ropa"},
        {"SmartphoneSamsung", true, 500, 800, "Electrónica"},
        {"CaféColombiano", false, 200, 15, "Alimentos"},
        {"ZapatosAdidas", true, 100, 90, "Ropa"},
        {"TelevisorLG", false, 75, 600, "Electrónica"},
        {"LibrodeC++", true, 250, 40, "Educación"},
        {"RelojCasio", false, 80, 70, "Accesorios"},
        {"GuitarraFender", true, 40, 450, "Instrumentos"},
        {"CerealNestlé", false, 220, 5, "Alimentos"},
        {"BicicletaTrek", true, 30, 800, "Deportes"},
        {"AuricularesSony", false, 150, 120, "Electrónica"},
        {"PerfumeDior", true, 60, 150, "Belleza"},
        {"SillaGamer", false, 90, 300, "Muebles"},
        {"PelotadeFútbol", true, 400, 25, "Deportes"},
        {"TabletHuawei", false, 130, 250, "Electrónica"},
        {"BolsoGucci", true, 25, 1000, "Accesorios"},
        {"TazadeCerámica", false, 350, 10, "Hogar"},
        {"CámaraCanon", true, 45, 550, "Fotografía"},
        {"LámparaLED", false, 500, 20, "Iluminación"}
    };
    vector <pedido> pedidos;
    string nombre;
    while(true){    
        ingPedido(pedidos, productos);
        cout<<"que pedido queres chusmear"<<endl;
        cin>>nombre;
        chusma(nombre, pedidos);
        ordenarPorVentas(productos, 20); 
        mostrarProductos(productos, 20);  
    }


}