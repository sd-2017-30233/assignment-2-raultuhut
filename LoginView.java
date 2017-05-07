package app;

/**
 * Created by Raul on 4/24/2017.
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginView implements ActionListener{

    JFrame frame;
    JTextField textFieldUser;
     JTextField textFieldPass;
    JButton btnLogin;


    public LoginView () {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 236, 239);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textFieldUser = new JTextField();
        textFieldUser.setBounds(10, 11, 100, 20);
        panel.add(textFieldUser);
        textFieldUser.setColumns(10);

        textFieldPass = new JTextField();
        textFieldPass.setBounds(10, 42, 100, 20);
        panel.add(textFieldPass);
        textFieldPass.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(162, 14, 73, 14);
        panel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(162, 45, 73, 14);
        panel.add(lblPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(10, 90, 89, 23);
        panel.add(btnLogin);

        btnLogin.addActionListener(this);
        btnLogin.setActionCommand("login");





        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd=actionEvent.getActionCommand();
        Controller.login(cmd,-1);

    }
}
