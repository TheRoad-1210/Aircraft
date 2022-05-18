package edu.hitsz.application;

import static edu.hitsz.application.MainActivity.LOCK;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.hitsz.application.game.AbstractGame;

/**
 * @author deequoique
 */
public class Start {
    private JPanel root;
    private JButton easy;
    private JButton normal;
    private JButton hard;
    private JPanel top;
    private JPanel middle;
    private JPanel bottom;
    private JCheckBox voice;

    public Start(AbstractGame game) {
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg2.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                game.gameMode = 0;
                synchronized (MainActivity.LOCK){
                    LOCK.notify();
                }
            }

        });
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg4.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                game.gameMode = 1;
                synchronized (LOCK){
                    LOCK.notify();
                }
            }

        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg5.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                game.gameMode = 2;
                synchronized (LOCK){
                    LOCK.notify();
                }
            }

        });
        voice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setNeedMusic(true);
            }
        });
    }
    public JPanel getMainPanel() {return root;}

}
