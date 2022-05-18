package com.example.aircraft.items;

import java.util.List;

import com.example.aircraft.aircraft.AbstractAircraft;
import com.example.aircraft.aircraft.HeroAircraft;
import com.example.aircraft.application.MainActivity;
import com.example.aircraft.basic.AbstractFlyingObject;
import com.example.aircraft.bullet.AbstractBullet;
import com.example.aircraft.publisher.BombPublish;

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
