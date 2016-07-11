/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author damien
 */
public class Clazz {
    private String name;
    private List<Attribut> attributs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribut> getAttributs() {
        return attributs;
    }

    public void setAttributs(List<Attribut> attributs) {
        this.attributs = attributs;
    }
 
    public String ecrireChamp(){
        String clazz = "public class "+name+"{\n";
        for (Attribut attribut : attributs) {
            clazz += attribut.ecrireLeChamp();
        }
        clazz +="\n}";
        return clazz;
    }
    
    public String ecrireTests(){
         String clazz = "public class "+name+"Test{\n";
        for (Attribut attribut : attributs) {
            clazz += attribut.ecrireLesTests(this);
        }
        clazz +="\n}";
        return clazz;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.attributs);
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
        final Clazz other = (Clazz) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.attributs, other.attributs)) {
            return false;
        }
        return true;
    }
    
    
}
