/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.clazz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author damien
 */
public class PackageBeanValidator {
    private String path;
    private String pathTest;
    private List<Clazz> lesClasses;

    public PackageBeanValidator() {
        lesClasses = new ArrayList<>();
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Clazz> getLesClasses() {
        return lesClasses;
    }

    public void setLesClasses(List<Clazz> lesClasses) {
        this.lesClasses = lesClasses;
    }
    
    
    
    public void gererLesFichiers() throws IOException{
        
        Path chemin;
        BufferedWriter writer;
        Path parentDir = Paths.get(path);
        Path parentDirTest = Paths.get(pathTest);
        if(!Files.exists(parentDir)){
            Files.createDirectories(parentDir);
        }
        if(!Files.exists(parentDirTest)){
            Files.createDirectories(parentDirTest);
        }
        for(Clazz clazz : lesClasses){
            chemin = Paths.get(path + clazz.getName()+".java");
            writer = Files.newBufferedWriter(chemin);
            writer.write(clazz.ecrireChamp());
            writer.flush();
            writer.close();
            chemin = Paths.get(pathTest + clazz.getName()+".java");
            writer = Files.newBufferedWriter(chemin);
            writer.write(clazz.ecrireTests());
            writer.flush();
            writer.close();
        }
        
    }

    public String getPathTest() {
        return pathTest;
    }

    public void setPathTest(String pathTest) {
        this.pathTest = pathTest;
    }

    @Override
    public String toString() {
        return "package : " + path;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.path);
        hash = 97 * hash + Objects.hashCode(this.pathTest);
        hash = 97 * hash + Objects.hashCode(this.lesClasses);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PackageBeanValidator other = (PackageBeanValidator) obj;
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.pathTest, other.pathTest)) {
            return false;
        }
        if (!Objects.equals(this.lesClasses, other.lesClasses)) {
            return false;
        }
        return true;
    }
    
    
}
