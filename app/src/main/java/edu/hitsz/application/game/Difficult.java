package edu.hitsz.application.game;

import android.os.Bundle;

import androidx.annotation.Nullable;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.BossEnemy;
import edu.hitsz.bullet.AbstractBullet;

/**
 * @author deequoique
 */
public class Difficult extends AbstractGame{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private int boss = 0;
    private static AbstractGame instance = new Difficult();

    public static AbstractGame getDifficultGame(){return instance;}

    private int i = 0;
    private int growNumber = 0;
    @Override
    protected void grow() {

        i++;

        if (i % 80 == 0) {
            growNumber++;
            enemyMaxNumber += 1;
            for (AbstractBullet enemyBullet : enemyBullets) {
                enemyBullet.setPower((enemyBullet.getPower() + 2));
            }
            for (AbstractAircraft enemy : enemyAircrafts) {
                if (!(enemy instanceof BossEnemy)) {
                    enemy.setHp(enemy.getHp() + 3);
                }
            }
            enemyFactory.prob -= 0.03;
            bossScoreThreshold -= 1;
            System.out.println("难度增加，敌机数量最大值为"+enemyMaxNumber+"，精英敌机产生概率为"+(1-enemyFactory.prob)+"，敌机血量增加了"+growNumber*3+"，敌机子弹伤害增加了"+growNumber*2+"，boss出现阙值为"+bossScoreThreshold);
        }
    }
    @Override
    protected void bossTime(){
        bossExist = false;

        boolean flag = false;
        if(this.scorer >= bossScoreThreshold){
            flag = true;
            this.scorer = this.scorer-bossScoreThreshold;
        }

        for (AbstractAircraft enemy:enemyAircrafts){
            if (enemy instanceof BossEnemy) {
                bossExist = true;
                break;
            }
        }
        if( !bossExist && flag){

            enemyFactory.boss = true;
            AbstractAircraft bossEnemy= enemyFactory.create();
            bossEnemy.setHp(bossEnemy.getHp() + boss * 100);
            boss++;
            enemyAircrafts.add(bossEnemy);
            System.out.println("boss hp is "+bossEnemy.getHp());
            bossExist = true;
        }
    }
}
