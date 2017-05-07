package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raul on 5/1/2017.
 */
public class AdminView implements ActionListener {

     JFrame frame;
     JTextField textFieldTitle;
     JTextField textFieldAuthor;
     JTextField textFieldGenre;
     JTextField textFieldQuantity;
     JTextField textFieldPrice;
     JTextField textFieldUserName;
     JTextField textFieldPassword;
    JButton btnListAllBooks;
    JButton btnListAllUsers;
    JButton btnCreateBook;
    JButton btnUpdateBook;
    JButton btnDeleteBook;
    JButton btnCreateUser;
    JButton btnUpdateUser;
    JButton btnDeleteUser;
    JButton btnRpdf;
    JButton btnRcsv;
    JTable table;
    JScrollPane scrollpane;
    JTable table1;
    JScrollPane scrollpane1;
    Object[][] data;
    JButton logout;
    JPanel panel;

    public AdminView() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

         panel = new JPanel();
        panel.setBounds(10, 11, 1000, 550);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textFieldTitle = new JTextField();
        textFieldTitle.setBounds(10, 11, 100, 20);
        panel.add(textFieldTitle);
        textFieldTitle.setColumns(10);

        textFieldAuthor = new JTextField();
        textFieldAuthor.setBounds(10, 42, 100, 20);
        panel.add(textFieldAuthor);
        textFieldAuthor.setColumns(10);

        textFieldGenre = new JTextField();
        textFieldGenre.setBounds(10, 73, 100, 20);
        panel.add(textFieldGenre);
        textFieldGenre.setColumns(10);

        textFieldQuantity = new JTextField();
        textFieldQuantity.setBounds(10, 104, 100, 20);
        panel.add(textFieldQuantity);
        textFieldQuantity.setColumns(10);

        textFieldPrice = new JTextField();
        textFieldPrice.setBounds(10, 135, 100, 20);
        panel.add(textFieldPrice);
        textFieldPrice.setColumns(10);

