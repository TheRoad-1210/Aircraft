package edu.hitsz.application;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.DisplayContext;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aircraft.R;

import java.io.IOException;

import edu.hitsz.application.game.AbstractGame;
import edu.hitsz.application.game.Difficult;
import edu.hitsz.application.game.Easy;
import edu.hitsz.application.game.Normal;

/**
 * 程序入口
 * @author hitsz
 */
public class MainActivity extends AppCompatActivity {
    public static final Object LOCK = new Object();
    private static  String TAG ;
    private static boolean music = false;
    public static AbstractGame game = Normal.getNormalGame();
    public static  double screenWidth ;
    public static  double screenHeight ;

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
