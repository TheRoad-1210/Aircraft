package edu.hitsz.application;

import static edu.hitsz.application.MainActivity.WINDOW_HEIGHT;
import static edu.hitsz.application.MainActivity.WINDOW_WIDTH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import edu.hitsz.application.game.AbstractGame;
import edu.hitsz.player.Player;
import edu.hitsz.player.PlayerDaoImpl;


/**
 * @author deequoique
 */
public class RankList {
    public final static Object DELETE = new Object();

    private JTable score;
    private JPanel root;
    private JPanel top;
    private JScrollPane scoreroot;
    private JPanel under;
    private JButton delete;
    private JLabel gamemode;
    private JPanel rank;
    private JLabel ranklist;
    Object LOCK;


    public RankList(AbstractGame game) throws IOException, ClassNotFoundException {
        PlayerDaoImpl playerDao = new PlayerDaoImpl();
        playerDao.read();
        playerDao.scoreArray();
        ArrayList<Player> players = playerDao.getPlayers();
        ArrayList<Player> appointedPlayer = new ArrayList<>();
        switch (game.gameMode){
            case 0:
                gamemode.setText("EASY");
                for (Player player : players){
                    if(player.getGameMode() == 0){
                        appointedPlayer.add(player);
                    }
                }
                break;
            case 1:
                gamemode.setText("NORMAL");
                for (Player player : players){
                    if(player.getGameMode() == 1){
                        appointedPlayer.add(player);
                    }
                }
                break;
            case 2:
                gamemode.setText("DIFFICULT");
                for (Player player : players){
                    if(player.getGameMode() == 2){
                        appointedPlayer.add(player);
                    }
                }
                break;
            default:break;
        }
        String[][] tableData = new String[appointedPlayer.size()][4];
        String[] columnName = {"排名","id","得分","时间"};
        int i;
        for(i = 0;i < appointedPlayer.size();i++) {
            int j = i+1;
            tableData[i][0] = String.valueOf(j);
            tableData[i][1] = appointedPlayer.get(i).getName();
            tableData[i][2] = String.valueOf(appointedPlayer.get(i).getScore());
            tableData[i][3] = appointedPlayer.get(i).getTime();
        }
        //表格模型
        DefaultTableModel model = new DefaultTableModel(tableData, columnName){
            @Override public boolean isCellEditable(int row, int col){
                return false; }
        };
        //从表格模型那里获取数据
        score.setModel(model);
        scoreroot.setViewportView(score);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // 获得屏幕的分辨率，初始化 Frame
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                JFrame frame = new JFrame("delete");
                frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT/2);
                frame.setResizable(false);
                //设置窗口的大小和位置,居中放置
                frame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, ((int) screenSize.getHeight())/2,
                        WINDOW_WIDTH, WINDOW_HEIGHT/2);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Delete delete = new Delete(model,score.getSelectedRow(),frame);
                frame.add(delete.getMainPanel());
                frame.setVisible(true);
        }

    });

}
    public JPanel getMainPanel() {return root;}

}
