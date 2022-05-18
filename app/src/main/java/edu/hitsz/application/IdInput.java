package edu.hitsz.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import edu.hitsz.player.Player;
import edu.hitsz.player.PlayerDaoImpl;

/**
 * @author deequoique
 */
public class IdInput {
    private JTextArea id;
    private JTextField input;
    private JPanel under;
    private JPanel top;
    private JPanel root;
    private JButton confirm;
    private JButton cancel;

    public IdInput(Player player) {
        id.setText("游戏已结束\n您的得分为"+player.getScore()+"\n请输入您的id");
        confirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.setName(input.getText());
                System.out.println(input.getText());
                PlayerDaoImpl playerDao = new PlayerDaoImpl();
                try {
                    playerDao.read();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                playerDao.doAdd(player);
                try {
                    playerDao.storage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                playerDao.scoreArray();
                synchronized (MainActivity.LOCK){
                    MainActivity.LOCK.notify();
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (MainActivity.LOCK){
                    MainActivity.LOCK.notify();
                }
            }
        });
    }
    public JPanel getMainPanel() {return root;}
}
