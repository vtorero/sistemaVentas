
package com.ventas.dao;

import com.ventas.model.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpresaDao extends Dao {
    
    public void registrar(Empresa emp) throws Exception{
       try {
       this.Conectar();
       
           PreparedStatement st = this.getCn().prepareStatement("INSERT into empresa (eRzs,eRuc,eDir,eLug,eMap,eTl1,eTl2,eFax,eFio,eRep,eIgv) values(?,?,?,?,?,?,?,?,?,?,?)");
           st.setString(1,emp.getErzs());
           st.setString(2, emp.getEruc());
           st.setString(3, emp.getEdir());
           st.setString(4, emp.getElug());
           st.setString(5, emp.getEmap());
           st.setString(6, emp.getEtl1());
           st.setString(7, emp.getEtl2());
           st.setString(8, emp.getEfax());
           st.setString(9, emp.getEfio());
           st.setString(10, emp.getErep());
           st.setString(11, emp.getEigv());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
       }
   } 
    
       public List<Empresa> listar() throws Exception{
   List<Empresa> lista;
   ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT eCod,eRzS,eRuc,eDir,eLug,eMap,eTl1,eTl2,eFax,eFio,eRep,eIgv,eUfa,eUbv,eUna,eUnc,eUtk,eUgr,eUgt FROM empresa");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
           Empresa emp = new Empresa();
           emp.setEcod(rs.getInt("eCod"));
           emp.setErzs(rs.getString("eRzS"));
           emp.setEruc(rs.getString("eRuc"));
           emp.setEdir(rs.getString("eDir"));
           emp.setElug(rs.getString("eLug"));
           emp.setEmap(rs.getString("eMap"));
           emp.setEtl1(rs.getString("eTl1"));
           emp.setEtl2(rs.getString("eTl2"));
           emp.setEfax(rs.getString("eFax"));
           emp.setEfio(rs.getString("eFio"));
           emp.setErep(rs.getString("eRep"));
           emp.setEigv(rs.getString("eIgv"));
           emp.setEufa(rs.getString("eUfa"));
           emp.setEubv(rs.getString("eUbv"));
           emp.setEuna(rs.getString("eUna"));
           emp.setEunc(rs.getString("eUnc"));
           emp.setEutk(rs.getString("eUtk"));
           emp.setEugr(rs.getString("eUgr"));
           emp.setEugt(rs.getString("eUgt"));
           lista.add(emp);
           }
       } catch (Exception e) {
           throw e;
             
       }
       finally{
       this.Cerrar();
       }
       return lista;
   }
       
      public Empresa leerID(Empresa emp) throws Exception{
       Empresa emps = null;
       ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT eCod,eRzs,eRuc,eDir,eLug,eMap,eTl1,eTl2,eFax,DATE_FORMAT(eFio,'%d/%m/%Y')eFio,eRep,eIgv,eUfa,eUbv,eUna,eUnc,eUtk,eUgr,eUgt FROM empresa WHERE eCod=?");
           st.setInt(1,emp.getEcod());
           rs =st.executeQuery();
           while (rs.next()) {
               emps = new Empresa();
              emps.setEcod(rs.getInt("eCod"));
              emps.setErzs(rs.getString("eRzS"));
              emps.setEruc(rs.getString("eRuc"));
              emps.setEdir(rs.getString("eDir"));
              emps.setElug(rs.getString("eLug"));
              emps.setEmap(rs.getString("eMap"));
             emps.setEtl1(rs.getString("eTl1"));
             emps.setEtl2(rs.getString("eTl2"));
             emps.setEfax(rs.getString("eFax"));
             emps.setEfio(rs.getString("eFio"));
             emps.setErep(rs.getString("eRep"));
             emps.setEigv(rs.getString("eIgv"));
             emps.setEufa(rs.getString("eUfa"));
             emps.setEubv(rs.getString("eUbv"));
             emps.setEuna(rs.getString("eUna"));
            emps.setEunc(rs.getString("eUnc"));
            emps.setEutk(rs.getString("eUtk"));
            emps.setEugr(rs.getString("eUgr"));
            emps.setEugt(rs.getString("eUgt"));
            

              }
           
       } catch (Exception e) {
           throw e;
       }
   finally{
           this.Cerrar();
}
       return emps;
}
          
public void modificar(Empresa emp) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("UPDATE empresa SET eRzs=?,eRuc=?,eDir=?, eLug=?, eMap=?, eTl1=?, eTl2=?, eFax=?, eFio=STR_TO_DATE(?,'%d/%m/%Y'), eRep=?, eIgv=?,eUfa=?,eUbv=?,eUna=?,eUnc=?,eUtk=?,eUgr=?,eUgt=? WHERE eCod = ?");
           st.setString(1,emp.getErzs());
           st.setString(2, emp.getEruc());
           st.setString(3, emp.getEdir());
           st.setString(4, emp.getElug());
           st.setString(5, emp.getEmap());
           st.setString(6, emp.getEtl1());
           st.setString(7, emp.getEtl2());
           st.setString(8, emp.getEfax());
           st.setString(9, emp.getEfio());
           st.setString(10, emp.getErep());
           st.setString(11, emp.getEigv());
           st.setString(12,emp.getEufa());
           st.setString(13,emp.getEubv());
           st.setString(14,emp.getEuna());
           st.setString(15,emp.getEunc());
           st.setString(16,emp.getEutk());
           st.setString(17,emp.getEugr());
           st.setString(18,emp.getEugt());
           st.setInt(19,emp.getEcod());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    public void eliminar(Empresa emp) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("DELETE FROM empresa  WHERE eCod = ?");
           st.setInt(1,emp.getEcod());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    
}