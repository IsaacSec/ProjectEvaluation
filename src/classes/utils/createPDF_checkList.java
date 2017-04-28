/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.utils;

import classes.config.CNodeID;
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
import javafx.scene.Scene;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

class createPDF_checkList {

    String dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18, dato19, dato20;

    public String writePDF(Scene scene,String datos) throws FileNotFoundException, DocumentException, BadElementException, IOException {

        javafx.scene.control.TextField projectName = (javafx.scene.control.TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        String project = projectName.getText();
        StringTokenizer st = new StringTokenizer(datos, "*");

        dato1 = st.nextToken();
        dato2 = st.nextToken();
        dato3 = st.nextToken();
        dato4 = st.nextToken();
        dato5 = st.nextToken();
        dato6 = st.nextToken();
        dato7 = st.nextToken();
        dato8 = st.nextToken();
        dato9 = st.nextToken();
        dato10 = st.nextToken();
        dato11 = st.nextToken();
        dato12 = st.nextToken();
        dato13 = st.nextToken();
        dato14 = st.nextToken();
        dato15 = st.nextToken();
        dato16 = st.nextToken();
        dato17 = st.nextToken();

        Document document = new Document(PageSize.LETTER, 80, 80, 50, 50);
        FileOutputStream salida = new FileOutputStream(project+"_CheckList.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, salida);
        writer.setInitialLeading(0);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(new Font(FontFactory.getFont("Courier", 20, Font.BOLDITALIC, BaseColor.RED)));
        paragraph.add("\n\n\nCHECK LIST");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Image image = Image.getInstance("/home/isaac/IdeaProjects/ProjectEvaluation/src/images/logo_report.png");

        image.scaleToFit(150, 150);

        image.setAlignment(Chunk.ALIGN_RIGHT);

        Paragraph paragraph_2 = new Paragraph();
        paragraph_2.setFont(new Font(FontFactory.getFont("Courier", 12, Font.BOLD, BaseColor.BLUE)));
        paragraph_2.add("\n\n\n\n\n\n\nADMINISTRACION Y EVALUACION DE PROYECTOS\n\n SERGIO VALDES TORRES A01365520\n ERIK MARTIN A01365096\nISAAC SECUNDINO A01361162\n IVAN CABRER A01184937");
        paragraph_2.setAlignment(Paragraph.ALIGN_RIGHT);

        Paragraph paragraph_4 = new Paragraph();
        paragraph_4.setFont(new Font(FontFactory.getFont("Courier", 6, Font.BOLD, BaseColor.BLACK)));
        paragraph_4.add("Strategy---Alignment What specific organization strategy does this project align with?"+"     "+dato1+"\n"
                + "Driver---What business problem does the project solve?"+"     "+dato2+"\n"
                + "Success Metrics---How will measure success?"+"     "+dato3+"\n"
                + "Sponsorship---Who is the project sponsor?"+"     "+dato4+"\n"
                + "Risk---What is the impact of not doing this project?"+"     "+dato5+"\n"
                + "Risk---What is the project risk to our organization?"+"     "+dato6+"\n"
                + "Risk---Where does the proposed project fit in our risk profile?"+"     "+dato7+"\n"
                + "Benefits, value---What is the value of the project organization?"+"     "+dato8+"\n"
                + "Benefits, value---When will the project shows results?"+"     "+dato9+"\n"
                + "Objectives---What are the project objectives?"+"     "+dato10+"\n"
                + "Organization Culture---Is our organization culture right for this type of project?"+"     "+dato11+"\n"
                + "Resources---Will internal resources be available for this project?"+"     "+dato12+"\n"
                + "Approach---Will we build or buy?"+"     "+dato13+"\n"
                + "Schedule---How long will this project take?"+"     "+dato14+"\n"
                + "Schedule---Is the timeline realistic?"+"     "+dato15+"\n"
                + "Training/Resources---Will staff training be required?"+"     "+dato16+"\n"
                + "Finance/Portfolio---What is the estimated cost of the project?"+"     "+dato17+"\n");
                /*+ "Portfolio---Is this a new initiative or path of an existing initiative?"+"     "+dato18+"\n"
                + "Portfolio---How does this project interact with current projects?"+"     "+dato19+"\n"
                + "Technology---Is the technology available or new?"+"     "+dato20+"");
                */

        paragraph_4.setAlignment(Paragraph.ALIGN_LEFT);

        document.open();
        document.add(image);

        document.add(paragraph);

        document.add(paragraph_4);

        document.add(paragraph_2);
        document.close();
        return "pdf Creado";

    }

}
