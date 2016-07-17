/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.model;

import java.io.InputStream;


/**
 *
 * @author vjimenez
 */
public class Articulo {
  private int cart;
  private String ads1;
  private String ads2;
  private String auvt;
  private double apru;
  private double acom;
  private double asto;
  private double asts;
  private InputStream afot;
    
    public int getCart() {
        return cart;
    }

    public InputStream getAfot() {
        return afot;
    }

    public void setAfot(InputStream afot) {
        this.afot = afot;
    }

    public void setCart(int cart) {
        this.cart = cart;
    }

    public String getAds1() {
        return ads1;
    }

    public void setAds1(String ads1) {
        this.ads1 = ads1;
    }

    public String getAds2() {
        return ads2;
    }

    public void setAds2(String ads2) {
        this.ads2 = ads2;
    }

    public String getAuvt() {
        return auvt;
    }

    public void setAuvt(String auvt) {
        this.auvt = auvt;
    }

    public double getApru() {
        return apru;
    }

    public void setApru(double apru) {
        this.apru = apru;
    }

    public double getAcom() {
        return acom;
    }

    public void setAcom(double acom) {
        this.acom = acom;
    }

    public double getAsto() {
        return asto;
    }

    public void setAsto(double asto) {
        this.asto = asto;
    }

    public double getAsts() {
        return asts;
    }

    public void setAsts(double asts) {
        this.asts = asts;
    }

}
