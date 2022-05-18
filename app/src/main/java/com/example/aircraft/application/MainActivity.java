package com.example.aircraft.application;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aircraft.R;

import com.example.aircraft.application.game.AbstractGame;
import com.example.aircraft.application.game.Easy;
import com.example.aircraft.application.game.Normal;

/**
 * 程序入口
 * @author hitsz
 */
public class MainActivity extends AppCompatActivity {
    public static final Object LOCK = new Object();
    private static  String TAG ;
    private static final boolean music = false;
    public static AbstractGame game = Normal.getNormalGame();
    public static  int screenWidth ;
    public static  int screenHeight ;

    public void getScreenHW(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

         screenWidth = dm.widthPixels;
        Log.i(TAG,"screenWidth:"+screenWidth);

         screenHeight = dm.heightPixels;
        Log.i(TAG,"screenWidth:"+screenHeight);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hello Aircraft War");

        // 获得屏幕的分辨率，初始化 Frame
        DisplayMetrics dm = new DisplayMetrics();
    }

    public void StartEasy(View view) {
        startActivity(new Intent(this,Easy.class));
    }
}
