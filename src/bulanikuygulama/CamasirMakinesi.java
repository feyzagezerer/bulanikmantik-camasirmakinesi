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
public class CamasirMakinesi {
    private FIS fis;
    private double kirlilik_yuzde;
    private double camasir_tur;
    
    public CamasirMakinesi(double kirlilik_yuzde, double camasir_tur) throws URISyntaxException{
        this.kirlilik_yuzde = kirlilik_yuzde;
        this.camasir_tur = camasir_tur;
        File dosya = new File(getClass().getResource("CamasirMakinesi.fcl").toURI());
        fis = FIS.load(dosya.getPath());
        fis.setVariable("kirlilik_yuzde", kirlilik_yuzde);
        fis.setVariable("camasir_tur", camasir_tur);
        fis.evaluate();
    }
    
     public CamasirMakinesi() throws URISyntaxException{
        File dosya = new File(getClass().getResource("CamasirMakinesi.fcl").toURI());
        fis = FIS.load(dosya.getPath(),true);
    }
    
    public FIS getModel(){
        return fis;
    }
    
    @Override
    public String toString(){
        String cikti = "kirlilik_yuzde: "+kirlilik_yuzde+"\n"+
                        "camasir_tur: "+camasir_tur+"\n"+
                        "yikama_suresi: "+fis.getVariable("yikama_suresi").getValue();
        return cikti;
    }
    
    
}
