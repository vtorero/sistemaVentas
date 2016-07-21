/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.model;

import java.io.InputStream;



public class Cliente {
   private int ccod;
  private String cruc;
  private String crzs;
  private String cdir;
  private String clug;
  private String cmap;
  private String cfnc;
  private String ctl1;
  private String ctl2;
  private String ccl1;
  private String ccl2;
  private String cce1;
  private String cce2;
  private String cfio;
  private String ccat;
  private double cpds;
  private int vcod;
private InputStream cfot;;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.ccod;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.ccod != other.ccod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "ccod=" + ccod + '}';
    }
 

    public int getCcod() {
        return ccod;
    }

    public void setCcod(int ccod) {
        this.ccod = ccod;
    }

    public String getCruc() {
        return cruc;
    }

    public void setCruc(String cruc) {
        this.cruc = cruc;
    }

    public String getCrzs() {
        return crzs;
    }

    public void setCrzs(String crzs) {
        this.crzs = crzs;
    }

    public String getCdir() {
        return cdir;
    }

    public void setCdir(String cdir) {
        this.cdir = cdir;
    }

    public String getClug() {
        return clug;
    }

    public void setClug(String clug) {
        this.clug = clug;
    }

    public String getCmap() {
        return cmap;
    }

    public void setCmap(String cmap) {
        this.cmap = cmap;
    }


    public String getCfnc() {
        return cfnc;
    }

    public void setCfnc(String cfnc) {
        this.cfnc = cfnc;
    }

    public String getCtl1() {
        return ctl1;
    }

    public void setCtl1(String ctl1) {
        this.ctl1 = ctl1;
    }

    public String getCtl2() {
        return ctl2;
    }

    public void setCtl2(String ctl2) {
        this.ctl2 = ctl2;
    }

    public String getCcl1() {
        return ccl1;
    }

    public void setCcl1(String ccl1) {
        this.ccl1 = ccl1;
    }

    public String getCcl2() {
        return ccl2;
    }

    public void setCcl2(String ccl2) {
        this.ccl2 = ccl2;
    }

    public String getCce1() {
        return cce1;
    }

    public void setCce1(String cce1) {
        this.cce1 = cce1;
    }

    public String getCce2() {
        return cce2;
    }

    public void setCce2(String cce2) {
        this.cce2 = cce2;
    }

    public String getCfio() {
        return cfio;
    }

    public void setCfio(String cfio) {
        this.cfio = cfio;
    }

    public String getCcat() {
        return ccat;
    }

    public void setCcat(String ccat) {
        this.ccat = ccat;
    }

    public double getCpds() {
        return cpds;
    }

    public void setCpds(double cpds) {
        this.cpds = cpds;
    }

    public int getVcod() {
        return vcod;
    }

    public void setVcod(int vcod) {
        this.vcod = vcod;
    }

    public InputStream getCfot() {
        return cfot;
    }

    public void setCfot(InputStream cfot) {
        this.cfot = cfot;
    }

 
    
}
