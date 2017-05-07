package app;
import com.itextpdf.text.Document;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;

import javax.swing.text.Element;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Raul on 5/4/2017.
 */
public class ReportPdf implements Report {

  //  private static final String FILE_NAME = "/tmp/itext.pdf";
    @Override
    public void generate(String fileName) {

       try {
           Document document = new Document();
           XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("books.xml")));
           ArrayList<Book> list = (ArrayList<Book>) a.readObject();
           Paragraph paragraph1 = new Paragraph("title,author,genre,quantity,price");

           PdfWriter.getInstance(document, new FileOutputStream(fileName));
           document.open();
           document.add(paragraph1);
           for(Book b: list) {
              if (b.quantity==0) {
                  paragraph1 = new Paragraph(b.title + " ," + b.author + " ," + b.genre + " ," + b.quantity + " ," + b.price);
                  document.add(paragraph1);
              }

           }
           document.close();
       }
       catch (Exception e){
           System.out.println(e);
       }
    }
}
