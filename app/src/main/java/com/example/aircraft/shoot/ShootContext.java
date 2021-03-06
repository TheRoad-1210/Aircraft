package com.example.aircraft.shoot;

import java.util.List;

import com.example.aircraft.aircraft.AbstractAircraft;
import com.example.aircraft.bullet.AbstractBullet;

/**
 * @author 200111013
 * 射击策略context
 */
public class ShootContext {

    private ShootStrategy strategy;

    public ShootContext(ShootStrategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(ShootStrategy strategy){
        this.strategy = strategy;
    }

    public List<AbstractBullet> executrStrategy(AbstractAircraft aircraft){
        return strategy.way(aircraft);
    }

}
