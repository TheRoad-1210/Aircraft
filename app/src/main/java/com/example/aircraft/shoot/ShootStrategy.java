package com.example.aircraft.shoot;

import java.util.List;

import com.example.aircraft.aircraft.AbstractAircraft;
import com.example.aircraft.bullet.AbstractBullet;

public interface ShootStrategy {

    List<AbstractBullet> way(AbstractAircraft aircraft);
}
