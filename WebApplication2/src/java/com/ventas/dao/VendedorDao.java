/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ventas.model.Vendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vjimenez
 */
public class VendedorDao extends Dao {
     public void registrar(Vendedor ven) throws Exception{
       try {
       this.Conectar();
       
           PreparedStatement st = this.getCn().prepareStatement("INSERT into vendedor (vRuc,vRzS,vDir,vLug,vMap,vFnc,vTlf,vCl1,vCl2,vCe1,vCe2,vCom,vFio,vFfo,vMcs,vFot,vUsr,vPas,vAcc) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           st.setString(1,ven.getVruc());
           st.setString(2, ven.getVrzs());
           st.setString(3, ven.getVdir());
           st.setString(4, ven.getVlug());
           st.setString(5, ven.getVmap());
           st.setString(6, ven.getVfnc());
           st.setString(7, ven.getVtlf());
           st.setString(8, ven.getVcl1());
           st.setString(9, ven.getVcl2());
           st.setString(10, ven.getVce1());
           st.setString(11, ven.getVce2());
           st.setFloat(12, ven.getVcom());
           st.setString(13, ven.getVfio());
           st.setString(14, ven.getVffo());
           st.setString(15, ven.getVmcs());
           st.setBinaryStream(16, ven.getVfot().getInputstream());
           st.setString(17, ven.getVusr());
           st.setString(18, ven.getVpas());
           st.setString(19, ven.getVacc());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
       }
   }
     
            public List<Vendedor> listar() throws Exception{
   List<Vendedor> lista;
   ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT vCod,vRuc,vRzS,vDir,vLug,vMap,vFnc,vTlf,vCl1,vCl2,vCe1,vCe2,vCom,vFio,vFfo,vMcs,vFot,vUsr,vPas,vAcc FROM vendedor");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
           Vendedor ven = new Vendedor();
          ven.setvCod(rs.getString("vCod"));
          ven.setVruc(rs.getString("vRuc"));
          ven.setVrzs(rs.getString("vRzS"));
          ven.setVdir(rs.getString("vDir"));
          ven.setVlug(rs.getString("vLug"));
          ven.setVmap(rs.getString("vMap"));
          ven.setVfnc(rs.getString("vFnc"));
          ven.setVtlf(rs.getString("vTlf"));
          ven.setVcl1(rs.getString("vCl1"));
          ven.setVcl2(rs.getString("vCl2"));
          ven.setVce1(rs.getString("vCe1"));
          ven.setVce2(rs.getString("vCe2"));
          ven.setVcom(rs.getFloat("vCom"));
          ven.setVfio(rs.getString("vFio"));
          ven.setVffo(rs.getString("vFfo"));
          ven.setVmcs(rs.getString("vMcs"));
          //ven.setVfot(rs.getString("vFot").getBytes());
          ven.setVusr(rs.getString("vUsr"));
          ven.setVpas(rs.getString("vPas"));
          ven.setVacc(rs.getString("vAcc"));
            lista.add(ven);
           }
       } catch (Exception e) {
           throw e;
             
       }
       finally{
       this.Cerrar();
       }
       return lista;
   }
            
                   
      public Vendedor leerID(Vendedor ven) throws Exception{
       Vendedor vens = null;
       ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT vCod,vRuc,vRzS,vDir,vLug,vMap,vFnc,vTlf,vCl1,vCl2,vCe1,vCe2,vCom,vFio,vFfo,vMcs,vFot,vUsr,vPas,vAcc FROM vendedor WHERE vCod=?");
           st.setString(1,ven.getvCod());
           rs =st.executeQuery();
           while (rs.next()) {
               vens = new Vendedor();
          vens.setvCod(rs.getString("vCod"));
          vens.setVruc(rs.getString("vRuc"));
          vens.setVrzs(rs.getString("vRzS"));
          vens.setVdir(rs.getString("vDir"));
          vens.setVlug(rs.getString("vLug"));
          vens.setVmap(rs.getString("vMap"));
          vens.setVfnc(rs.getString("vFnc"));
          vens.setVtlf(rs.getString("vTlf"));
          vens.setVcl1(rs.getString("vCl1"));
          vens.setVcl2(rs.getString("vCl2"));
          vens.setVce1(rs.getString("vCe1"));
          vens.setVce2(rs.getString("vCe2"));
          vens.setVcom(rs.getFloat("vCom"));
          vens.setVfio(rs.getString("vFio"));
          vens.setVffo(rs.getString("vFfo"));
          vens.setVmcs(rs.getString("vMcs"));
          //ven.setVfot(rs.getString("vFot").getBytes());
          vens.setVusr(rs.getString("vUsr"));
          vens.setVpas(rs.getString("vPas"));
          vens.setVacc(rs.getString("vAcc"));
            

              }
           
       } catch (Exception e) {
           throw e;
       }
   finally{
           this.Cerrar();
}
       return vens;
}
          
public void modificar(Vendedor ven) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("UPDATE vendedor SET vRuc=?,vRzS=?,vDir=?,vLug=?,vMap=?,vFnc=?,vTlf=?,vCl1=?,vCl2=?,vCe1=?,vCe2=?,vCom=?,vFio=?,vFfo=?,vMcs=?,vFot=?,vUsr=?,vPas=?,vAcc=? WHERE vCod = ?");
           st.setString(1,ven.getVruc());
           st.setString(2, ven.getVrzs());
           st.setString(3, ven.getVdir());
           st.setString(4, ven.getVlug());
           st.setString(5, ven.getVmap());
           st.setString(6, ven.getVfnc());
           st.setString(7, ven.getVtlf());
           st.setString(8, ven.getVcl1());
           st.setString(9, ven.getVcl2());
           st.setString(10, ven.getVce1());
           st.setString(11, ven.getVce2());
           st.setFloat(12, ven.getVcom());
           st.setString(13, ven.getVfio());
           st.setString(14, ven.getVffo());
           st.setString(15, ven.getVmcs());
           st.setBinaryStream(16, ven.getVfot().getInputstream());
           st.setString(17, ven.getVusr());
           st.setString(18, ven.getVpas());
           st.setString(19, ven.getVacc());
           st.setString(20,ven.getvCod());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    public void eliminar(Vendedor ven) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("DELETE FROM vendedor  WHERE vCod = ?");
           st.setString(1,ven.getvCod());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
            
            
}
