package edu.hitsz.items;

import java.util.List;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.MainActivity;
import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.bullet.AbstractBullet;
import edu.hitsz.publisher.BombPublish;

/**
 * @author 200111013
 */
public class BombSupply extends AbstractProp{
    public int score = 0;


    public BombSupply() {
    }

    @Override
    public void use(HeroAircraft heroAircraft) {
        BombPublish bombPublish = new BombPublish();
        List<AbstractAircraft> enemyAircrafts=  MainActivity.game.getEnemyAircrafts();
        List<AbstractBullet> enemyBullet = MainActivity.game.getEnemyBullets();
        for (AbstractFlyingObject fobj : enemyAircrafts){
            bombPublish.addList(fobj);
        }
        for (AbstractFlyingObject fobj : enemyBullet){
            bombPublish.addList(fobj);
        }
        bombPublish.notifySubscribers();
        score = bombPublish.score;
    }
}
