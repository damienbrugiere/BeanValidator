/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

import java.util.List;

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
}
