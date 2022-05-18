package com.example.aircraft.factory;

import com.example.aircraft.items.AbstractProp;
import com.example.aircraft.items.FireSupply;

/**
 * @author 200111013
 */
public class FireFactory extends PropFactory{
    @Override
    public AbstractProp create() {
        return new FireSupply();
    }
}
