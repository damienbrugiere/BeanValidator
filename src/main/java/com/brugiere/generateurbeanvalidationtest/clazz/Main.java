/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.NotNull;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.Size;
import java.util.Arrays;
import java.util.List;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author damien
 */
public class Main {
    public static void main(String[] args) {
        Clazz c = new Clazz();
        c.setName("Test");
        List<Attribut> attributs = Arrays.asList(
        new Attribut("value",
                BeanValidationFactory.getStringType(c),
                Arrays.asList(new NotNull("value"), new Size(5, "value")))
        );
        c.setAttributs(attributs);
        System.out.println(c.ecrireChamp());  
        System.out.println(c.ecrireTests());
    }
}
