package app;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Raul on 4/24/2017.
 */
public class Test {
    public static void main(String args[]) {
      /*  try {
            List<User> list = new ArrayList<User>();
            //Book book1 = new Book("pelele", "creangle", "actiunele", 12, 12);
            //Book book = new Book("pele", "creang", "actiune", 12, 12);
            // list.add(book);
            //list.add(book1);
            User adm = new User("admin", "admin", 1);
            User tuhut = new User("tuhut", "admin", 1);

            XMLEncoder adminii = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("admins.xml")));
            adminii.writeObject(adm);
            adminii.writeObject(tuhut);
            adminii.close();
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("admins.xml")));
            User t = (User) a.readObject();
            User t1 = (User) a.readObject();
            System.out.println(t.username);
            System.out.println(t1.username);


        }
        catch (FileNotFoundException e) {
            System.out.println(e);

        }
        */

        try {

            User adm = new User("admin", "admin", 1);
            User tuhut = new User("tuhut", "admin", 1);
            User coci = new User("coci", "admin", 0);
            ArrayList<User> list=new ArrayList<>();
            list.add(adm);
            list.add(tuhut);
            list.add(coci);


            XMLEncoder adminii = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("admins.xml")));
            adminii.writeObject(list);
            adminii.close();

              Book b=new Book("Povestea porcului","Ion Creanga","comedie",33,21.2);
               Book b1=new Book("Povestea porcului","Mihai Eminescu","tragedie",33,21.2);
               Book b3=new Book("Harap Alb","Ion Creanga","comedie",33,21.1);
               Book b4=new Book("Povestea porcului","Petre Ispirescu","actiune",33,21.2);
            Book b5=new Book("Povestea porcului","Petre Ispirescu","actiune",0,21.2);
            Book b6=new Book("Povestea noastra","Ilie Ispirescu","actiune",0,21.2);
            Book b7=new Book("Povestea noastra","Andrei Ispirescu","actiune",0,21.2);


               ArrayList<Book> bookList=new ArrayList<>();
               bookList.add(b);
               bookList.add(b1);
               bookList.add(b3);
               bookList.add(b4);
               bookList.add(b5);
                bookList.add(b6);
            bookList.add(b7);

               XMLEncoder cartile = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("books.xml")));
               cartile.writeObject(bookList);
               cartile.close();
       //     XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("admins.xml")));
         //   User t = (User) a.readObject();
           // User t1 = (User) a.readObject();
           // System.out.println(t.username);
           // System.out.println(t1.username);


        }
        catch (FileNotFoundException e) {
            System.out.println(e);

        }


        LoginView lv=new LoginView();
        Controller c=new Controller(lv);
      //  LoginView loginView=new LoginView();
    }
}