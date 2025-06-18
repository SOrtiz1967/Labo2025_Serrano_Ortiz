package sistemas;

import objetos.Apto;
import objetos.Dificultad;
import objetos.Receta;
import objetos.RecetaEntrada;
import objetos.RecetaPlatoPrincipal;
import objetos.RecetaPostre;
import objetos.Temperatura;

import java.util.ArrayList;

public class SistemaRecetas {
    private ArrayList<Receta>recetas;

    public SistemaRecetas(){
        this.recetas= new ArrayList<>();
    }
    public SistemaRecetas(ArrayList<Receta> r1){
        this.recetas= r1;
    }
    public ArrayList<Receta> getRecetas(){
        return this.recetas;
    }
    public void AgregarReceta(Receta r1){
        this.recetas.add(r1);
    }
    public void EliminarReceta(Receta r1){
        this.recetas.remove(r1);
    }
    public void Modificar(Receta recetaborrada, Receta recetaagregada){
        this.recetas.remove(recetaborrada);
        this.recetas.add(recetaagregada);
    }
    public ArrayList<Receta> BuscarRecetasSegunDificultad(Dificultad dificultadABuscar){
        ArrayList<Receta> recetasConEsaDificultad=new ArrayList<Receta>();
        for(Receta r:this.recetas){
            if(r.getDificultad()==dificultadABuscar){
                recetasConEsaDificultad.add(r);
            }
        }
        return recetasConEsaDificultad;
    }
    public boolean EsDelTipoEntrada(Receta r){
        boolean condicion=false;
        if(r.getClass().getName()=="RecetaEntrada"){
            condicion=true;
            return condicion;
        }
        return condicion;
    }
    public boolean EsDelTipoPostre(Receta r){
        boolean condicion=false;
        if(r.getClass().getName()=="RecetaPostre"){
            condicion=true;
            return condicion;
        }
        return condicion;
    }
    public boolean EsDelTipoPlatoPrincipal(Receta r){
        boolean condicion=false;
        if(r.getClass().getName()=="RecetaPlatoPrincipal"){
            condicion=true;
            return condicion;
        }
        return condicion;
    }
    public void FiltrarRecetasPorTipo(){
        ArrayList<Receta> platoPrincipal=new ArrayList<Receta>();
        ArrayList<Receta> entrada=new ArrayList<Receta>();
        ArrayList<Receta> platopostre=new ArrayList<Receta>();
        for(Receta r:this.recetas){
            if(this.EsDelTipoEntrada(r)){
                entrada.add(r);
            };
            if(this.EsDelTipoPlatoPrincipal(r)){
                platoPrincipal.add(r);
            };
            if(this.EsDelTipoPostre(r)){
                platopostre.add(r);
            };
        }
        System.out.println("Categoría Entrada: ");
        for(Receta rE: entrada){
            System.out.println(rE.getNombre());
        }
        System.out.println("Categoría Plato Principal: ");
        for(Receta rPP: platoPrincipal){
            System.out.println(rPP.getNombre());
        }
        System.out.println("Categoría Postre: ");
        for(Receta rP: platopostre){
            System.out.println(rP.getNombre());
        }
    }
    public int CantidadRecetas(){
        int cantidad=0;
        for(Receta r:this.recetas){
            cantidad++;
        }
        return cantidad;
    }
    public int CantidadPasos(Receta r){
        int cantidad=0;
        for(String p:r.getListadepasos()){
            cantidad++;
        }
        return cantidad;
    }
    public Receta MayorCantidadPasos(){
        Receta recetaConMayorCantidadPasos=this.recetas.get(0);
        for(Receta r: this.recetas){
            if(this.CantidadPasos(r)>this.CantidadPasos(recetaConMayorCantidadPasos)){
                recetaConMayorCantidadPasos=r;
            }
        }
        return recetaConMayorCantidadPasos;
    }
    public static void main(String[] args) {
        SistemaRecetas sistema = new SistemaRecetas();
    
        // Recetas de ejemplo
        ArrayList<String> pasosEntrada = new ArrayList<>();
        pasosEntrada.add("Cortar verduras");
        pasosEntrada.add("Aliñar");
    
        ArrayList<String> pasosPrincipal = new ArrayList<>();
        pasosPrincipal.add("Sazonar carne");
        pasosPrincipal.add("Cocinar a fuego lento");
        pasosPrincipal.add("Servir");
    
        ArrayList<String> pasosPostre = new ArrayList<>();
        pasosPostre.add("Batir huevos");
        pasosPostre.add("Agregar azúcar");
        pasosPostre.add("Hornear");
        pasosPostre.add("Decorar");
    
        // Crear recetas (asumo que tienen constructor con nombre, dificultad y pasos)
        Receta entrada = new RecetaEntrada("Ensalada César", Dificultad.FACIL, pasosEntrada,Temperatura.FRIO);
        Receta principal = new RecetaPlatoPrincipal("Asado criollo", Dificultad.MEDIO, pasosPrincipal,40,2);
        Receta postre = new RecetaPostre("Tarta de manzana", Dificultad.AVANZADO, pasosPostre,190,Apto.APTODIABETICOS);
    
        // Agregarlas al sistema
        sistema.AgregarReceta(entrada);
        sistema.AgregarReceta(principal);
        sistema.AgregarReceta(postre);
    
        // Mostrar recetas por tipo
        sistema.FiltrarRecetasPorTipo();
    
        // Mostrar cantidad total
        System.out.println("Cantidad total de recetas: " + sistema.CantidadRecetas());
    
        // Mostrar receta con más pasos
        Receta recetaMaxPasos = sistema.MayorCantidadPasos();
        System.out.println("Receta con más pasos: " + recetaMaxPasos.getNombre() + " (" + sistema.CantidadPasos(recetaMaxPasos) + " pasos)");
    }
    
}
