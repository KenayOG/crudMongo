/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudmongo;

/**
 *
 * @author kenay
 */
public class CrudMongo {

    public static void main(String[] args) {
        
        Conecction con = new Conecction();                                    
        con.show();
        System.out.println("Se guardara: ");
        con.insert("Rojo");        
        System.out.println("Completado...");        
        con.show();
        System.out.println("Se actualizara: ");
        con.update("Rojo", "Verde");         
        System.out.println("Compleatado...");
        con.show();
        System.out.println("Se eliminara: ");
        con.delete("Azul");
        con.show();
        System.out.println("Se ha finalizado con exito."); 

    }
    
}
