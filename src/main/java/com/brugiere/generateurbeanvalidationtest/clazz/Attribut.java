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
public class Attribut {

    private String name;
    private Type type;
    private List<BeanValidation> beanValidations;

    public Attribut(String name, Type type, List<BeanValidation> beanValidations) {
        this.name = name;
        this.type = type;
        this.beanValidations = beanValidations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<BeanValidation> getBeanValidations() {
        return beanValidations;
    }

    public void setBeanValidations(List<BeanValidation> beanValidations) {
        this.beanValidations = beanValidations;
    }

    public String ecrireLeChamp() {
        String attribut = new String();
        for (BeanValidation beanValidation : beanValidations) {
            attribut += beanValidation.ecrirLeChamp();
        }
        attribut += "private " + type.getName() + " " + name;
        return attribut;
    }

    public String ecrireLesTests(Clazz clazz) {
        String tests = new String();
        for (BeanValidation beanValidation : beanValidations) {
            tests += beanValidation.ecrirLesTests(this, clazz);
        }
        return tests;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + Objects.hashCode(this.beanValidations);
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
        final Attribut other = (Attribut) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.beanValidations, other.beanValidations)) {
            return false;
        }
        return true;
    }
    

}
