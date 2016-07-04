/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation;

import com.brugiere.generateurbeanvalidationtest.clazz.Attribut;
import com.brugiere.generateurbeanvalidationtest.clazz.BeanValidation;
import com.brugiere.generateurbeanvalidationtest.clazz.Clazz;

import static java.lang.Math.random;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author damien
 */
public class Size extends BeanValidation {

    
  private static Random random = new Random((new Date()).getTime());
    private Integer value;

    public Size(Integer value, String messageError) {
        super("{always." + messageError + ".size.exceded}");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String ecrirLeChamp() {
        return "@Size(message=\"" + this.getMessageError() + "\", value =" + this.value + ")\n";
    }

    private String generateurDeString(int taille) {
        char[] values = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9'};

        String out = "";

        for (int i = 0; i < taille; i++) {
            int idx = random.nextInt(values.length);
            out += values[idx];
        }
        return out;
    }

    @Override
    public String ecrirLesTests(Attribut attribut, Clazz clazz) {
         String setterString = Character.toUpperCase(attribut.getName().charAt(0))+attribut.getName().substring(1);
        return "@Test\n"
                + "public void shouldNotValidateA" + attribut.getName() + "LessThan" + (this.value) + "(){\n"
                + clazz.getName() + " " + clazz.getName() + "= fullBean();\n"
                + clazz.getName() + ".set" + setterString + "(" + this.value + ");\n"
                + "Set<ConstrainteViolations<" + clazz.getName() + ">>> violations = validator.validate(" + generateurDeString(this.value) + ");\n"
                + "assertThat(violations).extracting(\"message\").constainsExactly(" + this.getMessageError() + ");\n"
                + "}\n";
    }

}
