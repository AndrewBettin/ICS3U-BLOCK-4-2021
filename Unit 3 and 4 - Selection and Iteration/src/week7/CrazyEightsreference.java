package week7;

import java.util.Scanner;

public class CrazyEightsreference {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final double CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";

    public static void main(String [] args){
       int playerPoints = 0, c1Points = 0, c2Points = 0;

       while (!gameOver(playerPoints, c1Points, c2Points)){
         String result = playRound();
         int firstDash = result.indexOf("-");
         int secondDash = result.lastIndexOf("-");
         //int secondDash = result.indexOf("-", firstDash + 1);
         playerPoints += Integer.parseInt(result.substring(0, firstDash));
         c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
         c2Points += Integer.parseInt(result.substring(secondDash + 1));

       }  
      }
      
     
     private static String playRound() {
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";

        String topCard = getCard("");
        System.out.println("the top card is: " + topCard);

        /** 
         * build something that looks like: hand-topCard
         */

        playerHand = "";

        for(int i = 0; i < 5; i++){
           playerHand += getCard(playerHand) + " ";
        }
  

        Scanner in = new Scanner(System.in);
        playerHand = discard(in, playerHand);
        System.out.println("Your Hand: " + playerHand);
        System.out.println("Player 1 Hand " + "XX XX XX XX XX");
        System.out.println("Player 2 Hand " + "XX XX XX XX XX");
  
        String temp  = processPlayer(playerHand, topCard);
        playerHand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-"));

        temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
        c1Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-"));

        temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
        c2Hand= temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-"));

        return "17-0-8";
   }
   
   private static String processComputer(String c1Hand, String topCard, String playerHand, String c2Hand) {
      return null;
   }


   private static String processPlayer(String playerHand, String topCard) {
      boolean validInput = false;
      Scanner in = new Scanner(System.in);
      String answer = "";

      while (!validInput) {
         System.out.print("Draw or Play ([DR]aw / [P]lay): ");
         answer = in.nextLine().toUpperCase();
         System.out.println();
         if (answer.equals("DRAW") || answer.equals("DR")){
            playerHand += getCard("") + " ";
            System.out.println("Your hand: " + playerHand);
            System.out.println("The top card is: " + topCard);
            if (playerHand.contains(answer) && playerHand.substring(1,2) == topCard.substring(1,2)){
               validInput = true;
            }  

         } else if (answer.equals("PLAY") || answer.substring(0,1).equals("P")) {
            if(answer.substring(3,4).equals(topCard.substring(1,2))){

            discard(in, playerHand);
            System.out.println("Your hand: " + playerHand);
            validInput = true;
            }
         } else {
            System.out.println("Invalid Input: Same suit or card number only!");
         }
      }
      in.close();
      return answer;
   }

   private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
      return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
   }

   private static String getCard(String usedCards) {
        String card = getFace() + getSuit();
  
        while (usedCards.indexOf(card) >= 0) {
           card = getFace() + getSuit();
        }
        return card;
     }
     
     private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
  
        if (suit == 0)
           return HEARTS;
        else if (suit == 1)
           return DIAMONDS;
        else if (suit == 2)
           return CLUBS;
        else
           return SPADES;
  
     }
  
     private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
           return suit + "";
        else if (suit == 1)
           return ACE;
        else if (suit == 11)
           return JACK;
        else if (suit == 12)
           return QUEEN;
        else
           return KING;
  
     }

     private static String discard(Scanner in, String playerHand) {
      int numCardsToReplace = getNumberToDiscard(in);
      String temp = playerHand;
      if (numCardsToReplace == 0)
         return playerHand;
      else if (numCardsToReplace == 1) {
         playerHand = getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
      } else {
         String cardToReplace = getCardToDiscard(in, numCardsToReplace, playerHand);
         int space = cardToReplace.indexOf(" ");
         String card1 = "";
         if (space == -1)
            card1 = cardToReplace;
         else
            card1 = cardToReplace.substring(0, space);

         String card = getCard(playerHand + temp);
         playerHand = playerHand.replace(card1, card);
      }
      return playerHand;
   }

   private static int getNumberToDiscard(Scanner in) {
      return 0;
   }


   private static String getCardToDiscard(Scanner in, int numCardsToReplace, String playerHand) {
      final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
      boolean validInput = false;
      String cards = "";
      while (!validInput) {
         System.out.println("Please enter the cards to play: (ex. 7H KD): ");
         cards = in.nextLine().toUpperCase();
         if ((numCardsToReplace == 1) && VALID_CARDS.indexOf(cards) < 0) {
            System.out.println("Not a valid card: " + cards);
         } else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) < 0))
            System.out.println("You don't have a " + cards);
         else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) >= 0)) {
            validInput = true;
         } else if (numCardsToReplace == 1) {
            int space = cards.indexOf(" ");

            String card = cards.substring(0, space);
            if (VALID_CARDS.indexOf(card) < 0)
               System.out.println("Not a valid card: " + card);

            else if (playerHand.indexOf(card) < 0)
               System.out.println("You don't have a " + card);
            //else if (card1.equals(card2))
               //System.out.println("You cannot discard the same card.");
            else
               validInput = true;
         }
      }
      return cards;
   }
}

