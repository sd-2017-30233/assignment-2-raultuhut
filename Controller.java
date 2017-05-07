package app;

import com.itextpdf.text.DocumentException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

import static com.itextpdf.text.pdf.PdfName.DEST;

/**
 * Created by Raul on 5/2/2017.
 */
public class Controller {
    static LoginView lv;
    static UserView userView;
    static AdminView adminView;

    public Controller(LoginView lv) {
        this.lv = lv;
    }

    public static void login(String cmd, int x) {

        if (cmd == "login") {
            try {
                XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("admins.xml")));
                ArrayList<User> list = (ArrayList<User>) a.readObject();
                boolean ok = true;
                int i = 0;
                for (User t : list) {

                    //  t = (User) a.readObject();
                    if ((t.getPassword().equals(lv.textFieldPass.getText())) && (t.getUsername().equals(lv.textFieldUser.getText()))) {
                        ok = false;
                        lv.frame.dispose();
                        //UserView userView = new UserView();
                        if (t.type == 0) userView = new UserView();
                        else adminView = new AdminView();
                    }
                }
                if (ok) JOptionPane.showMessageDialog(lv.frame, "User inexistent.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(lv.frame, "User inexistent.");
                //System.out.println();
            }


        }
        ;
        if (cmd == "logout") {
            if (x == 1)
                adminView.frame.dispose();
            else if (x == 0) userView.frame.dispose();
            lv = new LoginView();
        }
        ;

    }

    public static void searchBook() {

        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("books.xml")));
            ArrayList<Book> list = (ArrayList<Book>) a.readObject();
            String by = userView.searchBy.getText();
            int i = 0;
            int k = 0;
            Object[][] data;
            switch (by) {
                case "t":
                    i = 0;
                    k = 0;
                    for (Book b : list)
                        if (b.title.equals(userView.textFieldTitle.getText())) k++;
                    //   Object [][] data={{ new String(),  new String(),
                    //         new String() , new Integer(0),new Double(0)}};
                    data = new Object[k][6];
                    for (Book b : list) {
                        if (b.title.equals(userView.textFieldTitle.getText())) {

                            data[i][0] = b.title;
                            data[i][1] = b.author;
                            data[i][2] = b.genre;
                            data[i][3] = b.quantity;
                            data[i][4] = b.price;
                            i++;
                        }


                        userView.setTabel(data);
                    }
                    break;
                case "a":
                    i = 0;
                    k = 0;
                    for (Book b : list)
                        if (b.author.equals(userView.textFieldAuthor.getText())) k++;
                    data = new Object[k][6];
                    for (Book b : list) {
                        if (b.author.equals(userView.textFieldAuthor.getText())) {
                            data[i][0] = b.title;
                            data[i][1] = b.author;
                            data[i][2] = b.genre;
                            data[i][3] = b.quantity;
                            data[i][4] = b.price;
                            i++;
                        }
                    }
                    userView.setTabel(data);
                    break;
                case "g":
                    i = 0;
                    k = 0;
                    for (Book b : list)
                        if (b.genre.equals(userView.textFieldGenre.getText())) k++;
                    data = new Object[k][6];
                    for (Book b : list) {
                        if (b.genre.equals(userView.textFieldGenre.getText())) {
                            data[i][0] = b.title;
                            data[i][1] = b.author;
                            data[i][2] = b.genre;
                            data[i][3] = b.quantity;
                            data[i][4] = b.price;
                            i++;
                        }
                        userView.setTabel(data);
                    }
                    break;
                default:
                    System.out.println("Cartea cautata nu exista");
                    break;

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void sellBook() {
        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("books.xml")));
            ArrayList<Book> list = (ArrayList<Book>) a.readObject();
            String by = userView.searchBy.getText();
            int k = Integer.parseInt(by);
            for (Book b : list)
                if (userView.textFieldTitle.getText().equals(b.title) && (userView.textFieldAuthor.getText().equals(b.author)) && (k <= b.quantity)) {
                    b.quantity -= k;
                    JOptionPane.showMessageDialog(lv.frame, "S-au vandut " + k + " carti");
                } else if (k > b.quantity) JOptionPane.showMessageDialog(lv.frame, "Stoc insuficient");
            XMLEncoder cartile = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("books.xml")));
            cartile.writeObject(list);
            cartile.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void createBook() {
        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("books.xml")));
            ArrayList<Book> list = (ArrayList<Book>) a.readObject();
            Book b = new Book(adminView.textFieldTitle.getText(), adminView.textFieldAuthor.getText(), adminView.textFieldGenre.getText(), Integer.parseInt(adminView.textFieldQuantity.getText()), Double.parseDouble(adminView.textFieldPrice.getText()));
            boolean ok = false;
            int i = 0;
            int k = 0;
            for (Book b1 : list) {
                if ((adminView.textFieldTitle.getText().equals(b1.title)) && (adminView.textFieldAuthor.getText().equals(b1.author)) && (adminView.textFieldGenre.getText().equals(b1.genre))) {
                    k = i;
                    ok = true;
                }
                i++;
            }


            if (ok) {
                list.get(k).quantity += b.quantity;
                JOptionPane.showMessageDialog(lv.frame, "Cartea exista, marim stocul");
            } else list.add(b);
            XMLEncoder cartile = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("books.xml")));
            cartile.writeObject(list);
            cartile.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void updateBook() {
        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("books.xml")));
            ArrayList<Book> list = (ArrayList<Book>) a.readObject();
            Book b = new Book(adminView.textFieldTitle.getText(), adminView.textFieldAuthor.getText(), adminView.textFieldGenre.getText(), Integer.parseInt(adminView.textFieldQuantity.getText()), Double.parseDouble(adminView.textFieldPrice.getText()));
            boolean ok = false;
            int i = 0;
            int k = 0;
            for (Book b1 : list) {
                if (((!b1.title.equals(b.title)) && (b1.author.equals(b.author)) && (b1.genre.equals(b.genre)) && (b1.quantity == b.quantity) && (b1.price == b.price))) {
                    list.set(i, b);
                    ok = true;
                }
                if ((b1.title.equals(b.title)) && (!b1.author.equals(b.author)) && (b1.genre.equals(b.genre)) && (b1.quantity == b.quantity) && (b1.price == b.price)) {
                    list.set(i, b);
                    ok = true;
                }
                if ((b1.title.equals(b.title)) && (b1.author.equals(b.author)) && (!b1.genre.equals(b.genre)) && (b1.quantity == b.quantity) && (b1.price == b.price)) {
                    list.set(i, b);
                    ok = true;
                }
                if ((b1.title.equals(b.title)) && (b1.author.equals(b.author)) && (b1.genre.equals(b.genre)) && (b1.quantity != b.quantity) && (b1.price == b.price)) {
                    list.set(i, b);
                    ok = true;
                }
                if ((b1.title.equals(b.title)) && (b1.author.equals(b.author)) && (b1.genre.equals(b.genre)) && (b1.quantity == b.quantity) && (b1.price != b.price)) {
                    list.set(i, b);
                    ok = true;
                }
                i++;
            }


            if (!ok) {

                JOptionPane.showMessageDialog(lv.frame, "Cartea nu a fost gasita!");
            }

            XMLEncoder cartile = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("books.xml")));
            cartile.writeObject(list);
            cartile.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static void deleteBook() {
        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("books.xml")));
            ArrayList<Book> list = (ArrayList<Book>) a.readObject();
            Book b = new Book(adminView.textFieldTitle.getText(), adminView.textFieldAuthor.getText(), adminView.textFieldGenre.getText(), Integer.parseInt(adminView.textFieldQuantity.getText()), Double.parseDouble(adminView.textFieldPrice.getText()));
            boolean ok = false;

            int i = 0;
            int k = 0;
            for (Book b1 : list) {

                if ((b1.title.equals(b.title)) && (b1.author.equals(b.author)) && (b1.genre.equals(b.genre)) && (b1.quantity == b.quantity) && (b1.price == b.price)) {
                    k = i;

                    ok = true;
                }
                i++;

            }


            if (!ok)
                JOptionPane.showMessageDialog(lv.frame, "Cartea nu a fost gasita");
            else list.remove(k);


            XMLEncoder cartile = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("books.xml")));
            cartile.writeObject(list);
            cartile.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void listBooks() {

        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("books.xml")));
            ArrayList<Book> list = (ArrayList<Book>) a.readObject();
            int i = 0;
            int k = 0;
            Object[][] data;

            data = new Object[list.size()][6];
            for (Book b : list) {
                data[i][0] = b.title;
                data[i][1] = b.author;
                data[i][2] = b.genre;
                data[i][3] = b.quantity;
                data[i][4] = b.price;
                i++;
            }


            adminView.setTabelBooks(data);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void listUsers() {

        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("admins.xml")));
            ArrayList<User> list = (ArrayList<User>) a.readObject();
            int i = 0;
            int k = 0;
            Object[][] data;

            data = new Object[list.size()][3];
            for (User u : list) {
                data[i][0] = u.username;
                data[i][1] = u.password;
                data[i][2] = u.type;

                i++;
            }


            adminView.setTabelUsers(data);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void createUser() {
        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("admins.xml")));
            ArrayList<User> list = (ArrayList<User>) a.readObject();
            User u = new User(adminView.textFieldUserName.getText(), adminView.textFieldPassword.getText(),0);
            boolean ok = false;
            int i = 0;
            int k = 0;
            for (User u1 : list) {
                if ((adminView.textFieldUserName.getText().equals(u1.username)) && (adminView.textFieldPassword.getText().equals(u1.password))) {
                    k = i;
                    ok = true;
                }
                i++;
            }


            if (ok) {
                JOptionPane.showMessageDialog(lv.frame, "Userul exista.");
            } else list.add(u);
            XMLEncoder cartile = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("admins.xml")));
            cartile.writeObject(list);
            cartile.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void updateUser() {
        try
        {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("admins.xml")));
        ArrayList<User> list = (ArrayList<User>) a.readObject();
        User u = new User(adminView.textFieldUserName.getText(), adminView.textFieldPassword.getText(),0);
        boolean ok = false;
        int i = 0;
        int k = 0;
            for (User u1 : list) {
                if ((!u1.username.equals(u.username)) && (u1.password.equals(u.password))&&(u1.type==0)) {
                    list.set(i, u);
                    ok = true;
                }
                if ((u1.username.equals(u.username)) && (!u1.password.equals(u.password))&&(u1.type==0)) {
                    list.set(i, u);
                    ok = true;
                }
                i++;
            }


            if (!ok) {

                JOptionPane.showMessageDialog(lv.frame, "Userul nu a fost gasit sau este alt admin!");
            }

            XMLEncoder cartile = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("admins.xml")));
            cartile.writeObject(list);
            cartile.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void deleteUser() {
        try {
            XMLDecoder a = new XMLDecoder(new BufferedInputStream(new FileInputStream("admins.xml")));
            ArrayList<User> list = (ArrayList<User>) a.readObject();
            User u = new User(adminView.textFieldUserName.getText(), adminView.textFieldPassword.getText(), 0);
            boolean ok = false;
            int i = 0;
            int k = 0;
            for (User u1 : list) {
                if ((u1.username.equals(u.username)) && (u1.password.equals(u.password))&&(u1.type==0)) {
                    k = i;

                    ok = true;
                }
                i++;

            }


            if (!ok)
                JOptionPane.showMessageDialog(lv.frame, "Userul nu a fost gasit");
            else list.remove(k);

            XMLEncoder cartile = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("admins.xml")));
            cartile.writeObject(list);
            cartile.close();
        }
         catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void reportCsv() {
        FactoryClass f=new FactoryClass();
        Report csv=f.generateReport("csv");

        csv.generate("CSVFILE");
    }
    public static void reportPdf()  {
        FactoryClass f=new FactoryClass();
        Report pdf=f.generateReport("pdf");
        pdf.generate("PDFFILE");


    }
}




