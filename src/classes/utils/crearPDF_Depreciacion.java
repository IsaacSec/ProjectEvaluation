/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

class crearPDF_Depreciacion {
    
    String principal,salvageV,period,tax,periodSalvage,category,data;

    public String writePDF(String datos) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        
        StringTokenizer st = new StringTokenizer(datos, "_");

        principal = st.nextToken();
        salvageV = st.nextToken();
        period = st.nextToken();
        tax = st.nextToken();
        periodSalvage =st.nextToken();
        category = st.nextToken();
        data=st.nextToken();

        Document document = new Document(PageSize.LETTER, 80, 80, 50, 50);
        FileOutputStream salida = new FileOutputStream("Deprecicacion.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, salida);
        writer.setInitialLeading(0);
        
        Paragraph paragraph = new Paragraph();
        paragraph.setFont(new Font(FontFactory.getFont("Courier", 20, Font.BOLDITALIC, BaseColor.RED)));
        paragraph.add("\n\n\nDEPRECIACION");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
         Image image = Image.getInstance("imagen.png");
        
        image.scaleToFit(150, 150);
        
        Image image1 = Image.getInstance("imagen1.png");
        
        image1.scaleToFit(300, 300);
        
        image.setAlignment(Chunk.ALIGN_RIGHT);
        image1.setAlignment(Chunk.ALIGN_CENTER);
        
        Paragraph paragraph_2 = new Paragraph();
        paragraph_2.setFont(new Font(FontFactory.getFont("Courier", 12, Font.BOLD, BaseColor.BLUE)));
        paragraph_2.add("\n\n\n\n\n\n\n\n\n\n\nADMINISTRACION Y EVALUACION DE PROYECTOS\n\n SERGIO VALDES TORRES A01365520\n ERIK MARTIN A01365096\nISAAC SECUNDINO A01361162\n IVAN CABRER A01184937");
        paragraph_2.setAlignment(Paragraph.ALIGN_RIGHT);
        
        Paragraph paragraph_3=new Paragraph();
        paragraph_3.setFont(new Font(FontFactory.getFont("Courier", 11, Font.BOLD, BaseColor.BLACK)));
        paragraph_3.add("\n "+data);
        paragraph_3.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph_5=new Paragraph();
        paragraph_5.setFont(new Font(FontFactory.getFont("Courier", 6, Font.BOLD, BaseColor.BLUE)));
        paragraph_5.add("\n\nP   DEPRECIATON RATE  ANNUAL DEPRECIATON  CUMMULATIVE DEPRECIATON  VALUE IN LEDGERS ");
        paragraph_5.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph_4=new Paragraph();
        paragraph_4.setFont(new Font(FontFactory.getFont("Courier", 9, Font.BOLD, BaseColor.BLACK)));
        paragraph_4.add("Nombre del Evaluador: \n Principal: "+principal+" \n Salvag Value: "+salvageV+" \n Numero de Periodos: "+period+"\n Tax: "+tax+" \n Salvage Period: "+periodSalvage+"\n Categoria: "+category);
        paragraph_4.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph_6=new Paragraph();
        paragraph_6.setFont(new Font(FontFactory.getFont("Courier", 15, Font.BOLD, BaseColor.GRAY)));
        paragraph_6.add("\n GRAFICAS\n");
        paragraph_6.setAlignment(Paragraph.ALIGN_CENTER);
        
        
        document.open();
        document.add(image);
      
        document.add(paragraph);
        
        
        document.add(paragraph_4);
        document.add(paragraph_5);
        document.add(paragraph_3);
        document.add(paragraph_6);
        document.add(image1);
        document.add(paragraph_2);
        document.close();
        return null;

    }
    
}

