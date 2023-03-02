/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.BasicDBObject;

/**
 *
 * @author kenay
 */
public class Conecction {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    
    public Conecction(){
        
        
        try {
            Mongo mongo = new Mongo("localhost", 27017);
            BaseDatos = mongo.getDB("TiposDeColores");
            coleccion = BaseDatos.getCollection("TiposDeColores");
            System.out.println("Conexion Exitosa");
        } catch(Exception ex) {            
            Logger.getLogger(Conecction.class.getName()).log(Level.SEVERE,null,ex);
        }        
    }
    
    //Metodos del CRUD 
    
    //Guardar de Datos
    
    public boolean insert(String color){
        
        document.put("color", color);
        coleccion.insert(document);              
        return true;        
    }
    
    //Mostrar Datos 
    
    public void show(){
       DBCursor cursor = coleccion.find();       
       while(cursor.hasNext()){
           System.out.println(cursor.next());           
       }
    }
    
    //Actualizacion de Datos
    
    public boolean update(String colorAnterior, String colorNuevo){
        
        document.put("color", colorAnterior);
        BasicDBObject documentNuevo = new BasicDBObject();
        documentNuevo.put("color", colorNuevo);
        coleccion.findAndModify(document, documentNuevo);               
        return true;
    }    
    //Eliminar Datos
    
    public boolean delete(String color){
        document.put("color", color);
        coleccion.remove(document);
        return true;
    }
}
