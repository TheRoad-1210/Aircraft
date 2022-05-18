package com.example.aircraft.factory;

import com.example.aircraft.items.AbstractProp;
import com.example.aircraft.items.BombSupply;

/**
 * @author 200111013
 */
public class BombFactory extends PropFactory{
    @Override
    public AbstractProp create() {
        return new BombSupply();
    }
}
