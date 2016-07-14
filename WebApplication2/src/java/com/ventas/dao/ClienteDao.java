/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ventas.model.Cliente;
import com.ventas.util.MyUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author vjimenez
 */
public class ClienteDao extends Dao {  
     public void registrar(Cliente cli) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("INSERT into cliente"
                   + "(cRuc,cRzS,cDir,cLug,cMap,cFnc,cTl1,cTl2,cCl1,cCl2,cCe1,cCe2,cFio,cCat,cPds,vCod,cFot) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           st.setString(1,cli.getCruc());
           st.setString(2, cli.getCrzs());
           st.setString(3, cli.getCdir());
           st.setString(4, cli.getClug());
           st.setString(5, cli.getCmap());
           st.setString(6, cli.getCfnc());
           st.setString(7, cli.getCtl1());
           st.setString(8, cli.getCtl2());
           st.setString(9, cli.getCce1());
           st.setString(10, cli.getCce2());
           st.setString(11, cli.getCfio());
           st.setString(12, cli.getCcat());
           st.setString(13, cli.getCpds());
           //st.setString(14, cli.getC);
           st.setBytes(15, cli.getCfot());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
       }
   }
     
public List<Cliente> listar() throws Exception{
   List<Cliente> lista;
   ResultSet rs;
   
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT cCod,cRuc,cRzS,cDir,cLug,cMap,cFnc,cTl1,cTl2,cCl1,cCl2,cCe1,cCe2,cFio,cCat,cPds,vCod,cFot FROM cliente");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
         Cliente cli = new Cliente();
         cli.setCcod(rs.getInt("cCod"));
          cli.setCruc(rs.getString("cRuc"));
          cli.setCrzs(rs.getString("cRzS"));
          cli.setCdir(rs.getString("cDir"));
          cli.setClug(rs.getString("cLug"));
          cli.setCmap(rs.getString("cMap"));
          cli.setCfnc(rs.getString("cFnc"));
          cli.setCtl1(rs.getString("cTl1"));
          cli.setCtl2(rs.getString("cTl2"));
          cli.setCcl1(rs.getString("cCl1"));
          cli.setCcl2(rs.getString("cCl2"));
          cli.setCce1(rs.getString("cCe1"));
          cli.setCce2(rs.getString("cCe2"));
          cli.setCfio(rs.getString("cfio"));
          cli.setCcat(rs.getString("cCat"));
          cli.setCpds(rs.getString("cPds"));
          //cli.setC(rs.getString("vMcs"));
          cli.setCfot(rs.getBytes("cFot"));//wwwww
          lista.add(cli);
           }
       } catch (Exception e) {
           throw e;
             
       }
       finally{
       this.Cerrar();
       }
       return lista;
   }
            
                   
      public Cliente leerID(Cliente cli) throws Exception{
       Cliente clis = null;
       ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT "
                   + "cCod,cRuc,cRzS,cDir,cLug,cMap,cFnc,cTl1,cTl2,cCl1,cCl2,cCe1,cCe2,cFio,cCat,cPds,vCod,cFot FROM cliente WHERE cCod=?");
           st.setInt(1,cli.getCcod());
           rs =st.executeQuery();
           while (rs.next()) {
           cli = new Cliente();
          cli.setCcod(rs.getInt("cCod"));
          cli.setCruc(rs.getString("cRuc"));
          cli.setCrzs(rs.getString("cRzS"));
          cli.setCdir(rs.getString("cDir"));
          cli.setClug(rs.getString("cLug"));
          cli.setCmap(rs.getString("cMap"));
          cli.setCfnc(rs.getString("cFnc"));
          cli.setCtl1(rs.getString("cTl1"));
          cli.setCtl2(rs.getString("cTl2"));
          cli.setCcl1(rs.getString("cCl1"));
          cli.setCcl2(rs.getString("cCl2"));
          cli.setCce1(rs.getString("cCe1"));
          cli.setCce2(rs.getString("cCe2"));
          cli.setCfio(rs.getString("cfio"));
          cli.setCcat(rs.getString("cCat"));
          cli.setCpds(rs.getString("cPds"));
          //cli.setC(rs.getString("vMcs"));
          cli.setCfot(rs.getBytes("cFot"));
            

              }
           
       } catch (Exception e) {
           throw e;
       }
   finally{
           this.Cerrar();
}
       return clis;
}
          
public void modificar(Cliente cli) throws Exception{
       try {
//         DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//         java.util.Date fecha = null; // crea objetos tipo util.Date y sql.Date
//         java.sql.Date fecha2 = null;
//         fecha = ft.parse(ven.getVfnc()); // convierte el string en util.Date
//         fecha2 = new java.sql.Date(fecha.getTime());
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("UPDATE cliente SET "
                   + "cCod=?,cRuc=?,cRzS=?,cDir=?,cLug=?,cMap=?,cFnc=?,cTl1=?,cTl2=?,cCl1=?,cCl2=?,cCe1=?,cCe2=?,cFio=?,cCat=?,cPds=?,vCod=?,cFot=? WHERE cCod = ?");
           st.setString(1,cli.getCruc());
           st.setString(1,cli.getCruc());
           st.setString(2, cli.getCrzs());
           st.setString(3, cli.getCdir());
           st.setString(4, cli.getClug());
           st.setString(5, cli.getCmap());
           st.setString(6, cli.getCfnc());
           st.setString(7, cli.getCtl1());
           st.setString(8, cli.getCtl2());
           st.setString(9, cli.getCce1());
           st.setString(10, cli.getCce2());
           st.setString(11, cli.getCfio());
           st.setString(12, cli.getCcat());
           st.setString(13, cli.getCpds());
           //st.setString(14, cli.getC);
           st.setBytes(15, cli.getCfot());
           st.executeUpdate();
       } catch (Exception e) {
       FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error",  "Mensaje: " + e.getMessage()) );
        throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    public void eliminar(Cliente ven) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("DELETE FROM cliente  WHERE cCod = ?");
           st.setInt(1,ven.getCcod());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   }
    
      private String getparsedDate(String date) throws Exception {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        String s1 = date;
        String s2 = null;
        Date d;
        try {
            d = sdf.parse(s1);
            s2 = (new SimpleDateFormat("yyyy-MM-dd")).format(d);

        } catch (ParseException e) {
        }

        return s2;

    }
            
            
}
