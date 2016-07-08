package com.ventas.bean;
import com.ventas.dao.PersonaDao;
import com.ventas.model.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class PersonaBean {
    private Persona persona = new Persona();
    private List<Persona> lstPersonas;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
   

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        PersonaDao dao;
        try {
            dao = new PersonaDao();
            dao.registrar(persona);
            this.listar();
            
        } catch (Exception e) {
        }
    }
        public void modificar(){
        PersonaDao dao;
        try {
            dao = new PersonaDao();
            dao.modificar(persona);
            this.listar();
            
        } catch (Exception e) {
        }
    }
    
        public void listar(){
        PersonaDao dao;
        try {
            dao = new PersonaDao();
            lstPersonas = dao.listar();
        } catch (Exception e) {
        }
    }
        
      public void leerID(Persona per)  {
         PersonaDao dao;
         Persona temp;
        try {
            dao = new PersonaDao();
            temp = dao.leerID(per);
            if (temp !=null){
            this.persona = temp;
            this.accion="Modificar";
            }
        } catch (Exception e) {
        }
      
      }
      
           public void eliminar(Persona per){
        PersonaDao dao;
        try {
            dao = new PersonaDao();
            dao.eliminar(per);
            this.listar();
            
        } catch (Exception e) {
        }
    }
              
    
    
}
