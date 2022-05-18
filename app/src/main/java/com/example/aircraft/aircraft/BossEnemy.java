package com.example.aircraft.aircraft;

import java.util.List;

import com.example.aircraft.application.MainActivity;
import com.example.aircraft.bullet.AbstractBullet;
import com.example.aircraft.shoot.SeperateShoot;
import com.example.aircraft.shoot.ShootContext;

/**
 * boss敌机，在关卡末尾出现
 * @author 200111013
 */

public class BossEnemy extends AbstractAircraft{


    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    private final int shootNum = 1;

    private final int power = 20;

    private final int direction = -1;


    @Override
    public List<AbstractBullet> shoot() {
        ShootContext context = new ShootContext(new SeperateShoot());
        return context.executrStrategy(this);
    }



    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= MainActivity.screenHeight ) {
            vanish();
        }
    }

}
