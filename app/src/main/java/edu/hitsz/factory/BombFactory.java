package edu.hitsz.factory;

import edu.hitsz.items.AbstractProp;
import edu.hitsz.items.BombSupply;

/**
 * @author 200111013
 */
public class BombFactory extends PropFactory{
    @Override
    public AbstractProp create() {
        return new BombSupply();
    }
}
