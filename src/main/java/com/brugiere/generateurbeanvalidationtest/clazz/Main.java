/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

import com.brugiere.generateurbeanvalidationtest.jframe.Application;
/**
 *
 * @author damien
 */
public class Main {
    public static void main(String[] args) {
        new Application("Bean validator générateur");
//        Clazz c = new Clazz();
//        c.setName("Test");
//        List<Attribut> attributs = Arrays.asList(
//        new Attribut("value",
//                BeanValidationFactory.getStringType(c),
//                Arrays.asList(new NotNull("value"), new Size(5, "value")))
//        );
//        c.setAttributs(attributs);
//        System.out.println(c.ecrireChamp());  
//        System.out.println(c.ecrireTests());
//        Package p = new Package();
//        p.setPath("com/dbrugiere/java/src/");
//        p.setPathTest("com/dbrugiere/java/test/");
//        p.setLesClasses(Arrays.asList(c));
//        
//        try {
//            p.gererLesFichiers();
//        } catch (IOException ex) {
//          System.out.println(ex.getMessage());
//        }
     
    }
}
