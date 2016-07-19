/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter("documentoConverter")
public class documentoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String doc="";
        if(value != null){
            doc = (String) value;
            switch(doc){
                case "FA":
                    doc="Factura";
                break;
                case "BV":
                    doc="Boleta de venta";
                break;
                 case "NA":
                    doc="Nota de abono";
                break;
                 case "NC":
                 doc="Nota de cargo";
                break; 
                case "TK":
                 doc="Ticket";
                break;
                 case "GR":
                 doc="Guia de remisión";
                break; 
                 case "GT":
                 doc="Guia de transporte";
                break; 
            }
        }
        return doc;
    }
    
}
