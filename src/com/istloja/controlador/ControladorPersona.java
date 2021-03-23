/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;

import com.istloja.conexión.Conexion;
import com.istloja.modelo.Persona;
import javax.swing.table.DefaultTableModel;

public class ControladorPersona extends Conexion {

    public ControladorPersona() {

    }

    public boolean insertarPersona(int id, String nombre, String apellido) {
        Persona persona = new Persona(nombre, apellido, id);
        return this.Insert(persona);
    }

    public boolean actualizarPersona(int id, String nombre, String apellidos) {
        Persona personaNueva = new Persona(nombre, apellidos, id);
        return this.actualizar(personaNueva);
    }

    public boolean eliminarPersona(int id) {
        if (id > 0) {
            Persona persona = new Persona(null, null, id);
            return this.Eliminar(persona);
        } else {
            return false;
        }

    }

    public DefaultTableModel personas() {
        String Columnas[] = {"ID", "NOMBRE", "APELLIDO"};
        DefaultTableModel dtm = new DefaultTableModel(null, Columnas);
        Persona persona = null;
        Persona[] p = this.Lista(persona);
        if (p != null) {
            for (Persona per : p) {
                Object[] cli = new Object[3];
                cli[0] = per.getID();
                cli[1] = per.getNOMBRE();
                cli[2] = per.getAPELLIDOS();
                dtm.addRow(cli);

            }
        }
        return dtm;
    }
}
