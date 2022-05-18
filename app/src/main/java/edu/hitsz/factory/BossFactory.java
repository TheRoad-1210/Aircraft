package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.BossEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.MainActivity;

/**
 * @author 200111013
 */
public class BossFactory extends EnemyFactory{
    @Override
    public AbstractAircraft create() {
        return new BossEnemy(
                (int)(Math.random()*(MainActivity.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth()))*1,
                (int) (Math.random() * MainActivity.WINDOW_HEIGHT * 0.2)*1,
                2, 0, 100);
    }
}
