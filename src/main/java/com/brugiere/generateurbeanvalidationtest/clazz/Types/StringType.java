/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz.Types;

import com.brugiere.generateurbeanvalidationtest.clazz.BeanValidation;
import com.brugiere.generateurbeanvalidationtest.clazz.Type;
import java.util.List;

/**
 *
 * @author damien
 */
public class StringType extends Type {

    public StringType(String name, List<BeanValidation> lesBeanValidationsPossible) {
        super(name, lesBeanValidationsPossible);
    }
    
}
