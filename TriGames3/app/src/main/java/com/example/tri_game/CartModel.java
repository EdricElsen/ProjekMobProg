package com.example.tri_game;

public class CartModel {
    public String user;
    public String game;
    public String score;


    public CartModel(String user, String game, String score) {
        this.user = user;
        this.game = game;
        this.score = score;

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
