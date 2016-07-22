/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bean;

import com.ventas.dao.EmpresaDao;
import com.ventas.model.Empresa;
import com.ventas.util.MyUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped


public class EmpresaBean {
     private Empresa empresa = new Empresa();
    private List<Empresa> lstEmpresas;
        private String accion;

 public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getLstEmpresas() {
        return lstEmpresas;
    }

    public void setLstEmpresas(List<Empresa> lstEmpresas) {
        this.lstEmpresas = lstEmpresas;
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
        EmpresaDao dao;
        
        try {
            dao = new EmpresaDao();
            dao.registrar(empresa);
            this.listar();
            MyUtil.mensajeinfo("Empresa creada correctamente");
            
        } catch (Exception e) {
            MyUtil.mensajes("Registro", e);
        }
    }
        public void modificar(){
        EmpresaDao dao;
        try {
            dao = new EmpresaDao();
            dao.modificar(empresa);
            this.listar();
            MyUtil.mensajeinfo("Empresa modificada correctamente");
        } catch (Exception e) {
            MyUtil.mensajes("Modificación", e);
            
        }
    }
    
        public void listar(){
        EmpresaDao dao;
        try {
            dao = new EmpresaDao();
            lstEmpresas= dao.listar();
        } catch (Exception e) {
                MyUtil.mensajes("Listado", e);
        }
    }
        
      public void leerID(Empresa emp)  {
         EmpresaDao dao;
         Empresa temp;
        try {
            dao = new EmpresaDao();
            temp = dao.leerID(emp);
            if (temp != null){
            this.empresa = temp;
            this.accion="Modificar";
            }
        } catch (Exception e) {
        }
      
      }
      
      public String Dataget(int id){
      EmpresaDao dao;
       dao = new EmpresaDao();
      return dao.traerDatos(id);
      }
      
       public void eliminar(Empresa emp){
        EmpresaDao dao;
        try {
            dao = new EmpresaDao();
            dao.eliminar(emp);
            this.listar();        
        } catch (Exception e) {
        }
    }
        
    
}