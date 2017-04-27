/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.utils;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author LENOVO Y50
 */
public class Depre {

    calculateStraightLine lineal =new calculateStraightLine();
    calculateMARCS  marcs = new calculateMARCS();
    crearPDF_Depreciacion     pdf=new crearPDF_Depreciacion();
    createPDF_PayBack       pdf_payBack=new createPDF_PayBack();
    createPDF_NetPresent    pdf_netPresent =new createPDF_NetPresent();
    
    
    public Depre() throws DocumentException, BadElementException, IOException{
        
        int period,opc;
        float principal,tax,salvageV,periodSalvage;
        String category="";
        String datos,result;
        
        
        Scanner scan=new Scanner(System.in);
        
        System.out.println("\n Deprecicacion \n");
        System.out.println("VALOR PRINCIPAL = ");
        principal=scan.nextFloat();
        System.out.println("SALVAGE VALUE= ");
        salvageV=scan.nextFloat();
        System.out.println("PERIODOS=");
        period=scan.nextInt();
        System.out.println("TAX= ");
        tax=scan.nextFloat();
        System.out.println("PERIOD STARTING= ");
        periodSalvage=scan.nextFloat();
        System.out.println("CATEGORY :\n1.- 3 YEARS \n2.- 5 YEARS\n3.- 7 YEARS\n4.- 10 YEARS\n5.- 15 YEARS\n6.- 20 YEARS");
        opc=scan.nextInt();
        
        switch(opc)
        {
            case 1: category="3 YEARS";
                break;
            case 2: category="5 YEARS";
                break;
            case 3: category="7 YEARS";
                break;
            case 4: category="10 YEARS";
                break;
            case 5: category="15 YEARS";
                break;
            case 6: category="20 YEARS";
                break;
                
        }
        
        
       
        
        Float.toString(principal);
        Float.toString(tax);
        Float.toString(salvageV);
        Float.toString(periodSalvage);
        Integer.toString(period);
        
        datos=principal+"_"+salvageV+"_"+period+"_"+tax+"_"+periodSalvage+"_"+category;
        
        //result=lineal.calculo(datos);
        result=marcs.calculo(datos);
        datos=datos+"_"+result;
        //pdf.writePDF(datos);
        //pdf_payBack.writePDF(datos);
        pdf_netPresent.writePDF(datos);
        
       
        System.out.println(result);
        //System.out.println(datos);
      // System.out.println(category);
       // System.out.println(lineal.getAccDep());
    }
    public static void main(String[] args) throws DocumentException, BadElementException, IOException {
        
      
     
        new Depre();
        
      
    }
    
}
