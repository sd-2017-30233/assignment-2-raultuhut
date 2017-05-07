package app;


import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Raul on 5/4/2017.
 */
public class ReportCsv implements Report {


    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "title,author,genre,quantity,price";

    @Override
    public void generate(String fileName) {
        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("books.xml")));
            ArrayList<Book> list = (ArrayList<Book>) a.readObject();


            FileWriter fileWriter = null;

            try {
                fileWriter = new FileWriter(fileName);

                //Write the CSV file header
                fileWriter.append(FILE_HEADER.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);

                //Write a new student object list to the CSV file
                for (Book b : list) {
                    if(b.quantity==0) {
                        fileWriter.append(b.getTitle());
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(b.getAuthor());
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(b.getGenre());
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(String.valueOf(b.getQuantity()));
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(String.valueOf(b.getPrice()));
                        fileWriter.append(NEW_LINE_SEPARATOR);
                    }
                }


                System.out.println("CSV file was created successfully !!!");

            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            } finally {

                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}












