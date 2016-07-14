/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ventas.model.Articulo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author vjimenez
 */
public class ArticuloDao extends Dao {  
     public void registrar(Articulo art) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("INSERT into articulo"
                   + "(aDs1,aDs2,aUvt,aPru,aCom,aSto,aSts,aFot) values(?,?,?,?,?,?,?)");
           st.setString(1,art.getAds1());
           st.setString(2, art.getAds2());
           st.setString(3, art.getAuvt());
           st.setDouble(4, art.getApru());
           st.setDouble(5, art.getAcom());
           st.setDouble(6, art.getAsto());
           st.setDouble(7, art.getAsts());
           st.setBytes(8, art.getaFot());
           
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
       }
   }
     
public List<Articulo> listar() throws Exception{
   List<Articulo> lista;
   ResultSet rs;
   
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT cArt,aDs1,aDs2,aUvt,aPru,aCom,aSto,aSts,aFot FROM articulo");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
         Articulo art = new Articulo();
          art.setCart(rs.getInt("cArt"));
          art.setAds1(rs.getString("aDs1"));
          art.setAds2(rs.getString("aDs2"));
          art.setAuvt(rs.getString("aUvt"));
          art.setApru(rs.getDouble("aPru"));
          art.setAsto(rs.getDouble("aSto"));
          art.setAsts(rs.getDouble("aSts"));
          art.setaFot(rs.getBytes("aFot"));
          lista.add(art);
           }
       } catch (Exception e) {
           throw e;
             
       }
       finally{
       this.Cerrar();
       }
       return lista;
   }
            
                   
      public Articulo leerID(Articulo art) throws Exception{
       Articulo arts = null;
       ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT "
            + "cArt,aDs1,aDs2,aUvt,aPru,aCom,aSto,aSts,aFot FROM articulo WHERE cArt=?");
           st.setInt(1,art.getCart());
           rs =st.executeQuery();
           while (rs.next()) {
           arts = new Articulo();
          arts.setCart(rs.getInt("cArt"));
          arts.setAds1(rs.getString("aDs1"));
          arts.setAds2(rs.getString("aDs2"));
          arts.setAuvt(rs.getString("aUvt"));
          arts.setApru(rs.getDouble("aPru"));
          arts.setAsto(rs.getDouble("aSto"));
          arts.setAsts(rs.getDouble("aSts"));
          arts.setaFot(rs.getBytes("aFot"));
          }
           
       } catch (Exception e) {
           throw e;
       }
   finally{
           this.Cerrar();
}
       return arts;
}
          
public void modificar(Articulo art) throws Exception{
       try {

       this.Conectar();

           PreparedStatement st = this.getCn().prepareStatement("UPDATE articulo SET "
                   + "aDs1=?,aDs2=?,aUvt=?,aPru=?,aCom=?,aSto=?,aSts=?,aFot=? WHERE cArt = ?");
           st.setString(1,art.getAds1());
           st.setString(2, art.getAds2());
           st.setString(3, art.getAuvt());
           st.setDouble(4, art.getApru());
           st.setDouble(5, art.getAcom());
           st.setDouble(6, art.getAsto());
           st.setDouble(7, art.getAsts());
           st.setBytes(8,art.getaFot());
           st.setInt(18, art.getCart());
           st.executeUpdate();
       } catch (Exception e) {
       FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error",  "Mensaje: " + e.getMessage()) );
        throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    public void eliminar(Articulo art) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("DELETE FROM articulo  WHERE cArt = ?");
          st.setInt(1,art.getCart());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   }
    
            
            
}
