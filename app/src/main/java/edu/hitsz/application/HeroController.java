package edu.hitsz.application;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.game.AbstractGame;

/**
 * 英雄机控制类
 * 监听鼠标，控制英雄机的移动
 *
 * @author hitsz
 */
public class HeroController {
    private AbstractGame game;
    private HeroAircraft heroAircraft;
    private MouseAdapter mouseAdapter;

    public HeroController(AbstractGame game, HeroAircraft heroAircraft){
        this.game = game;
        this.heroAircraft = heroAircraft;

        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                int x = e.getX();
                int y = e.getY();
                if ( x<0 || x> MainActivity.WINDOW_WIDTH || y<0 || y> MainActivity.WINDOW_HEIGHT){
                    // 防止超出边界
                    return;
                }
                heroAircraft.setLocation(x, y);
            }
        };

        game.addMouseListener(mouseAdapter);
        game.addMouseMotionListener(mouseAdapter);
    }


}