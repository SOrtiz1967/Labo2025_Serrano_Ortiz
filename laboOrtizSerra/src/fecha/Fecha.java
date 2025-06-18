package fecha;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Fecha {//es un metodo abstracto? en algun momento creamos objetos de tipo fecha por ende no
    private int dia;
    private int mes;
    private int anio;

    public Fecha(){
        this.dia=9;
        this.mes=12;
        this.anio=2018;
    }
    public Fecha (int dia, int mes, int anio){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    public int getDia() {
        return dia;
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    public void valida() {
        Scanner e = new Scanner(System.in);

        while (String.valueOf(dia).length() >= 3 ||
                String.valueOf(mes).length() >= 3 ||
                String.valueOf(anio).length() >= 5) {

            System.out.println("La fecha está mal puesta. Día y mes deben tener máximo 2 dígitos, y año máximo 4 dígitos.");

            if (String.valueOf(dia).length() >= 3) {
                System.out.print("Ingrese un día correcto: ");
                dia = Integer.parseInt(e.nextLine());
            }
            if (String.valueOf(mes).length() >= 3) {
                System.out.print("Ingrese un mes correcto: ");
                mes = Integer.parseInt(e.nextLine());
            }
            if (String.valueOf(anio).length() >= 5) {
                System.out.print("Ingrese un año correcto: ");
                anio = Integer.parseInt(e.nextLine());
            }
        }
    }

    public int diasMes(){
        YearMonth mesdelanio= YearMonth.of(this.anio,this.mes);
        int diasdelmes= mesdelanio.lengthOfMonth();
        return diasdelmes;
    }
    public String corta(){
        System.out.println(dia+"-"+mes+"-"+anio);
        return (dia+"-"+mes+"-"+anio);
    }
    public void larga(){
        LocalDate fecha= LocalDate.of(anio,mes,dia);
        DayOfWeek fechita= fecha.getDayOfWeek();
        int diadelanio= fecha.getDayOfYear();
        System.out.println(fechita+"-"+dia+"-"+diadelanio);
    }
    public void siguiente(){
        if(dia==diasMes()){
            dia=1;
            if(mes==12) {
                mes = 1;
                anio++;
            }
            else{
                mes++;
            }
        }
        else {
            dia++;
        }
    }
    public void anterior(){
        if(dia==1){
            dia=diasMes();
            mes--;
            if(mes==0) {
                mes = 12;
                anio--;
            }
        }
        else {
            dia--;
        }
        }
    public boolean igualQue(Fecha f1){
        if(this.dia == f1.dia && this.mes == f1.mes && this.anio==f1.anio){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean menorQue(Fecha f1){
        if (this.anio<f1.anio){
            return true;
        }
        else if (this.anio==f1.anio) {
            if (this.mes<f1.mes){
                return true;
            } else if (this.mes==f1.mes) {
                if(this.dia<f1.dia){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public boolean mayorQue(Fecha f1){
        if (this.anio>f1.anio){
            return true;
        }
        else if (this.anio==f1.anio) {
            if (this.mes>f1.mes){
                return true;
            } else if (this.mes==f1.mes) {
                if(this.dia>f1.dia){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
