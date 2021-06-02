/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author dubavenxp
 */
public class Main {

    public static ArrayList<User> users;
    public static ArrayList<Product> products;
    public static int width = 1080;
    public static int height = 720;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Login l = new Login();
        l.setVisible(true);
        l.setBounds(0, 0, Main.width, Main.height);
        l.setLocationRelativeTo(null);
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
    }
    
}
