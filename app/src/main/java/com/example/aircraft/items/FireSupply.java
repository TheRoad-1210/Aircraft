package com.example.aircraft.items;

import com.example.aircraft.aircraft.HeroAircraft;
import com.example.aircraft.shoot.DoubleShoot;
import com.example.aircraft.shoot.MobShoot;
import com.example.aircraft.shoot.SeperateShoot;

/**
 * @author 200111013
 */
public class FireSupply extends AbstractProp{

    public FireSupply() {
    }

    @Override
    public void use(HeroAircraft heroAircraft) {
            Runnable fireThread = ()->{
                if  (heroAircraft.getStrategy() instanceof  MobShoot) {
                    heroAircraft.setStrategy(new DoubleShoot());
                }
                else if(heroAircraft.getStrategy() instanceof DoubleShoot){
                    heroAircraft.setStrategy(new SeperateShoot());
                }
                else {
                    heroAircraft.setStrategy(new SeperateShoot());
                }
                try {
                    Thread.sleep(1000*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                heroAircraft.setStrategy(new MobShoot());
            };
            new Thread(fireThread).start();
        }


}
