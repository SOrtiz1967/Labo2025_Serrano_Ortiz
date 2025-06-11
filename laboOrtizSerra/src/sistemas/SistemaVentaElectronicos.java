package sistemas;

import Tecnologia.ProductoElectronico;
import objetos.Seccion;

import java.util.ArrayList;

/*En una tienda de electrónica venden distintos tipos de productos. Si bien todos tienen un nombre, precio y un stock, según en qué sección se encuentran son los datos que interesa almacenar. Los equipos de sonido, que pertenecen a la sección Multimedia, tienen un atributo para indicar si tienen el módulo Bluetooth integrado o no. Además, en la misma sección encontramos televisores de los cuales interesa saber, además del nombre, precio y stock, qué tecnología utilizan (ultraHd – 4K - FullHd) y la resolución en pixeles.
Por otro lado, los cargadores portátiles que son de la sección cargadores almacenarán también la cantidad de cargas que pueden hacer sin necesidad de recargarlos.
La tienda administra todos estos productos por lo que deberán crear los métodos necesarios que permitan agregar nuevos productos, modificarlos y eliminarlos. La tienda quiere conocer cuál es su producto con mayor stock y cual el de menor.*/
public class SistemaVentaElectronicos {
    ArrayList<ProductoElectronico>productos;

    public ArrayList<ProductoElectronico> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoElectronico> productos) {
        this.productos = productos;
    }

    public SistemaVentaElectronicos(ArrayList<ProductoElectronico> productos) {
        this.productos = productos;
    }

    public SistemaVentaElectronicos() {
        ProductoElectronico p1=new ProductoElectronico("parlante",700,50, Seccion.MULTIMEDIA);
        ProductoElectronico p2=new ProductoElectronico("cargador 50W",400,5,Seccion.CARGADORES);
        this.productos=new ArrayList<ProductoElectronico>();
        productos.add(p1);
        productos.add(p2);
    }
    public void agregarProducto(ProductoElectronico p){
        this.productos.add(p);
    }
    public void eliminarProducto(ProductoElectronico p){
        this.productos.remove(p);
    }
    public void modificarProducto(ProductoElectronico productoEliminado, ProductoElectronico productoAgregado){
        eliminarProducto(productoEliminado);
        agregarProducto(productoAgregado);
    }
    public ArrayList<ProductoElectronico> mayorYmenorStock(){
        ArrayList<ProductoElectronico> mayorymenorstock=new ArrayList<ProductoElectronico>();
        ProductoElectronico mayorStock=this.productos.get(0);
        ProductoElectronico menorStock=this.productos.get(0);
        for(ProductoElectronico p:this.productos) {
            if (p.getStock() > mayorStock.getStock()) {
                mayorStock = p;
            }
            if (p.getStock() < menorStock.getStock()) {
                menorStock = p;
            }

        }
        mayorymenorstock.add(menorStock);
        mayorymenorstock.add(mayorStock);

        return mayorymenorstock;
    }

    public static void main(String[] args) {
        ProductoElectronico p1 = new ProductoElectronico("TV Samsung 43\" 4K", 120000, 5, Seccion.MULTIMEDIA);
        ProductoElectronico p2 = new ProductoElectronico("TV LG 55\" OLED", 195000, 3, Seccion.MULTIMEDIA);
        ProductoElectronico p3 = new ProductoElectronico("TV Noblex 32\" FullHD", 85000, 7, Seccion.MULTIMEDIA);
        ProductoElectronico p4 = new ProductoElectronico("TV Philips 50\" 4K", 140000, 4, Seccion.MULTIMEDIA);
        ProductoElectronico p5 = new ProductoElectronico("TV BGH 40\" HD", 99000, 6, Seccion.MULTIMEDIA);

        ProductoElectronico p6 = new ProductoElectronico("Power Bank Xiaomi 10000mAh", 6500, 10, Seccion.CARGADORES);
        ProductoElectronico p7 = new ProductoElectronico("Power Bank Samsung 15000mAh", 7200, 8, Seccion.CARGADORES);
        ProductoElectronico p8 = new ProductoElectronico("Cargador Solar Anker 20000mAh", 8900, 5, Seccion.CARGADORES);
        ProductoElectronico p9 = new ProductoElectronico("Power Bank Energizer 10000mAh", 5800, 12, Seccion.CARGADORES);
        ProductoElectronico p10 = new ProductoElectronico("Cargador Aukey 12000mAh", 6000, 9, Seccion.CARGADORES);

        SistemaVentaElectronicos s1=new SistemaVentaElectronicos();
        s1.agregarProducto(p1);
        s1.agregarProducto(p2);
        s1.agregarProducto(p3);
        s1.agregarProducto(p4);
        s1.agregarProducto(p5);
        s1.agregarProducto(p6);
        s1.agregarProducto(p7);
        s1.agregarProducto(p8);
        s1.agregarProducto(p9);
        s1.modificarProducto(p9,p10);
        for (ProductoElectronico p: s1.productos){
            System.out.println(p.getNombre());
        }
        for (ProductoElectronico p: s1.mayorYmenorStock()){
            System.out.println("Nombre de productos con mayor y menor stock: " + p.getNombre());
        }


    }
}
