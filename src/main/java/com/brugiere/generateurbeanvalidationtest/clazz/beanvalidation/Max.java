/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation;

import com.brugiere.generateurbeanvalidationtest.clazz.Attribut;
import com.brugiere.generateurbeanvalidationtest.clazz.BeanValidation;
import com.brugiere.generateurbeanvalidationtest.clazz.Clazz;

/**
 *
 * @author damien
 */
public class Max extends BeanValidation{
     
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Max(Integer value, String messageError) {
         super("{always."+messageError+".maxvalue.exceded}");
        this.value = value;
    }

    
    
    @Override
    public String ecrirLeChamp() {
            return "@Max(message=\""+this.getMessageError()+"\", value ="+this.value+")\n";
    }

    @Override
    public String ecrirLesTests(Attribut attribut,Clazz clazz) {
         String setterString = Character.toUpperCase(attribut.getName().charAt(0))+attribut.getName().substring(1);
        return "@Test\n"
               + "public void shouldNotValidateA"+attribut.getName()+"GreaterThan"+(this.value+1)+ "(){\n"
               + clazz.getName() + " " + clazz.getName() + "= fullBean();\n"
               + clazz.getName()+".set"+setterString+"("+this.value+1+");\n"
               + "Set<ConstrainteViolations<"+clazz.getName()+">>> violations = validator.validate("+ clazz.getName() +");\n"
               + "assertThat(violations).extracting(\"message\").constainsExactly("+this.getMessageError()+");\n"
               + "}\n";
    }
}
