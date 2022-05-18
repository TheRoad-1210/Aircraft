package com.example.aircraft.aircraft;

import java.util.List;

import com.example.aircraft.application.MainActivity;
import com.example.aircraft.bullet.AbstractBullet;
import com.example.aircraft.shoot.MobShoot;
import com.example.aircraft.shoot.ShootContext;

/**
 * 精英敌机，可发射子弹
 * @author 200111013
 */

public class EliteEnemy extends AbstractAircraft {

    private final int shootNum = 1;

    private final int power = 20;

    private final int direction = -1;

    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    @Override
    public List<AbstractBullet> shoot() {
        ShootContext context = new ShootContext(new MobShoot());
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

    @Override
    public int bomb() {
        vanish();
        return 20;
    }

}
