/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;


public class MyUtil {
    
     public static String baseurl(){
 
 return "http://localhost:8080/WebApplication2/faces/";
 }
     
public static String guardarBlodEnficheroTemporal(byte[] bytes,String nombreArchivo){
String ubicacionImagen=null;
ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
String path = servletContext.getRealPath("")+File.separatorChar+"resources"+File.separatorChar+"img"+File.separatorChar+"tmp"+File.separatorChar+nombreArchivo;

File f = null;
InputStream in = null;
try{
	f = new File(path);
	in = new ByteArrayInputStream(bytes);
	FileOutputStream out = new FileOutputStream(f.getAbsolutePath());
	int c = 0;
	while((c=in.read())>=0){
		out.write(c);
	}
	out.flush();
	out.close();
	ubicacionImagen=servletContext.getRealPath("")+File.separatorChar+"resources"+File.separatorChar+"img"+File.separatorChar+"tmp"+File.separatorChar+ nombreArchivo;
}catch(Exception e){
	System.err.println("no se pudo cargar la imagen");
}

return ubicacionImagen;
}
    
    
}
