/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase17grupo16;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Controlador implements ActionListener {

    Vista vis;
    Modelo mod;

    Controlador(Vista comosea, Modelo param) {
        this.vis = comosea;
        this.mod = param;

        this.vis.setVisible(true);
        this.vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.vis.B.addActionListener(this);
        this.vis.A.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vis.B) {
            //System.out.println("si se escucha");
            this.vis.C_Ciudades.setVisible(false);
            this.vis.C_Ciudades = new JComboBox(this.mod.leerCiudades());
            this.vis.C_Ciudades.setBounds(120, 30, 100, 30);
            this.vis.add(this.vis.C_Ciudades);
            this.vis.C_Ciudades.setVisible(true);

        }

        if (e.getSource() == this.vis.A) {
            int x = this.mod.guardar(this.vis.T_ciudad.getText());
            if (x == 0) {
                JOptionPane.showMessageDialog(this.vis, "Error al guardar la Ciudad!!!");
            } else {
                JOptionPane.showMessageDialog(this.vis, "Exito al guardar la Ciudad");
            }

        }
    }

}
