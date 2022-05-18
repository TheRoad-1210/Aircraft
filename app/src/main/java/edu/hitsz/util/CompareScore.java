package edu.hitsz.util;

import java.util.Comparator;

import edu.hitsz.player.Player;

/**
 * @author 2001113
 * 按照分数排序
 */
public class CompareScore implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if(o1.getScore() > o2.getScore()){
            return -1;
        }
        else {
            return 1;
        }
    }
}
