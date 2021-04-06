/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulanikuygulama;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 *
 * @author Muhammed
 */
public class Restaurant {
    private FIS fis;
    private double servis;
    private double yemek;
    
    public Restaurant(double servis, double yemek) throws URISyntaxException{
        this.servis = servis;
        this.yemek = yemek;
        
        File dosya = new File(getClass().getResource("model.fcl").toURI());
        fis = FIS.load(dosya.getPath(),true);
        fis.setVariable("servis", servis);
        fis.setVariable("yemek", yemek);
        fis.evaluate();
    }
    
    public Restaurant() throws URISyntaxException{
        File dosya = new File(getClass().getResource("model.fcl").toURI());
        fis = FIS.load(dosya.getPath(),true);
    }
    
    public FIS getModel(){
        return fis;
    }
    
    @Override
    public String toString(){
        String cikti = "servis: "+servis+"\n"+
                        "yemek: "+yemek+"\n"+
                        "tur: "+fis.getVariable("tur").getValue();
        return cikti;
    }
}
