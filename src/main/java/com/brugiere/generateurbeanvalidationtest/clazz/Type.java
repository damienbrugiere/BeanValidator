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
public abstract class Type {

    private String name;
    private List<BeanValidation> lesBeanValidationsPossible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BeanValidation> getLesBeanValidationsPossible() {
        return lesBeanValidationsPossible;
    }

    public void setLesBeanValidationsPossible(List<BeanValidation> lesBeanValidationsPossible) {
        this.lesBeanValidationsPossible = lesBeanValidationsPossible;
    }

    public Type(String name, List<BeanValidation> lesBeanValidationsPossible) {
        this.name = name;
        this.lesBeanValidationsPossible = lesBeanValidationsPossible;
    }

    

    public boolean isValid(Attribut attribut) {
        if (!this.equals(attribut.getType())) {
            return false;
        }
        for (BeanValidation beanValidation : attribut.getBeanValidations()) {
            if (!this.getLesBeanValidationsPossible().contains(beanValidation)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.lesBeanValidationsPossible);
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
        final Type other = (Type) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lesBeanValidationsPossible, other.lesBeanValidationsPossible)) {
            return false;
        }
        return true;
    }

}
