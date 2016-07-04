/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

import com.brugiere.generateurbeanvalidationtest.clazz.Types.IntegerType;
import com.brugiere.generateurbeanvalidationtest.clazz.Types.StringType;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.Max;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.Min;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.NotEmpty;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.NotNull;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.Size;
import java.util.Arrays;

/**
 *
 * @author damien
 */
public final class BeanValidationFactory {
    
    public static StringType getStringType(Clazz clazz){
       return new StringType("String", Arrays.asList(
                new NotNull(clazz.getName()), new NotEmpty(clazz.getName()),new Size(null, clazz.getName())));
    }
    
    public static IntegerType getIntegerType(Clazz clazz){
         return new IntegerType("Integer", Arrays.asList(
                new Min(null, clazz.getName()), new NotEmpty(clazz.getName()),new Min(null, clazz.getName()), new NotNull(clazz.getName())));
    }
    
}
