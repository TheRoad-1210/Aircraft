package com.example.aircraft.items;

import com.example.aircraft.aircraft.HeroAircraft;
import com.example.aircraft.application.MainActivity;
import com.example.aircraft.basic.AbstractFlyingObject;

/**
 * @author 200111013
 */
public abstract class AbstractProp extends AbstractFlyingObject {




    public AbstractProp(){this.speedY = 2;}

    /**
     * 实现用途
     * @param heroAircraft 英雄机实例
     */
    abstract public void use(HeroAircraft heroAircraft);
    @Override
    public void forward() {
        super.forward();
        if (locationY >= MainActivity.WINDOW_HEIGHT ) {
            vanish();
        }
    }
}
