package com.example.aircraft.factory;

import java.util.Random;

import com.example.aircraft.aircraft.AbstractAircraft;
import com.example.aircraft.aircraft.EliteEnemy;
import com.example.aircraft.application.ImageManager;
import com.example.aircraft.application.MainActivity;

/**
 * @author 200111013
 */
public class EliteFactory extends EnemyFactory{
    @Override
    public AbstractAircraft create() {
        Random ran = new Random();
        return new EliteEnemy(
                (int)(Math.random()*(MainActivity.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth()))*1,
                (int) (Math.random() * MainActivity.WINDOW_HEIGHT * 0.2)*1,
                ran.nextInt(10),
                8,
                50);
    }
}
