package edu.hitsz.factory;

import edu.hitsz.items.AbstractProp;
import edu.hitsz.items.HpSupply;

/**
 * @author 200111013
 */
public class HpFactory extends PropFactory{
    @Override
    public AbstractProp create() {
        return new HpSupply();
    }
}
