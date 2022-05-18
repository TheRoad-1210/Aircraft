package com.example.aircraft.factory;

import com.example.aircraft.items.AbstractProp;
import com.example.aircraft.items.HpSupply;

/**
 * @author 200111013
 */
public class HpFactory extends PropFactory{
    @Override
    public AbstractProp create() {
        return new HpSupply();
    }
}
