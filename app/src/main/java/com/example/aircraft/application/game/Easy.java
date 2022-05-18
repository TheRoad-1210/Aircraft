package com.example.aircraft.application.game;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.aircraft.R;

/**
 * @author deequoique
 */
public class Easy extends AbstractGame{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_game);
    }
    private static final AbstractGame instance = new Easy();

    public static AbstractGame getEasyGame(){return instance;}

    @Override
    protected void bossTime(){
        System.out.println("easy!!!!!!!!!");
    }
}
