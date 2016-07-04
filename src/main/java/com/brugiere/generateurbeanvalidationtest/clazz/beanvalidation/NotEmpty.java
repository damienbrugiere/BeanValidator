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
public class NotEmpty extends BeanValidation{

    public NotEmpty(String messageError) {
        super("{always."+messageError+".mandatory}");
    }

    
    
    @Override
    public String ecrirLeChamp() {
             return "@NotBlank(message=\""+this.getMessageError()+"\")\n";
    }
       

   @Override
    public String ecrirLesTests(Attribut attribut,Clazz clazz) {
         String setterString = Character.toUpperCase(attribut.getName().charAt(0))+attribut.getName().substring(1);
       return "@Test\n"
               + "public void shouldNotValidateANull"+attribut.getName()+"(){\n"
               + clazz.getName() + " " + clazz.getName() + "= fullBean();\n"
               + clazz.getName()+".set"+setterString+"(null);\n"
               + "Set<ConstrainteViolations<"+clazz.getName()+">>> violations = validator.validate("+ clazz.getName() +");\n"
               + "assertThat(violations).extracting(\"message\").constainsExactly("+this.getMessageError()+");\n"
               + "}\n\n"
               + "@Test\n"
               + "public void shouldNotValidateAnEmpty"+attribut.getName()+"(){\n"
               + clazz.getName() + " " + clazz.getName() + "= fullBean();\n"
               + clazz.getName()+".set"+attribut.getName()+"(\"\");\n"
               + "Set<ConstrainteViolations<"+clazz.getName()+">>> violations = validator.validate("+ clazz.getName() +");\n"
               + "assertThat(violations).extracting(\"message\").constainsExactly("+this.getMessageError()+");\n"
               + "}\n";
    }
    
}