        textFieldUserName = new JTextField();
        textFieldUserName.setBounds(10, 235, 100, 20);
        panel.add(textFieldUserName);
        textFieldUserName.setColumns(10);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(10, 261, 100, 20);
        panel.add(textFieldPassword);
        textFieldPassword.setColumns(10);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setBounds(162, 14, 73, 14);
        panel.add(lblTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setBounds(162, 45, 73, 14);
        panel.add(lblAuthor);

        JLabel lblGenre = new JLabel("Genre");
        lblGenre.setBounds(162, 76, 73, 14);
        panel.add(lblGenre);

        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(162, 108, 73, 14);
        panel.add(lblQuantity);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(162, 143, 73, 14);
        panel.add(lblPrice);

        JLabel lblUser = new JLabel("UsernameEmployee");
        lblUser.setBounds(162, 235, 73, 14);
        panel.add(lblUser);

        JLabel lblPass = new JLabel("PasswordEmployee");
        lblPass.setBounds(162, 265, 73, 14);
        panel.add(lblPass);

    //    btnSearch = new JButton("Search");
      //  btnSearch.setBounds(10, 107, 89, 23);
       // panel.add(btnSearch);
       // btnSearch.addActionListener(this);
       // btnSearch.setActionCommand("search");

        //btnSell = new JButton("Sell");
        //btnSell.setBounds(142, 107, 89, 23);
        //panel.add(btnSell);


        logout = new JButton("Logout");
        logout.setBounds(60, 320, 89, 23);
        panel.add(logout);
        logout.addActionListener(this);
        logout.setActionCommand("logout");

        btnListAllBooks = new JButton("ListBooks");
        btnListAllBooks.setBounds(240, 10, 100, 23);
        panel.add(btnListAllBooks);
        btnListAllBooks.addActionListener(this);
        btnListAllBooks.setActionCommand("listBooks");

        btnCreateBook = new JButton("CreateBook");
        btnCreateBook.setBounds(240, 40, 100, 23);
        panel.add(btnCreateBook);
        btnCreateBook.addActionListener(this);
        btnCreateBook.setActionCommand("createBook");

        btnUpdateBook = new JButton("UpdateBook");
        btnUpdateBook.setBounds(240, 70, 100, 23);
        panel.add(btnUpdateBook);
        btnUpdateBook.addActionListener(this);
        btnUpdateBook.setActionCommand("updateBook");

        btnDeleteBook = new JButton("DeleteBook");
        btnDeleteBook.setBounds(240, 100, 100, 23);
        panel.add(btnDeleteBook);
        btnDeleteBook.addActionListener(this);
        btnDeleteBook.setActionCommand("deleteBook");

        btnListAllUsers = new JButton("ListUsers");
        btnListAllUsers.setBounds(240, 150, 100, 23);
        panel.add(btnListAllUsers);
        btnListAllUsers.addActionListener(this);
        btnListAllUsers.setActionCommand("listUsers");

        btnCreateUser = new JButton("CreateUser");
        btnCreateUser.setBounds(240, 180, 100, 23);
        panel.add(btnCreateUser);
        btnCreateUser.addActionListener(this);
        btnCreateUser.setActionCommand("createUser");

        btnUpdateUser = new JButton("UpdateUser");
        btnUpdateUser.setBounds(240, 210, 100, 23);
        panel.add(btnUpdateUser);
        btnUpdateUser.addActionListener(this);
        btnUpdateUser.setActionCommand("updateUser");

        btnDeleteUser = new JButton("DeleteUser");
        btnDeleteUser.setBounds(240, 240, 100, 23);
        panel.add(btnDeleteUser);
        btnDeleteUser.addActionListener(this);
        btnDeleteUser.setActionCommand("deleteUser");

        btnRpdf = new JButton("RePdf");
        btnRpdf.setBounds(180, 300, 100, 23);
        panel.add(btnRpdf);
        btnRpdf.addActionListener(this);
        btnRpdf.setActionCommand("reportPdf");

        btnRcsv = new JButton("ReCsv");
        btnRcsv.setBounds(300, 300, 100, 23);
        panel.add(btnRcsv);
        btnRcsv.addActionListener(this);
        btnRcsv.setActionCommand("reportCsv");






        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        switch (cmd) {
            case "login":
                Controller.login(cmd, 1);
                break;
            case "logout":Controller.login(cmd,1);
                break;
            case "createBook":
                Controller.createBook();
                break;
            case "listBooks": Controller.listBooks();
                break;
            case "updateBook":
                Controller.updateBook();
                break;
            case "deleteBook":
                Controller.deleteBook();
                break;
            case "listUsers": Controller.listUsers();
                break;
             case "createUser":
                Controller.createUser();
                break;
            case "updateUser":
                Controller.updateUser();
                break;
            case "deleteUser":
                Controller.deleteUser();
                break;
            case "reportCsv":
                Controller.reportCsv();
            case "reportPdf":
                Controller.reportPdf();
            default:
                break;
        }

    }
    public void setTabelBooks(Object [][] data) {
        String[] columnNames = {"Title",
                "Author",
                "Genre",
                "Quantity",
                "Price"};


        table = new JTable(data, columnNames);


        scrollpane = new JScrollPane();


        scrollpane.setViewportView(table);
        scrollpane.setBounds(350, 10, 600, 100);
        scrollpane.setVisible(true);
        table.isEditing();
        panel.add(scrollpane);
    }

    public void setTabelUsers(Object [][] data) {
        String[] columnNames = {"Username",
                "Password",
                "Type"};


        table1 = new JTable(data, columnNames);


        scrollpane1 = new JScrollPane();


        scrollpane1.setViewportView(table1);
        scrollpane1.setBounds(350, 130, 600, 100);
        scrollpane1.setVisible(true);
        table1.isEditing();
        panel.add(scrollpane1);
    }


}
