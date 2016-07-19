package com.ventas.bean;

import com.ventas.dao.DocumentoDao;
import com.ventas.model.Documento;
import com.ventas.util.MyUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DocumentoBean {
        private Documento documento = new Documento();
        private List<Documento> lstDocumentos;
        private String accion; 

    public Documento getDocumento() {
        return documento;
    }

  
    public void setDocumento(Documento vendedor) {
        this.documento = vendedor;
    }

    public List<Documento> getLstDocumentos() {
        return lstDocumentos;
    }

    public void setLstDocumentos(List<Documento> lstDocumentos) {
        this.lstDocumentos = lstDocumentos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
        
            
public void operar(){
    switch(accion){
        case "Registrar":
            this.registrar();
            break;
        case "Modificar":
            this.modificar();
            break;   
    }  
    }
      public void registrar(){
        DocumentoDao dao;
        try {
            dao = new DocumentoDao();
            dao.registrar(documento);
            this.listar();
            
        } catch (Exception e) {
            MyUtil.mensajes("Registro", e);
        }
    }
        public void modificar(){
        DocumentoDao dao;
        try {
            dao = new DocumentoDao();
            dao.modificar(documento);
            this.listar();
            
        } catch (Exception e) {
            MyUtil.mensajes("Modificación", e);
            
        }
    }
    
        public void listar(){
        DocumentoDao dao;
        try {
            dao = new DocumentoDao();
            lstDocumentos= dao.listar();
        } catch (Exception e) {
            MyUtil.mensajes("Listado", e);
        }
    }
        
      public void leerID(Documento ven)  {
         DocumentoDao dao;
         Documento temp;
        try {
            dao = new DocumentoDao();
            temp = dao.leerID(ven);
            if (temp != null){
            this.documento = temp;
            this.accion="Modificar";
            }
        } catch (Exception e) {
            MyUtil.mensajes("Lectura", e);
        }
      
      }
      
        public void eliminar(Documento ven){
        DocumentoDao dao;
        try {
            dao = new DocumentoDao();
            dao.eliminar(ven);
            this.listar();        
        } catch (Exception e) {
            MyUtil.mensajes("Eliminación", e);
                
        }
    }
    
}
