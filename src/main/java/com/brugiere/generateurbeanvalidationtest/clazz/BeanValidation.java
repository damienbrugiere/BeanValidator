/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

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
    
    
}
