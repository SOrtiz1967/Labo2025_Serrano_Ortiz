#include <iostream>
#include <vector>
using namespace std;



/*Se quieren almacenar los productos de un supermercado. De estos interesa conocer el nombre, código de barra, marca, precio y si tiene fecha de vencimiento o no.

Los pasillos del supermercado están compuestos por góndolas de 3 filas y 4 columnas. Ingresar tantos productos como sea necesario para llenar un pasillo y determinar:

    Columna de la góndola que tiene el precio de mayor valor.

    Nombre del producto de la fila 2, columna 3.

    Promedio de precios de todo ese pasillo.

    Cantidad de productos con fecha de vencimiento.

*/
struct producto{
    string nombre;
    int codigo_de_barra;
    string marca;
    int precio;
    bool vencimiento;
};

void llenar_pasillo(producto pasillo[3][4]){
    producto producto_generico1;
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            cout<<"ingrese el producto que quiera en la fila:"<<i<<"y columna:"<<j<<endl;
            cout<<"nombre del producto:"<<endl;
            cin>>producto_generico1.nombre;
            cout<<"codigo de barra:"<<endl;
            cin>>producto_generico1.codigo_de_barra;
            cout<<"marca:"<<endl;
            cin>>producto_generico1.marca;
            cout<<"precio:"<<endl;
            cin>>producto_generico1.precio;
            cout<<"vencimiento 0/1:"<<endl;
            cin>>producto_generico1.vencimiento;
            pasillo[i][j]= producto_generico1;
        }
    }
}
void precio_mayor_nombre_seleccionado(producto pasillo[3][4]){
    int precio_m=0;
    int total_columna=0;
    int columna_mayor=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            total_columna+=pasillo[i][j].precio;
        if(total_columna>precio_m){
            precio_m=total_columna;
            columna_mayor=j;
        }
        total_columna=0;
    }
}
            if(i==2 && j==3){
                cout<<"nombre del producto seleccionado: "<<pasillo[i][j].nombre<<endl;
            }
    return columna_mayor+1;
        }
    }
    cout<<precio_m;        
}
int promedio(producto pasillo[3][4]){
    int promiedo=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            pasillo[i][j].precio+=promiedo;
        }
    }
    promiedo/=12;
    return promiedo;        
}
int cantidad_que_vencen(producto pasillo[3][4]){
    int cantidad_que_v=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            if(pasillo[3][4].vencimiento==1){
                cantidad_que_v+=1;
            }
        }
    }
    return cantidad_que_v;        
}

int main(){
    producto pasillo[3][4];
    llenar_pasillo(pasillo);
    precio_mayor_nombre_seleccionado(pasillo);
    cout<<promedio(pasillo)<<endl;
    cout<<promedio(pasillo)<<endl;
}
