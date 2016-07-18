/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.util;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class MyUtil {
    
     public static String baseurl(){
 
 return "http://localhost:8080/WebApplication2/faces/";
 }

     
public static void mensajes(String tipo,Exception e){
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error de "+ tipo, e.getMessage()));
}
}
