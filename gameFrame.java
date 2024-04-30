import javax.swing.*;

 class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame() {
        setTitle("Splendor Game");
        setSize(1600, 825);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        gamePanel = new GamePanel();
        add(gamePanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }


}

