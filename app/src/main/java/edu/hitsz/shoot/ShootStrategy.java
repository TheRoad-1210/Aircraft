package edu.hitsz.shoot;

import java.util.List;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.bullet.AbstractBullet;

public interface ShootStrategy {

    abstract public List<AbstractBullet> way (AbstractAircraft aircraft);
}
