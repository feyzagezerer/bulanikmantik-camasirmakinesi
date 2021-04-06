/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulanikuygulama;

import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author Muhammed
 */
public class BulanikUygulama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Servis (0-9):");
        double servis = in.nextDouble();
        System.out.print("Yemek (0-9):");
        double yemek = in.nextDouble();
        try {
            Restaurant r = new Restaurant();
            JFuzzyChart.get().chart(r.getModel());
        } catch (URISyntaxException ex) {
            System.out.print("HATA");
        }
    }
    
}
