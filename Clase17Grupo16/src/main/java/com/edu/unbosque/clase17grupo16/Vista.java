/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase17grupo16;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class Vista extends JFrame{
    
    JLabel L_ciudades;
    JComboBox C_Ciudades;
    JButton B,A;
    JTextField T_ciudad;
    
    
    Vista(){
        this.setTitle("Lector de Ciudades");
        this.setSize(400,300);
        
        this.setLayout(null);
        
        this.L_ciudades= new JLabel("Ciudad:");
        this.C_Ciudades= new JComboBox();
        this.B= new JButton("Leer");
        
        this.T_ciudad= new JTextField();
        this.A= new JButton("Guardar");
        
        this.L_ciudades.setBounds(30,30,80,30);
        this.C_Ciudades.setBounds(120,30,100,30);
        this.B.setBounds(60,70,90,30);
        
        this.T_ciudad.setBounds(30,150,100,30);
        this.A.setBounds(140,150,90,30);
        
        this.add(L_ciudades);
        this.add(C_Ciudades);
        this.add(B);
        this.add(T_ciudad);
        this.add(A);
        
    }
    
}
