/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

import com.brugiere.generateurbeanvalidationtest.clazz.Types.IntegerType;
import com.brugiere.generateurbeanvalidationtest.clazz.Types.SimpleType;
import com.brugiere.generateurbeanvalidationtest.clazz.Types.StringType;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.Max;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.Min;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.NotEmpty;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.NotNull;
import com.brugiere.generateurbeanvalidationtest.clazz.beanvalidation.Size;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author damien
 */
public final class TypeFactory {
    
    public static Type getType(String type){
        switch(type){
            case "String":
                return getStringType();
            case "Integer" : 
                return getIntegerType();
            case "int" :
                return getIntegerType();
            default:
                return new SimpleType(type,new ArrayList<BeanValidation>(Arrays.asList(new NotNull(null))));
        }
    }
    public static StringType getStringType(){
       return new StringType("String", Arrays.asList(
                new NotNull(null), new NotEmpty(null),new Size(null,null, null)));
    }
    
    public static IntegerType getIntegerType(){
         return new IntegerType("Integer", Arrays.asList(
                new Min(null, null), new NotEmpty(null),new Min(null, null), new NotNull(null)));
    }
    
}
