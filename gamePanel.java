import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class GamePanel extends JPanel {

    private final JLabel[] playerScoreLabel;
    private final JLabel[] playerCoinLabel;
    private final JLabel[] purchasedCardsLabel;
    private JButton slotMachineButtonsRed;
    private JButton slotMachineButtonsBlue;
    private JButton slotMachineButtonsGreen;
     private JButton slotMachineButtonsBlack;
     private JButton slotMachineButtonsWhite;
     private int[] redCoins ;
     private int[] blueCoins ;
     private int[] whiteCoins ;
     private int[] greenCoins;
     private int[] blackCoins ;
     private  int[] goldCoins;
    private  int[] playerScore ;
    private JButton card1;
     private JButton card2;
     private JButton card3;
     private JButton card4;
     private JButton card5;
     private JButton card6;
     private JButton card7;
     private JButton card8;
     private JButton card9;
     private JButton card10;
     private JButton card11;
     private JButton card12;
     private JButton prizeClawCard1;
     private JButton prizeClawCard2;
     private JButton prizeClawCard3;
    private JButton reserveButton;
    private JButton buyButton;
     private JButton slotMachine;
     private  JButton slotMachineButtonDifferent;
    private JTextArea messageArea;
     private String[] purchasedCards ;
     private boolean[] isBuyingCoins;
     private boolean[] isBuyingCard;
     private  boolean[][] isCardReserved;
     private int[] countCardReserved;
     private int turn =0;
     private  boolean prizeCard1 = true;
     private boolean prizeCard2=true;
     private boolean prizeCard3=true;
     private boolean[] isBuyDifferentCoins;
     private int[] buyDifferentCoins;
     private  int[] countPurchasedCards;
     private int[] countPurchased;
     private  int[]countCoinsInSlotMachines;
     private boolean swRed;
     private boolean swWhite;
     private boolean swBlue;
     private boolean swGreen;
     private boolean swBlack;

     public GamePanel() {
        setLayout(new BorderLayout());
         playerScoreLabel = new JLabel[2];
         playerCoinLabel = new JLabel[2];
         purchasedCardsLabel=new JLabel[2];
         buyButton = new JButton("Buy Card");
         reserveButton = new JButton("Reserve Card");
         slotMachine = new JButton("Buy 2 Coins");
         slotMachineButtonDifferent = new JButton("Buy 3 Different Coins");

         messageArea = new JTextArea();
         blackCoins = new int[2];
         greenCoins = new int[2];
         whiteCoins = new int[2];
         redCoins = new int[2];
         blueCoins = new int[2];
         goldCoins = new int[2];
         playerScore = new int[2];
         purchasedCards = new String[]{"",""};
         isBuyingCoins = new boolean[2];
         isBuyingCard = new boolean[2];
         isCardReserved = new boolean[2][12];
         countCardReserved = new int[2];
         countPurchased = new int[12];
         countCoinsInSlotMachines = new int[]{4,4,4,4,4};
         isBuyDifferentCoins = new boolean[2];
         buyDifferentCoins = new int[2];
         countPurchasedCards = new int[2];

         for (int i = 0; i < 2; i++) {
             playerScoreLabel[i] = new JLabel("Player " + (i + 1) + " Score: " + playerScore[i]);
             playerCoinLabel[i] = new JLabel("Red : " + redCoins[i] +
                     ", Blue : " + blueCoins[i] +", Black : "+blackCoins[i]+
                     ", Green : "+greenCoins[i]+", White : "+whiteCoins[i]+", Gold : "+goldCoins[i]);
             purchasedCardsLabel[i] = new JLabel("Purchased Cards:" + purchasedCards[i]);
         }
         messageArea = new JTextArea();
         JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel = new JPanel(new GridLayout(4, 4, 20, 5));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         for (int i = 0; i < 2; i++) {
             topPanel.add(playerScoreLabel[i]);
             topPanel.add(playerCoinLabel[i]);
             topPanel.add(purchasedCardsLabel[i]);
         }
         ImageIcon SlotMachineRed = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Picsart_24-04-15_05-35-45-983.jpg");
         Image slotMachineRedImage = SlotMachineRed.getImage();
         Image scaledSlotMachineRedImage = slotMachineRedImage.getScaledInstance(290, 250, Image.SCALE_SMOOTH);
         SlotMachineRed = new ImageIcon(scaledSlotMachineRedImage);
         slotMachineButtonsRed = new JButton(SlotMachineRed);
         centerPanel.add(slotMachineButtonsRed);

         ImageIcon SlotMachine = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\۲۰۲۴۰۴۱۵_۰۵۰۶۲۰.jpg");
         Image slotMachineImage = SlotMachine.getImage();
         Image scaledSlotMachineImage = slotMachineImage.getScaledInstance(290, 180, Image.SCALE_SMOOTH);
         SlotMachine = new ImageIcon(scaledSlotMachineImage);
         slotMachineButtonsBlue = new JButton(SlotMachine);
         centerPanel.add(slotMachineButtonsBlue);

         ImageIcon SlotMachineBlack = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Picsart_24-04-15_05-31-19-361.jpg");
         Image slotMachineBlackImage = SlotMachineBlack.getImage();
         Image scaledSlotMachineBlackImage = slotMachineBlackImage.getScaledInstance(300, 180, Image.SCALE_SMOOTH);
         SlotMachineBlack = new ImageIcon(scaledSlotMachineBlackImage);
         slotMachineButtonsBlack = new JButton(SlotMachineBlack);
         centerPanel.add(slotMachineButtonsBlack);

         ImageIcon SlotMachineGreen = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Picsart_24-04-15_05-33-23-394.jpg");
         Image slotMachineGreenImage = SlotMachineGreen.getImage();
         Image scaledSlotMachineGreenImage = slotMachineGreenImage.getScaledInstance(290, 220, Image.SCALE_SMOOTH);
         SlotMachineGreen = new ImageIcon(scaledSlotMachineGreenImage);
         slotMachineButtonsGreen = new JButton(SlotMachineGreen);
         centerPanel.add(slotMachineButtonsGreen);

         ImageIcon SlotMachineWhite = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Picsart_24-04-15_05-34-24-515.jpg");
         Image slotMachineWhiteImage = SlotMachineWhite.getImage();
         Image scaledSlotMachineWhiteImage = slotMachineWhiteImage.getScaledInstance(290, 270, Image.SCALE_SMOOTH);
         SlotMachineWhite = new ImageIcon(scaledSlotMachineWhiteImage);
         slotMachineButtonsWhite = new JButton(SlotMachineWhite);
         centerPanel.add(slotMachineButtonsWhite);

         ImageIcon Card1 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card1.jpg");
         Image card1Image = Card1.getImage();
         Image scaledCard1Image = card1Image.getScaledInstance(300, 180, Image.SCALE_SMOOTH);
         Card1 = new ImageIcon(scaledCard1Image);
         card1 = new JButton(Card1);

         ImageIcon Card2 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card2.png");
         Image card2Image = Card2.getImage();
         Image scaledCard2Image = card2Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card2 = new ImageIcon(scaledCard2Image);
         card2 = new JButton(Card2);

         ImageIcon Card3 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card3.png");
         Image card3Image = Card3.getImage();
         Image scaledCard3Image = card3Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card3 = new ImageIcon(scaledCard3Image);
         card3 = new JButton(Card3);

         ImageIcon Card4 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card4.png");
         Image card4Image = Card4.getImage();
         Image scaledCard4Image = card4Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card4 = new ImageIcon(scaledCard4Image);
         card4 = new JButton(Card4);

         ImageIcon Card5 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card5.png");
         Image card5Image = Card5.getImage();
         Image scaledCard5Image = card5Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card5 = new ImageIcon(scaledCard5Image);
         card5 = new JButton(Card5);

         ImageIcon Card6 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card6.png");
         Image card6Image = Card6.getImage();
         Image scaledCard6Image = card6Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card6 = new ImageIcon(scaledCard6Image);
         card6 = new JButton(Card6);

         ImageIcon Card7 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card7.png");
         Image card7Image = Card7.getImage();
         Image scaledCard7Image = card7Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card7 = new ImageIcon(scaledCard7Image);
         card7 = new JButton(Card7);

         ImageIcon Card8 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card8.png");
         Image card8Image = Card8.getImage();
         Image scaledCard8Image = card8Image.getScaledInstance(295, 175, Image.SCALE_SMOOTH);
         Card8 = new ImageIcon(scaledCard8Image);
         card8 = new JButton(Card8);

         ImageIcon Card9 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card9.png");
         Image card9Image = Card9.getImage();
         Image scaledCard9Image = card9Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card9 = new ImageIcon(scaledCard9Image);
         card9 = new JButton(Card9);

         ImageIcon Card10 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card10.png");
         Image card10Image = Card10.getImage();
         Image scaledCard10Image = card10Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card10 = new ImageIcon(scaledCard10Image);
         card10 = new JButton(Card10);

         ImageIcon Card11 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card11.png");
         Image card11Image = Card11.getImage();
         Image scaledCard11Image = card11Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card11 = new ImageIcon(scaledCard11Image);
         card11 = new JButton(Card11);

         ImageIcon Card12 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\Card12.png");
         Image card12Image = Card12.getImage();
         Image scaledCard12Image = card12Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         Card12 = new ImageIcon(scaledCard12Image);
         card12 = new JButton(Card12);

         ImageIcon PrizeClawCard1 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\prizeClawCard1.png");
         Image prizeClawCard1Image = PrizeClawCard1.getImage();
         Image scaledPrizeClawCard1Image = prizeClawCard1Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         PrizeClawCard1 = new ImageIcon(scaledPrizeClawCard1Image);
         prizeClawCard1 = new JButton(PrizeClawCard1);

         ImageIcon PrizeClawCard2 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\PrizeClawCard2.png");
         Image prizeClawCard2Image = PrizeClawCard2.getImage();
         Image scaledPrizeClawCard2Image = prizeClawCard2Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         PrizeClawCard2 = new ImageIcon(scaledPrizeClawCard2Image);
         prizeClawCard2 = new JButton(PrizeClawCard2);

         ImageIcon PrizeClawCard3 = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\project mid term\\src\\prizeClawCard1.png");
         Image prizeClawCard3Image = PrizeClawCard3.getImage();
         Image scaledPrizeClawCard3Image = prizeClawCard3Image.getScaledInstance(290, 175, Image.SCALE_SMOOTH);
         PrizeClawCard3 = new ImageIcon(scaledPrizeClawCard3Image);
         prizeClawCard3 = new JButton(PrizeClawCard3);

         centerPanel.add(card1);
         centerPanel.add(card2);
         centerPanel.add(card3);
         centerPanel.add(card4);
         centerPanel.add(prizeClawCard1);
         centerPanel.add(card5);
         centerPanel.add(card6);
         centerPanel.add(card7);
         centerPanel.add(card8);
         centerPanel.add(prizeClawCard2);
         centerPanel.add(card9);
         centerPanel.add(card10);
         centerPanel.add(card11);
         centerPanel.add(card12);
         centerPanel.add(prizeClawCard3);
        bottomPanel.add(buyButton);
        bottomPanel.add(reserveButton);
        bottomPanel.add(slotMachine);
        bottomPanel.add(slotMachineButtonDifferent);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
       // add(new JScrollPane(messageArea), BorderLayout.EAST);
        addActionListener();
    }
     private void addActionListener() {
         slotMachine.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 isBuyingCoins[turn] = true;
             }
         });
         slotMachineButtonDifferent.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 isBuyDifferentCoins[turn] = true;
                 swRed=true;
                 swWhite=true;
                 swBlack=true;
                 swBlue=true;
                 swGreen=true;
                 buyDifferentCoins[turn]=0;
             }
         });
             buyButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {

                     isBuyingCard[turn] = true;
                 }
             });
         reserveButton.addActionListener(new ActionListener() {
             @Override

             public void actionPerformed(ActionEvent e) {
                 JFrame frame = new JFrame("Select Card");
                 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                 JPanel panel = new JPanel();
                 frame.add(panel);
                 panel.setLayout(new FlowLayout());

                 String[] cardOptions = {"Card 1", "Card 2", "Card 3", "Card 4", "Card 5"
                         , "Card 6", "Card 7", "Card 8", "Card 9", "Card 10", "Card 11", "Card 12"};
                 JComboBox<String> cardList = new JComboBox<>(cardOptions);
                 panel.add(cardList);

                 JButton selectButton = new JButton("Select");
                 panel.add(selectButton);
                 frame.setSize(300, 200);
                 frame.setLocationRelativeTo(null);
                 frame.setVisible(true);

                 selectButton.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                         int cardIndex = cardList.getSelectedIndex();
                         frame.dispose();
                         int countGoldCoins=goldCoins[turn]+goldCoins[1-turn];
                         if (!isCardReserved[1-turn][cardIndex] && countCardReserved[turn]<3){
                         isCardReserved[turn][cardIndex] = true;
                         JOptionPane.showMessageDialog(null,
                                 "The card is reserved.");
                         countCardReserved[turn]++;
                         if(countGoldCoins<5){
                             goldCoins[turn]++;
                             updateCoinLabels(turn);
                         }
                             turn=(turn+1)%2;
                         }else if(countCardReserved[turn]==3){
                             JOptionPane.showMessageDialog(null,
                                     "The number of cards you can reserve is over. ");
                         }
                         else if(isCardReserved[1-turn][cardIndex]) {
                             JOptionPane.showMessageDialog(null,
                                     "This card has already been reserved. ");
                         }
                     }
                 });
             }
         });
             card1.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 1;
                     int cardCoinsRed = 3;
                     int cardCoinsBlue = 3;
                     if (!(isCardReserved[1 - turn][0])&&countPurchased[0]<4 &&
                             isBuyingCard[turn] && redCoins[turn] >= 3 && blueCoins[turn] >= 3) {
                         redCoins[turn] -= cardCoinsRed;
                         blueCoins[turn] -= cardCoinsBlue;
                         whiteCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 1 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[0]++;
                         isCardReserved[turn][0]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     } else if(!isCardReserved[1 - turn][0] &&countPurchased[0] < 4 &&
                             isBuyingCard[turn] && !(redCoins[turn] >= 3 && blueCoins[turn] >= 3)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsRed - redCoins[turn]) +
                                 Math.max(0, cardCoinsBlue - blueCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             blueCoins[turn] = Math.max(0, blueCoins[turn] - cardCoinsBlue);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 1 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[0]++;
                             updateCoinLabels(turn);
                             turn = (turn + 1) % 2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     }else if (isCardReserved[1 - turn][0]) {
                         JOptionPane.showMessageDialog(null,
                         "This card is reserved by your opponent and you cannot buy it!");
                     }
                     else if(countPurchased[0]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card2.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 1;
                     int cardCoinsGreen = 2;
                     int cardCoinsWhite = 3;
                     if (!(isCardReserved[1 - turn][1]) && isBuyingCard[turn]&&countPurchased[1]<4
                             && greenCoins[turn] >= 2 && whiteCoins[turn] >= 3) {
                         greenCoins[turn] -= cardCoinsGreen;
                         whiteCoins[turn] -= cardCoinsWhite;
                         whiteCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 2 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[1]++;
                         updateCoinLabels(turn);
                         isCardReserved[turn][1]=false;
                         turn=(turn+1)%2;
                     }
                    else if(!(isCardReserved[1 - turn][1]) &&  isBuyingCard[turn]&&countPurchased[1]<4
                             &&!( greenCoins[turn] >= 2 && whiteCoins[turn] >= 3)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsGreen - greenCoins[turn]) +
                                 Math.max(0, cardCoinsWhite - whiteCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             greenCoins[turn] = Math.max(0, greenCoins[turn] - cardCoinsGreen);
                             whiteCoins[turn] = Math.max(0, whiteCoins[turn] - cardCoinsWhite);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 2 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[1]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " +
                                     (turn + 1) + ": You don't have enough coins!");
                         }
                     }else if (isCardReserved[1 - turn][1]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[1]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card3.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 1;
                     int cardCoinsGreen = 1;
                     int cardCoinsRed = 3;
                     if (!(isCardReserved[1 - turn][2]) && isBuyingCard[turn] &&countPurchased[2]<4
                             && greenCoins[turn] >= 1 && redCoins[turn] >= 3) {
                         greenCoins[turn] -= cardCoinsGreen;
                         redCoins[turn] -= cardCoinsRed;
                         blueCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 3 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[2]++;
                         isCardReserved[turn][2]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     }
                     else if(!(isCardReserved[1 - turn][2]) && isBuyingCard[turn] &&countPurchased[2]<4
                             &&!( greenCoins[turn] >= 1 && redCoins[turn] >= 3)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsRed - redCoins[turn]) +
                                 Math.max(0, cardCoinsGreen - greenCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             blueCoins[turn] = Math.max(0, greenCoins[turn] - cardCoinsGreen);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 3 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[2]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     } else if (isCardReserved[1 - turn][2]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[2]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card4.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 1;
                     int cardCoinsGreen = 2;
                     int cardCoinsBlue = 2;
                     if (!(isCardReserved[1 - turn][3]) && isBuyingCard[turn] && countPurchased[3]<4
                             && greenCoins[turn] >= 2 && blueCoins[turn] >= 2) {
                         greenCoins[turn] -= cardCoinsGreen;
                         blueCoins[turn] -= cardCoinsBlue;
                         greenCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 4 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[3]++;
                         isCardReserved[turn][3]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     } else if(!(isCardReserved[1 - turn][3]) && isBuyingCard[turn] && countPurchased[3]<4
                             && !(greenCoins[turn] >= 2 && blueCoins[turn] >= 2)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsBlue - blueCoins[turn]) +
                                 Math.max(0, cardCoinsGreen - greenCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             redCoins[turn] = Math.max(0, blueCoins[turn] - cardCoinsBlue);
                             blueCoins[turn] = Math.max(0, greenCoins[turn] - cardCoinsGreen);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 3 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[2]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     } else if (isCardReserved[1 - turn][3]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[3]==4){
                         JOptionPane.showMessageDialog(null, "This card is over!");
                     }
                 }
             });
             card5.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 2;
                     int cardCoinsWhite = 3;
                     int cardCoinsRed = 2;
                     int cardCoinsBlack = 1;
                     if (!(isCardReserved[1 - turn][4]) && isBuyingCard[turn] && countPurchased[4]<4
                             && whiteCoins[turn] >= 3 && redCoins[turn] >= 2 && blackCoins[turn] >= 1) {
                         whiteCoins[turn] -= cardCoinsWhite;
                         redCoins[turn] -= cardCoinsRed;
                         blackCoins[turn] -= cardCoinsBlack;
                         whiteCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 5 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[4]++;
                         isCardReserved[turn][4]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     }else if(!(isCardReserved[1 - turn][4])&&  isBuyingCard[turn] && countPurchased[4]<4
                             && !(whiteCoins[turn] >= 3 && redCoins[turn] >= 2 && blackCoins[turn] >= 1)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsWhite - whiteCoins[turn]) +
                                 Math.max(0, cardCoinsRed - redCoins[turn])+ Math.max(0, cardCoinsBlack - blackCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             whiteCoins[turn] = Math.max(0, whiteCoins[turn] - cardCoinsWhite);
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             blackCoins[turn] = Math.max(0, blackCoins[turn] - cardCoinsBlack);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 5 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[4]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     } else if (isCardReserved[1 - turn][4]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[4]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card6.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 3;
                     int cardCoinsRed = 3;
                     int cardCoinsBlue = 4;
                     if (!(isCardReserved[1 - turn][5]) && isBuyingCard[turn] &&countPurchased[5]<4
                             && redCoins[turn] >= 3 && blueCoins[turn] >= 4) {
                         redCoins[turn] -= cardCoinsRed;
                         blueCoins[turn] -= cardCoinsBlue;
                         greenCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 6 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[5]++;
                         isCardReserved[turn][5]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     }else if(!(isCardReserved[1 - turn][5]) && isBuyingCard[turn] &&countPurchased[5]<4
                             && !(redCoins[turn] >= 3 && blueCoins[turn] >= 4)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsBlue - blueCoins[turn]) +
                                 Math.max(0, cardCoinsRed - redCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             blueCoins[turn] = Math.max(0, blueCoins[turn] - cardCoinsBlue);
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 6 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[5]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     }else if(isBuyingCard[turn] && !(redCoins[turn] >= 3 && blueCoins[turn] >= 4)){
                         JOptionPane.showMessageDialog(null,"Player "
                                 +(turn+1)+" :Your coins are not enough !");
                     } else if(countPurchased[5]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card7.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 3;
                     int cardCoinsGreen = 3;
                     int cardCoinsRed = 3;
                     if (!(isCardReserved[1 - turn][6]) && isBuyingCard[turn] && countPurchased[6]<4
                             && greenCoins[turn] >= 3 && redCoins[turn] >= 3) {
                         greenCoins[turn] -= cardCoinsGreen;
                         redCoins[turn] -= cardCoinsRed;
                         whiteCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 7 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[6]++;
                         isCardReserved[turn][6]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     }else if(!(isCardReserved[1 - turn][6]) && isBuyingCard[turn] && countPurchased[6]<4
                             &&!( greenCoins[turn] >= 3 && redCoins[turn] >= 3)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsGreen - greenCoins[turn]) +
                                 Math.max(0, cardCoinsRed - redCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             greenCoins[turn] = Math.max(0, greenCoins[turn] - cardCoinsGreen);
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 7 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[6]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     } else if (isCardReserved[1 - turn][6]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[6]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card8.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 4;
                     int cardCoinsGreen = 2;
                     int cardCoinsWhite = 3;
                     int cardCoinsRed = 3;
                     if (!(isCardReserved[1 - turn][7]) && isBuyingCard[turn] && countPurchased[7]<4
                             && greenCoins[turn] >= 2 && whiteCoins[turn] >= 3 && redCoins[turn] >= 3) {
                         greenCoins[turn] -= cardCoinsGreen;
                         whiteCoins[turn] -= cardCoinsWhite;
                         redCoins[turn] -= cardCoinsRed;
                         blueCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 8 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[7]++;
                         isCardReserved[turn][7]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     }else if(!(isCardReserved[1 - turn][7]) && isBuyingCard[turn] && countPurchased[7]<4
                             &&!( greenCoins[turn] >= 2 && whiteCoins[turn] >= 3 && redCoins[turn] >= 3)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsGreen - greenCoins[turn]) +
                                 Math.max(0, cardCoinsRed - redCoins[turn]+Math.max(0,cardCoinsWhite-whiteCoins[turn]));
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             greenCoins[turn] = Math.max(0, greenCoins[turn] - cardCoinsGreen);
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             whiteCoins[turn] = Math.max(0, whiteCoins[turn] - cardCoinsWhite);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 8 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[7]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     } else if (isCardReserved[1 - turn][7]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[7]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card9.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 4;
                     int cardCoinsBlue = 2;
                     int cardCoinsRed = 5;
                     if (!(isCardReserved[1 - turn][8]) && isBuyingCard[turn] && countPurchased[8]<4
                             && blueCoins[turn] >= 2 && redCoins[turn] >= 5) {
                         blueCoins[turn] -= cardCoinsBlue;
                         redCoins[turn] -= cardCoinsRed;
                         greenCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 9 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[8]++;
                         isCardReserved[turn][8]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     }if(!(isCardReserved[1 - turn][8]) && isBuyingCard[turn] && countPurchased[8]<4
                             &&!( blueCoins[turn] >= 2 && redCoins[turn] >= 5)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsBlue - blueCoins[turn]) +
                                 Math.max(0, cardCoinsRed - redCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             blueCoins[turn] = Math.max(0, blueCoins[turn] - cardCoinsBlue);
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 9 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[8]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     } else if (isCardReserved[1 - turn][8]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[8]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card10.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 5;
                     int cardCoinsBlue = 3;
                     int cardCoinsWhite = 1;
                     int cardCoinsRed = 5;
                     if (!(isCardReserved[1 - turn][9]) && isBuyingCard[turn] && countPurchased[9]<4
                             && blueCoins[turn] >= 3 && whiteCoins[turn] >= 1 && redCoins[turn] >= 5) {
                         blueCoins[turn] -= cardCoinsBlue;
                         whiteCoins[turn] -= cardCoinsWhite;
                         redCoins[turn] -= cardCoinsRed;
                         redCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 10 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[9]++;
                         isCardReserved[turn][9]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     }else if(!(isCardReserved[1 - turn][9]) && isBuyingCard[turn] && countPurchased[9]<4
                             && !(blueCoins[turn] >= 3 && whiteCoins[turn] >= 1 && redCoins[turn] >= 5)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsBlue - blueCoins[turn]) +
                                 Math.max(0, cardCoinsRed - redCoins[turn]+Math.max(0,cardCoinsWhite-whiteCoins[turn]));
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             blueCoins[turn] = Math.max(0, blueCoins[turn] - cardCoinsBlue);
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             whiteCoins[turn] = Math.max(0, whiteCoins[turn] - cardCoinsWhite);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 10 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[9]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     }else if (isCardReserved[1 - turn][9]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[9]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card11.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 4;
                     int cardCoinsBlue = 3;
                     int cardCoinsRed = 6;
                     if (!(isCardReserved[1 - turn][10]) && isBuyingCard[turn] && countPurchased[10]<4
                             && blueCoins[turn] >= 3 && redCoins[turn] >= 6) {
                         blueCoins[turn] -= cardCoinsBlue;
                         redCoins[turn] -= cardCoinsRed;
                         blueCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 11 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[10]++;
                         isCardReserved[turn][10]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     }else if(!(isCardReserved[1 - turn][10]) && isBuyingCard[turn] && countPurchased[10]<4
                             &&!( blueCoins[turn] >= 3 && redCoins[turn] >= 6)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsBlue - blueCoins[turn]) +
                                 Math.max(0, cardCoinsRed - redCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             blueCoins[turn] = Math.max(0, blueCoins[turn] - cardCoinsBlue);
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 11 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[10]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     }else if (isCardReserved[1 - turn][10]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[10]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             card12.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     int cardScore = 5;
                     int cardCoinsGreen = 4;
                     int cardCoinsRed = 6;
                     if (!(isCardReserved[1 - turn][11]) && isBuyingCard[turn] && countPurchased[11]<4
                             && greenCoins[turn] >= 4 && redCoins[turn] >= 6) {
                         greenCoins[turn] -= cardCoinsGreen;
                         redCoins[turn] -= cardCoinsRed;
                         blueCoins[turn]++;
                         playerScore[turn] += cardScore;
                         purchasedCards[turn] += 12 + ", ";
                         countPurchasedCards[turn]++;
                         countPurchased[11]++;
                         isCardReserved[turn][11]=false;
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                     } else if(!(isCardReserved[1 - turn][11]) && isBuyingCard[turn] && countPurchased[11]<4
                             &&!( greenCoins[turn] >= 4 && redCoins[turn] >= 6)) {
                         int requiredGoldCoins = Math.max(0, cardCoinsGreen - greenCoins[turn]) +
                                 Math.max(0, cardCoinsRed - redCoins[turn]);
                         if (goldCoins[turn] >= requiredGoldCoins) {
                             goldCoins[turn] -= requiredGoldCoins;
                             greenCoins[turn] = Math.max(0, greenCoins[turn] - cardCoinsGreen);
                             redCoins[turn] = Math.max(0, redCoins[turn] - cardCoinsRed);
                             playerScore[turn] += cardScore;
                             purchasedCards[turn] += 12 + ", ";
                             countPurchasedCards[turn]++;
                             countPurchased[11]++;
                             updateCoinLabels(turn);
                             turn=(turn+1)%2;
                         } else {
                             JOptionPane.showMessageDialog(null, "Player " + (turn + 1) + ": You don't have enough coins!");
                         }
                     }else if (isCardReserved[1 - turn][11]) {
                         JOptionPane.showMessageDialog(null,
                                 "This card is reserved by your opponent and you cannot buy it!");
                     } else if(countPurchased[11]==4){
                         JOptionPane.showMessageDialog(null,
                                 "This card is over!");
                     }
                 }
             });
             slotMachineButtonsRed.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if (isBuyingCoins[turn] && countCoinsInSlotMachines[0]==4) {
                         redCoins[turn] += 2;
                         countCoinsInSlotMachines[0]-=2;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                         isBuyingCoins[1-turn]=false;
                     }
                     else if(swRed &&countCoinsInSlotMachines[0]>0 && isBuyDifferentCoins[turn]
                             &&buyDifferentCoins[turn]<3){
                         redCoins[turn]++;
                         buyDifferentCoins[turn]++;
                         countCoinsInSlotMachines[0]--;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         if(buyDifferentCoins[turn]==3){
                             turn=(turn+1)%2;
                             isBuyDifferentCoins[1-turn]=false;
                         }else{ swRed =false;}
                     }
                     else if(countCoinsInSlotMachines[0]<4 && isBuyingCoins[turn]){
                         JOptionPane.showMessageDialog(null,
                                 "You can only 2 coins when the machine has 4 coins.");
                     }
                      if(countCoinsInSlotMachines[0]==0){
                         countCoinsInSlotMachines[0]+=4;
                     }
                 }
             });
             slotMachineButtonsWhite.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if (isBuyingCoins[turn] && countCoinsInSlotMachines[1]==4 ) {
                         whiteCoins[turn] += 2;
                         countCoinsInSlotMachines[1]-=2;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                         isBuyingCoins[1-turn]=false;
                     }else if(swWhite && isBuyDifferentCoins[turn] && countCoinsInSlotMachines[1]>0
                             &&buyDifferentCoins[turn]<3){
                         whiteCoins[turn]++;
                         buyDifferentCoins[turn]++;
                         countCoinsInSlotMachines[1]--;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         if(buyDifferentCoins[turn]==3){
                             turn=(turn+1)%2;
                             isBuyDifferentCoins[1-turn]=false;
                         }else{ swWhite =false;}
                     }
                     else if(countCoinsInSlotMachines[1]<4 && isBuyingCoins[turn]){
                         JOptionPane.showMessageDialog(null,
                                 "You can only 2 coins when the machine has 4 coins.");
                     }
                     if(countCoinsInSlotMachines[1]==0){
                         countCoinsInSlotMachines[1]+=4;
                     }
                 }
             });
             slotMachineButtonsGreen.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if (isBuyingCoins[turn] &&  countCoinsInSlotMachines[2]==4) {
                         greenCoins[turn] += 2;
                         countCoinsInSlotMachines[2]-=2;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                         isBuyingCoins[1-turn]=false;
                     }
                     else if(swGreen && isBuyDifferentCoins[turn] &&  countCoinsInSlotMachines[2]>0
                             &&buyDifferentCoins[turn]<3){
                         greenCoins[turn]++;
                         buyDifferentCoins[turn]++;
                         countCoinsInSlotMachines[2]--;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         if(buyDifferentCoins[turn]==3){
                             turn=(turn+1)%2;
                             isBuyDifferentCoins[1-turn]=false;
                         }else{ swGreen =false;}
                     }
                     else if(countCoinsInSlotMachines[2]<4 && isBuyingCoins[turn]){
                         JOptionPane.showMessageDialog(null,
                                 "You can only 2 coins when the machine has 4 coins.");
                     }
                     if(countCoinsInSlotMachines[2]==0){
                         countCoinsInSlotMachines[2]+=4;
                     }
                 }
             });
             slotMachineButtonsBlack.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if (isBuyingCoins[turn] &&  countCoinsInSlotMachines[3]==4) {
                         blackCoins[turn] += 2;
                         countCoinsInSlotMachines[3]-=2;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                         isBuyingCoins[1-turn]=false;
                     }
                     else if(swBlack && isBuyDifferentCoins[turn] && countCoinsInSlotMachines[3]>0
                             && buyDifferentCoins[turn]<3){
                         blackCoins[turn]++;
                         buyDifferentCoins[turn]++;
                         countCoinsInSlotMachines[3]--;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         if(buyDifferentCoins[turn]==3){
                             turn=(turn+1)%2;
                             isBuyDifferentCoins[1-turn]=false;
                         }else{
                             swBlack =false;
                         }
                     }
                     else if(countCoinsInSlotMachines[3]<4 && isBuyingCoins[turn]){
                         JOptionPane.showMessageDialog(null,
                                 "You can only 2 coins when the machine has 4 coins.");
                     }
                     if(countCoinsInSlotMachines[3]==0){
                         countCoinsInSlotMachines[3]+=4;
                     }
                 }
             });
             slotMachineButtonsBlue.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if (isBuyingCoins[turn] && countCoinsInSlotMachines[4]==4) {
                         blueCoins[turn] += 2;
                         countCoinsInSlotMachines[4]-=2;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         turn=(turn+1)%2;
                         isBuyingCoins[1-turn]=false;
                     }
                     else if(swBlue && isBuyDifferentCoins[turn] &&  countCoinsInSlotMachines[4]>0
                             &&buyDifferentCoins[turn]<3){
                         blueCoins[turn]++;
                         buyDifferentCoins[turn]++;
                         countCoinsInSlotMachines[4]--;
                         checkCoinTotal(turn);
                         updateCoinLabels(turn);
                         if(buyDifferentCoins[turn]==3){
                             turn=(turn+1)%2;
                             isBuyDifferentCoins[1-turn]=false;
                         }else{ swBlue =false;
                        }
                     }
                     else if(countCoinsInSlotMachines[4]<4 && isBuyingCoins[turn]){
                         JOptionPane.showMessageDialog(null,
                                 "You can only 2 coins when the machine has 4 coins.");
                     }
                     if(countCoinsInSlotMachines[4]==0){
                         countCoinsInSlotMachines[4]+=4;
                     }
                 }
             });
     }
     private void updateCoinLabels(int playerIndex) {
         if(prizeCard1 && redCoins[playerIndex]>=4 && greenCoins[playerIndex]>=4){
             playerScore[playerIndex]+=3;
             purchasedCards[playerIndex]+= "prize ,";
                 prizeCard1=false;
         }
         else if(prizeCard2 && blueCoins[playerIndex]>=5 && redCoins[playerIndex]>=5){
             playerScore[playerIndex]+=4;
             purchasedCards[playerIndex]+="prize ,";
             prizeCard2=false;
         }else if(prizeCard3 && greenCoins[playerIndex]>=4&&redCoins[playerIndex]>=4){
             playerScore[playerIndex]+=3;
             purchasedCards[playerIndex]+="prize ,";
             prizeCard3=false;
         }

         playerScoreLabel[playerIndex].setText("Player " + (playerIndex + 1) + " Score: " + playerScore[playerIndex]);
         playerCoinLabel[playerIndex].setText("Red : " + redCoins[playerIndex] +
         ", Blue : " + blueCoins[playerIndex] +", Black : "+blackCoins[playerIndex]+
         ", Green : "+greenCoins[playerIndex]+", White : "+whiteCoins[playerIndex]+", Gold : "+goldCoins[playerIndex]);
         purchasedCardsLabel[playerIndex].setText("Purchased Cards: " + purchasedCards[playerIndex]);


         if(playerScore[1-playerIndex]>=15&&playerScore[playerIndex]>=15
                 &&playerScore[1-playerIndex]==playerScore[playerIndex]){
             if(countPurchasedCards[playerIndex]<countPurchasedCards[1-playerIndex]){
                 JOptionPane.showMessageDialog(null,"Player "+(1+playerIndex)+" wins!");
                 JFrame frame = ( JFrame )SwingUtilities.getWindowAncestor(GamePanel.this);
                 frame.dispose();
             }
             else {JOptionPane.showMessageDialog(null,"Player "+(2-playerIndex)+" wins!");
             JFrame frame = ( JFrame )SwingUtilities.getWindowAncestor(GamePanel.this);
             frame.dispose();}
         }
         else if(playerScore[1-playerIndex]>=15){
             JOptionPane.showMessageDialog(null,"Player "+(2-playerIndex)+" wins!");
             JFrame frame = ( JFrame )SwingUtilities.getWindowAncestor(GamePanel.this);
             frame.dispose();
         }
     }
     public void checkCoinTotal(int turn) {
         int totalCoins = redCoins[turn] + blueCoins[turn] + blackCoins[turn] +
                 greenCoins[turn] + whiteCoins[turn];
         if (totalCoins > 10) {
             JOptionPane.showMessageDialog(null, "Total coins exceed 10." +
                     " You need to reduce your coins.");
             reduceCoinsMenu(turn);
         }
     }public void reduceCoinsMenu(int turn) {
         JFrame frame = new JFrame("Reduce Coins");
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         JPanel panel = new JPanel();
         frame.add(panel);
         panel.setLayout(new GridLayout(3, 2));

         JLabel colorLabel = new JLabel("Select coin color:");
         panel.add(colorLabel);
         JComboBox<String> colorComboBox = new JComboBox<>(new String[]{"Red", "Blue", "Black", "Green", "White"});
         panel.add(colorComboBox);

         JLabel amountLabel = new JLabel("Select number of coins to reduce:");
         panel.add(amountLabel);
         SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
         JSpinner spinner = new JSpinner(spinnerModel);
         panel.add(spinner);

         JButton reduceButton = new JButton("Reduce Coins");
         panel.add(reduceButton);

         frame.setSize(300, 200);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);

         reduceButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 String selectedColor = (String) colorComboBox.getSelectedItem();
                 int coinsToReduce = (int) spinner.getValue();
                 reduceCoins(selectedColor, coinsToReduce,turn);
                 frame.dispose();
             }
         });
     }
     public void reduceCoins(String color, int coinsToReduce,int turn) {
         switch (color) {
             case "Red":
                 redCoins[turn] -= coinsToReduce;
                 updateCoinLabels(turn);
                 break;
             case "Blue":
                 blueCoins[turn] -= coinsToReduce;
                 updateCoinLabels(turn);
                 break;
             case "Black":
                 blackCoins[turn] -= coinsToReduce;
                 updateCoinLabels(turn);
                 break;
             case "Green":
                 greenCoins[turn] -= coinsToReduce;
                 updateCoinLabels(turn);
                 break;
             case "White":
                 whiteCoins[turn] -= coinsToReduce;
                 updateCoinLabels(turn);
                 break;
         }
     }

     GamePanel(JLabel playerScoreLabel, JLabel playerCoinLabel,JLabel purchasedCardsLabel) {
         this.playerScoreLabel = new JLabel[]{playerScoreLabel};
         this.playerCoinLabel = new JLabel[]{playerCoinLabel};
         this.purchasedCardsLabel= new JLabel[]{purchasedCardsLabel};
     }
    public JLabel[] getPlayerScoreLabel() {
        return playerScoreLabel;
    }
    public JLabel[] getPlayerCoinLabel() {
        return playerCoinLabel;
    }
    public JButton getReserveButton() {
        return reserveButton;
    }
     public JButton getSlotMachine() {
         return slotMachine;
     }
     public JButton getBuyButton() {
        return buyButton;
    }
    public JTextArea getMessageArea() {
        return messageArea;
    }
     public int[] getBlackCoins() {
         return blackCoins;
     }
     public int[] getBlueCoins() {
         return blueCoins;
     }
     public int[] getGreenCoins() {
         return greenCoins;
     }
     public int[] getRedCoins() {
         return redCoins;
     }
     public int[] getWhiteCoins() {
         return whiteCoins;
     }
     public String[] getPurchasedCards() {
         return purchasedCards;
     }


 }
