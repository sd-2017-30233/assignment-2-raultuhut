package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raul on 4/24/2017.
 */
public class UserView implements ActionListener {

    JFrame frame;
    JTextField textFieldTitle;
    JTextField textFieldAuthor;
    JTextField textFieldGenre;
    JTextField searchBy;
    JButton btnSearch;
    JButton btnSell;
    JButton logout;
    JTable table;
    JScrollPane scrollpane;
    Object[][] data;
    JPanel panel;

    public UserView() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBounds(10, 11, 1000, 350);
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
        textFieldAuthor.setColumns(10);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setBounds(162, 14, 73, 14);
        panel.add(lblTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setBounds(162, 45, 73, 14);
        panel.add(lblAuthor);

        JLabel lblGenre = new JLabel("Genre");
        lblGenre.setBounds(162, 76, 73, 14);
        panel.add(lblGenre);


        btnSearch = new JButton("Search");
        btnSearch.setBounds(10, 107, 89, 23);
        panel.add(btnSearch);
        btnSearch.addActionListener(this);
        btnSearch.setActionCommand("search");

        btnSell = new JButton("Sell");
        btnSell.setBounds(142, 107, 89, 23);
        panel.add(btnSell);
        btnSell.addActionListener(this);
        btnSell.setActionCommand("sell");


        logout = new JButton("Logout");
        logout.setBounds(60, 135, 89, 23);
        panel.add(logout);
        logout.addActionListener(this);
        logout.setActionCommand("logout");

        searchBy = new JTextField();
        searchBy.setBounds(160, 135, 20, 20);
        panel.add(searchBy);
        searchBy.setColumns(10);
/*

       String[] columnNames = {"Title",
                "Author",
                "Genre",
                "Quantity",
                "Price"};

Object [][] data=new Object[100][100];
        table = new JTable(data, columnNames);

        scrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBounds(250, 10, 400, 100);
        panel.add(scrollpane);*/

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        switch (cmd) {
            case "login":
                Controller.login(cmd, 0);
                break;
            case "logout":
                Controller.login(cmd, 0);
                break;
            case "search":
                Controller.searchBook();
                break;
            case "sell" :
                Controller.sellBook();
            default:
                break;
        }
    }

    public void setTabel(Object [][] data) {
        String[] columnNames = {"Title",
                "Author",
                "Genre",
                "Quantity",
                "Price"};


        table = new JTable(data, columnNames);


        scrollpane = new JScrollPane();


        scrollpane.setViewportView(table);
        scrollpane.setBounds(250, 10, 600, 100);
        scrollpane.setVisible(true);
        table.isEditing();
        panel.add(scrollpane);
    }


}