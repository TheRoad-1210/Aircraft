package com.example.aircraft.factory;

import com.example.aircraft.aircraft.AbstractAircraft;
import com.example.aircraft.aircraft.MobEnemy;
import com.example.aircraft.application.ImageManager;
import com.example.aircraft.application.MainActivity;

/**
 * @author 200111013
 */
public class MobFactory extends EnemyFactory{
    @Override
    public AbstractAircraft create() {
        return new MobEnemy(
                (int) ( Math.random() * (MainActivity.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth()))*1,
                (int) (Math.random() * MainActivity.WINDOW_HEIGHT * 0.2)*1,
                0,
                10,
                30);
    }
}
