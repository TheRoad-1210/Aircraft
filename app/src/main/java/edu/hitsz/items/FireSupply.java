package edu.hitsz.items;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.shoot.DoubleShoot;
import edu.hitsz.shoot.MobShoot;
import edu.hitsz.shoot.SeperateShoot;

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
