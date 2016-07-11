/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brugiere.generateurbeanvalidationtest.jframe;

import com.brugiere.generateurbeanvalidationtest.clazz.PackageBeanValidator;
import java.awt.HeadlessException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author damien
 */
public class Application extends JFrame {

    private CreationPackage creationPackage;
    private CreationClasse creationClasse;
    private Home home;
    private Set<PackageBeanValidator> packages;

    public Application(String title) throws HeadlessException {
        super(title);
        packages = new HashSet<PackageBeanValidator>();
        creationPackage = new CreationPackage(this);
        creationClasse = new CreationClasse(this);
        home = new Home(this);
        this.setSize(800, 800);
        this.getContentPane().add(home);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void changementEcranCreationClasse() {
        this.changementEcran(creationClasse);
    }

    public void changementEcranCreationClasse(PackageBeanValidator package1) {
        this.changementEcran(creationClasse);
        creationClasse.setPackageBean(package1);
        this.packages.add(package1);
        home.refreshList();
    }

    public void changementEcranCreationPackage() {
        this.changementEcran(creationPackage);
    }

    public void changementEcranHome() {
        this.changementEcran(home);
    }

    private void changementEcran(JPanel ecran) {
        this.getContentPane().removeAll();
        this.getContentPane().add(ecran);
        this.revalidate();
        this.pack();
    }

    public Set<PackageBeanValidator> getPackages() {
        return packages;
    }

    public void setPackages(Set<PackageBeanValidator> packages) {
        this.packages = packages;
    }

}
