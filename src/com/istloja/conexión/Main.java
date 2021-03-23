/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.conexión;

import com.istloja.modelo.Persona;
import com.istloja.vistas.vistaPersona;
import java.util.Scanner;

/**
 *
 * @author Personal
 */
public class Main {
//

    public static void main(String[] args) {
//        Scanner entrada = new Scanner(System.in);
//        Conexion con = new Conexion();
//        
//        int dato;
//        System.out.println("Ingrese el número de acuerdo a la acción que quiere realizar: \n"
//                + "1. Insertar un nueva persona.\n"
//                + "2. Eliminar una persona.\n"
//                + "3. Actualizar una persona");
//        dato = entrada.nextInt();
//        switch (dato) {
//            case 1:
//                String nombre;
//                String apellido;
//                int idPersona;
//                System.out.println("Ingrese el NOMBRE de la persona");
//                nombre = entrada.next();
//
//                System.out.println("Ingrese el APELLIDO de la persona");
//                apellido = entrada.next();
//
//                System.out.println("Ingrese un ID para la persona");
//                idPersona = entrada.nextInt();
//
//                Persona p = new Persona(nombre, apellido, idPersona);
//
//                boolean v = con.Insert(p);
//
//                System.out.println("Se guardó el objeto " + v);
//                con.Lista(p);
//                break;
//            case 2:
//                int idEliminar;
//                System.out.println("Ingrese el ID de la persona a eliminar.");
//                idEliminar = entrada.nextInt();
//                con.eliminarPersona(idEliminar);
//                Persona p1 = new Persona();
//                con.Lista(p1);
//                break;
//            case 3:
//                System.out.println("Ingrese el ID de la persona a actualizar.");
//                int idActualizar = entrada.nextInt();
//
//                System.out.println("Ingrese el nuevo nombre de la persona.");
//                String nombreA = entrada.next();
//
//                System.out.println("Ingrese el nuevo apellido de la persona.");
//                String apellidoA = entrada.next();
////
////                con.actualizarPersona(idActualizar, nombreA, apellidoA);
//                Persona p2 = new Persona();
//                con.Lista(p2);
//                break;
//            default:
//                System.out.println("Ingrese un item correcto.");
//                break;
//        }

        new vistaPersona().setVisible(true);
    }
}
