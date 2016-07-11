/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

import java.util.Objects;

/**
 *
 * @author damien
 */
public abstract class BeanValidation {
    private String messageError;

    protected BeanValidation(String messageError) {
        this.messageError = messageError;
    }
    
    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public abstract String ecrirLeChamp();
    
    public abstract String ecrirLesTests(Attribut attribut,Clazz clazz);

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.messageError);
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
        final BeanValidation other = (BeanValidation) obj;
        if (!Objects.equals(this.messageError, other.messageError)) {
            return false;
        }
        return true;
    }
    
    
}
