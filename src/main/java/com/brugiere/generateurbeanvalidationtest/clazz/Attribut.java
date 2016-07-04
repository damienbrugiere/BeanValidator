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

}
