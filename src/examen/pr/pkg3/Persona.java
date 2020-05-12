/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.pr.pkg3;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ADVANCE
 */
public class Persona {
    
    private String nombres;
    private String apellidos;
    private String fecha;

    public Persona(String nombre, String apellido, String fecha) {
        this.nombres = nombre;
        this.apellidos = apellido;
        this.fecha = fecha;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String MensajeCliente() throws ParseException{
        String name = this.getNombres();
        String lastname = this.getApellidos();
        String date = this.getFecha();
        
        //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
        //System.out.println(date+"\t"+date1);  
        
        String Mensaje = name + " | " + lastname + " | " + date;
        return Mensaje;
    }
    
    
    public String edad() throws ParseException{
        
        String date = this.getFecha();
 
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(date, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        
        int año = periodo.getYears();
        String edad = Integer.toString(año);
        return edad;
    }
    
    public String MensajeParaElServidor() throws ParseException{
        String nombres = this.getNombres();
        String apellidos = this.getApellidos();
        String edad = this.edad();
        String Mensaje = " El señor(a) "+ nombres +" " + apellidos + " tiene " + edad + " años";
        return Mensaje;
    }
}

