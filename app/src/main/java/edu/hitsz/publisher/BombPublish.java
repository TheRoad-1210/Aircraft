package edu.hitsz.publisher;

import java.util.ArrayList;

import edu.hitsz.basic.AbstractFlyingObject;

/**
 * @author deequoique
 */
public class BombPublish {
    private ArrayList<AbstractFlyingObject> subscribers = new ArrayList<AbstractFlyingObject>();
    public int score = 0;
    public void addList(ArrayList<AbstractFlyingObject> list){
        subscribers.addAll(list);
    }
    public void addList(AbstractFlyingObject obj){
        subscribers.add(obj);
    }
    public void delete(ArrayList<AbstractFlyingObject> list){
        subscribers.removeAll(list);
    }
    public void delete(AbstractFlyingObject obj){
        subscribers.remove(obj);
    }
    public void notifySubscribers(){
        for (AbstractFlyingObject fobj:subscribers){
            score += fobj.bomb();
        }
        delete(subscribers);
    }
}
