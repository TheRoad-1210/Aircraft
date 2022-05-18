package edu.hitsz.application.game;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.BossEnemy;
import edu.hitsz.bullet.AbstractBullet;

/**
 * @author deequoique
 *
 * 普通难度，敌机数量随时间增加，精英敌机概率增加，敌机血量增加，敌机子弹伤害增加，boss出现频率增加
 */
public class Normal extends AbstractGame{
    private static AbstractGame instance = new Normal();

    public static AbstractGame getNormalGame(){return instance;}
    private int i = 0;
    private int growNumber = 0;
    @Override
    protected void grow(){

        i++;
        if (i % 100 == 0){
            growNumber++;
            enemyMaxNumber += 1;
            for (AbstractBullet enemyBullet:enemyBullets){
                enemyBullet.setPower((enemyBullet.getPower() + 1));
            }
            for (AbstractAircraft enemy: enemyAircrafts){
                if(!(enemy instanceof BossEnemy)){
                    enemy.setHp(enemy.getHp() + 1);
                }
            }
            enemyFactory.prob -= 0.01;
            bossScoreThreshold -= 1;
            System.out.println("难度增加，敌机数量最大值为"+enemyMaxNumber+"，精英敌机产生概率为"+(1-enemyFactory.prob)+"，敌机血量增加了"+growNumber+"，敌机子弹伤害增加了"+growNumber+"，boss出现阙值为"+bossScoreThreshold);
        }

    }
}
