/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase17grupo16;

/**
 *
 * @author Usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vista ventana= new Vista();
        Modelo datos= new Modelo();
        
        Controlador c=new Controlador(ventana,datos);
        
        
    }
    
}
