package edu.hitsz.aircraft;

import java.util.List;

import edu.hitsz.application.MainActivity;
import edu.hitsz.bullet.AbstractBullet;
import edu.hitsz.shoot.SeperateShoot;
import edu.hitsz.shoot.ShootContext;

/**
 * boss敌机，在关卡末尾出现
 * @author 200111013
 */

public class BossEnemy extends AbstractAircraft{


    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    private int shootNum = 1;

    private int power = 20;

    private int direction = -1;


    @Override
    public List<AbstractBullet> shoot() {
        ShootContext context = new ShootContext(new SeperateShoot());
        return context.executrStrategy(this);
    }



    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= MainActivity.WINDOW_HEIGHT ) {
            vanish();
        }
    }

}
