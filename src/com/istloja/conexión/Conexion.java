/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.conexión;

import com.istloja.modelo.Persona;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;

public class Conexion {

    private ObjectContainer oc;

    //Aquí abrimos la conexión a la base----------------------------------------
    private void open() {
        this.oc = Db4o.openFile("database1.yap");
    }

    //Método para guardar objetos-----------------------------------------------
    public boolean Insert(Persona objeto) {
        try {
            this.open();
            oc.set(objeto);
            this.oc.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bddo.Controlador.insertarPersona():" + e);
            return false;
        }
    }

    //Método para listar objetos------------------------------------------------
    public Persona[] Lista(Persona objeto) {
        try {
            Persona[] personas = null;
            this.open();
            ObjectSet resultados = this.oc.get(objeto);
            int i = 0;
            if (resultados.hasNext()) {
                personas = new Persona[resultados.size()];
                while (resultados.hasNext()) {
                    personas[i] = (Persona) resultados.next();
                    i++;
                }
            }
            this.oc.close();
            return personas;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bddo.Controlador.insertarPersona():" + e);
            return null;
        }
    }

    //Método para eliminar objetos----------------------------------------------

    public boolean Eliminar(Persona objeto) {
        try {
            this.open();
            ObjectSet resultados = this.oc.get(objeto);
            if (resultados.size() > 0) {
                Persona persona = (Persona) resultados.next();
                this.oc.delete(persona);
                this.oc.close();
                return true;

            } else {
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bddo.Controlador.insertarPersona():" + e);
            return false;

        }
    }

    //Método para actualizar objetos--------- -----------------------------------
    public boolean actualizar(Persona objeto) {
        try {
            this.open();
            ObjectSet resultados = this.oc.get(new Persona(null, null, objeto.getID()));
            if (resultados.size() > 0) {
                Persona resultado = (Persona) resultados.next();
                resultado.setNOMBRE(objeto.getNOMBRE());
                resultado.setAPELLIDOS(objeto.getAPELLIDOS());
                this.oc.set(resultado);
                this.oc.close();
                return true;
            } else {
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bddo.Controlador.insertarPersona():" + e);
            return false;
        }
    }


}
