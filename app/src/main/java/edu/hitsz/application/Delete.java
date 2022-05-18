package edu.hitsz.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.table.DefaultTableModel;

import edu.hitsz.player.Player;
import edu.hitsz.player.PlayerDaoImpl;

/**
 * @author deequoique
 */
public class Delete {
    private JFormattedTextField text;
    private JButton yes;
    private JButton no;
    private JPanel top;
    private JPanel under;
    private JPanel root;

    public Delete(DefaultTableModel model,int row,JFrame frame) {
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerDaoImpl playerDao = new PlayerDaoImpl();
                try {
                    playerDao.read();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                ArrayList<Player> players = playerDao.getPlayers();
                if(row != -1){

                    String time = (String) model.getValueAt(row,3);
                    model.removeRow(row);
                    players.removeIf(player -> Objects.equals(player.getTime(), time));
                    try {
                        playerDao.storage();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                frame.dispose();
            }

        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }
    public JPanel getMainPanel() {return root;}
}
