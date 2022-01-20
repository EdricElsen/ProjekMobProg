package com.example.tri_games;

import java.util.Vector;

public class Cart {

    public static Vector<CartModel> vector = new Vector<CartModel>();


    public static void additem(String user, String game, String score){
        vector.add(new CartModel(user,game,score));

    }
}
