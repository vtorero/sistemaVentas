
package com.ventas.model;

import javax.persistence.Lob;




public class Vendedor {
private String vCod;
private String vruc;
private String vrzs;
private String vdir;
private String vlug;
private String vmap;
private String vfnc;
private String vtlf;
private String vcl1;
private String vcl2;
private String vce1;
private String vce2;
private float vcom;
private String vfio;
private String vffo;
private String vmcs;
@Lob()
private byte[] vfot;
private String vrft;
private String vusr;
private String vpas;
private String vacc;

    public String getVrft() {
        return vrft;
    }

    public void setVrft(String vrft) {
        this.vrft = vrft;
    }


    public String getvCod() {
        return vCod;
    }

    public void setvCod(String vCod) {
        this.vCod = vCod;
    }

    public String getVruc() {
        return vruc;
    }

    public void setVruc(String vruc) {
        this.vruc = vruc;
    }

    public String getVrzs() {
        return vrzs;
    }

    public void setVrzs(String vrzs) {
        this.vrzs = vrzs;
    }

    public String getVdir() {
        return vdir;
    }

    public void setVdir(String vdir) {
        this.vdir = vdir;
    }

    public String getVlug() {
        return vlug;
    }

    public void setVlug(String vlug) {
        this.vlug = vlug;
    }

    public String getVmap() {
        return vmap;
    }

    public void setVmap(String vmap) {
        this.vmap = vmap;
    }

    public String getVfnc() {
        return vfnc;
    }

    public void setVfnc(String vfnc) {
        this.vfnc = vfnc;
    }

    public String getVtlf() {
        return vtlf;
    }

    public void setVtlf(String vtlf) {
        this.vtlf = vtlf;
    }

    public String getVcl1() {
        return vcl1;
    }

    public void setVcl1(String vcl1) {
        this.vcl1 = vcl1;
    }

    public String getVcl2() {
        return vcl2;
    }

    public void setVcl2(String vcl2) {
        this.vcl2 = vcl2;
    }

    public String getVce1() {
        return vce1;
    }

    public void setVce1(String vce1) {
        this.vce1 = vce1;
    }

    public String getVce2() {
        return vce2;
    }

    public void setVce2(String vce2) {
        this.vce2 = vce2;
    }

    public float getVcom() {
        return vcom;
    }

    public void setVcom(float vcom) {
        this.vcom = vcom;
    }

    public String getVfio() {
        return vfio;
    }

    public void setVfio(String vfio) {
        this.vfio = vfio;
    }

    public String getVffo() {
        return vffo;
    }

    public void setVffo(String vffo) {
        this.vffo = vffo;
    }

    public String getVmcs() {
        return vmcs;
    }

    public void setVmcs(String vmcs) {
        this.vmcs = vmcs;
    }

    public byte[] getVfot() {
        return vfot;
    }

    public void setVfot(byte[] vfot) {
        this.vfot = vfot;
    }

    public String getVusr() {
        return vusr;
    }

    public void setVusr(String vusr) {
        this.vusr = vusr;
    }

    public String getVpas() {
        return vpas;
    }

    public void setVpas(String vpas) {
        this.vpas = vpas;
    }

    public String getVacc() {
        return vacc;
    }

    public void setVacc(String vacc) {
        this.vacc = vacc;
    }

}
