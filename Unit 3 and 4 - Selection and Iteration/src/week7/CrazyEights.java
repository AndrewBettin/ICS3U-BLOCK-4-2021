package week7;

import java.util.Scanner;

public class CrazyEights {
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

   private static final int aceP = 1;
   private static final int eightP = 50;
   private static final int tkjqP = 10;

   public static void main(String[] args) {
      int playerPoints = 0, c1Points = 0, c2Points = 0;

      while (!gameOver(playerPoints, c1Points, c2Points)) {
         String result = playRound();
         int firstDash = result.indexOf("-");
         int secondDash = result.lastIndexOf("-");
         // int secondDash = result.indexOf("-", firstDash + 1);
         playerPoints += Integer.parseInt(result.substring(0, firstDash));
         c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
         c2Points += Integer.parseInt(result.substring(secondDash + 1));

         if(gameOver(playerPoints, c1Points, c2Points)){ //tells you who had the most points and lost
            if(playerPoints > c1Points && playerPoints > c2Points){
               System.out.println("You lost!");
            } else if(c1Points > c2Points && c1Points > playerPoints){
               System.out.println("Computer 1 lost!"); 
            } else if(c2Points > c1Points && c2Points > playerPoints){
               System.out.println("Computer 2 lost!");
            }

            if(playerPoints < c1Points && playerPoints < c2Points){ //tell you who had the least points and won
               System.out.println("You win!");
            } else if(c1Points < c2Points && c1Points < playerPoints){
               System.out.println("Computer 1 wins!"); 
            } else if(c2Points < c1Points && c2Points < playerPoints){
               System.out.println("Computer 2 wins!");
            }
            break;
         }
      }
   }

   private static String playRound() {
      String playerHand = "";
      String c1Hand = "";
      String c2Hand = "";
      String s1 = "";
      String s2 = "";

      int playerPoints = 0, c1Points = 0, c2Points = 0;
      // String result = playRound();

      String topCard = getCard("");


      playerHand = "";

      for (int i = 0; i < 5; i++) {
         playerHand += getCard(playerHand) + " ";
         c1Hand += getCard(c1Hand) + " ";
         c2Hand += getCard(c2Hand) + " ";
      }
      Scanner in = new Scanner(System.in);

      String temp = "";
      while (playerHand.length() > 1 && c1Hand.length() > 1 && c2Hand.length() > 1) {
         System.out.println();
         System.out.println("The top card is: " + topCard);
         playerHand = discard(in, playerHand, topCard);
         System.out.println("Your Hand: " + playerHand);
         System.out.println("Computer 1 Hand: " + c1Hand);
         System.out.println("Computer 2 Hand: " + c2Hand);

         temp = processPlayer(playerHand, topCard);
         playerHand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);

         temp = processComputer(c1Hand, topCard);
         c1Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);

         temp = processComputer(c2Hand, topCard);
         c2Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
      }
      int numSpacesP = playerHand.length() - playerHand.replace(" ", "").length();  //finds the spaces and replaces them so thay it can accurately calculate score without finding a space
      int c1NumSpaces = c1Hand.length() - c1Hand.replace(" ", "").length();
      int c2NumSpaces = c2Hand.length() - c2Hand.replace(" ", "").length();
      String s1Num = "";

      int i = 0;
      if(playerHand.length() == 0){
         
      } else{
         while(i < numSpacesP){ // the follwing lines find the card number to then the card in the if statments below
            s1 = playerHand.substring(0, playerHand.indexOf(" ")); 
            s2 = playerHand.substring(playerHand.indexOf(" ") + 1, playerHand.length());
            if(s1.length() == 2){
               s1Num = String.valueOf(s1.charAt(0));
            } else if(s1.length() == 3){
               s1Num = String.valueOf(s1.charAt(0)) + String.valueOf(s1.charAt(1));
            }

            if(s1Num.equals(ACE)){ 
               playerPoints += aceP;
            } else if(s1Num.equals("2")){
               playerPoints += 2;
            } else if(s1Num.equals("3")){
               playerPoints += 3;
            } else if(s1Num.equals("4")){
               playerPoints += 4;
            } else if(s1Num.equals("5")){
               playerPoints += 5;
            } else if(s1Num.equals("6")){
               playerPoints += 6;
            } else if(s1Num.equals("7")){
               playerPoints += 7;
            } else if(s1Num.equals("8")){
               playerPoints += eightP;
            } else if(s1Num.equals("9")){
               playerPoints += 9;
            } else if(s1Num.equals("3")){
               playerPoints += 3;
            } else if(s1Num.equals("10")){
               playerPoints += tkjqP;
            } else if(s1Num.equals(JACK)){
               playerPoints += tkjqP;
            } else if(s1Num.equals(QUEEN)){
               playerPoints += tkjqP;
            } else if(s1Num.equals(KING)){
               playerPoints += tkjqP;
            }
            playerHand = s2;
            i++;
         }
      }
      if(c1Hand.length() == 0){

      } else{
         i = 0;
         while(i < c1NumSpaces){
            s1 = c1Hand.substring(0, c1Hand.indexOf(" "));
            s2 = c1Hand.substring(c1Hand.indexOf(" ") + 1, c1Hand.length());
            if(s1.length() == 2){
               s1Num = String.valueOf(s1.charAt(0));
            } else if(s1.length() == 3){
               s1Num = String.valueOf(s1.charAt(0)) + String.valueOf(s1.charAt(1));
            }

            if(s1Num.equals(ACE)){
               c1Points += aceP;
            } else if(s1Num.equals("2")){
               c1Points += 2;
            } else if(s1Num.equals("3")){
               c1Points += 3;
            } else if(s1Num.equals("4")){
               c1Points += 4;
            } else if(s1Num.equals("5")){
               c1Points += 5;
            } else if(s1Num.equals("6")){
               c1Points += 6;
            } else if(s1Num.equals("7")){
               c1Points += 7;
            } else if(s1Num.equals("8")){
               playerPoints += eightP;
            } else if(s1Num.equals("9")){
               c1Points += 9;
            } else if(s1Num.equals("3")){
               c1Points += 3;
            } else if(s1Num.equals("10")){
               c1Points += tkjqP;
            } else if(s1Num.equals(JACK)){
               c1Points += tkjqP;
            } else if(s1Num.equals(QUEEN)){
               c1Points += tkjqP;
            } else if(s1Num.equals(KING)){
               c1Points += tkjqP;
            }
            c1Hand = s2;
            i++;
         }
      }
      if(c2Hand.length() == 0){

      } else{
         i = 0;
         while(i < c2NumSpaces){
            s1 =c2Hand.substring(0, c2Hand.indexOf(" "));
            s2 = c2Hand.substring(c2Hand.indexOf(" ") + 1, c2Hand.length());
            if(s1.length() == 2){
               s1Num = String.valueOf(s1.charAt(0));
            } else if(s1.length() == 3){
               s1Num = String.valueOf(s1.charAt(0)) + String.valueOf(s1.charAt(1));
            }

            if(s1Num.equals(ACE)){
               c2Points += aceP;
            } else if(s1Num.equals("2")){
               c2Points += 2;
            } else if(s1Num.equals("3")){
               c2Points += 3;
            } else if(s1Num.equals("4")){
               c2Points += 4;
            } else if(s1Num.equals("5")){
               c2Points += 5;
            } else if(s1Num.equals("6")){
               c2Points += 6;
            } else if(s1Num.equals("7")){
               c2Points += 7;
            } else if(s1Num.equals("8")){
               c2Points += eightP;
            } else if(s1Num.equals("9")){
               c2Points += 9;
            } else if(s1Num.equals("3")){
               c2Points += 3;
            } else if(s1Num.equals("10")){
               c2Points += tkjqP;
            } else if(s1Num.equals(JACK)){
               c2Points += tkjqP;
            } else if(s1Num.equals(QUEEN)){
               c2Points += tkjqP;
            } else if(s1Num.equals(KING)){
               c2Points += tkjqP;
            }
            c2Hand = s2;
            i++;
         }

      }
      return playerPoints + "-" + c1Points + "-" + c2Points;
   }

   private static String processComputer(String c1Hand, String topCard) {
      String playCard = "";
      String uTopCardNum = "";
      String uTopCardFace = "";
      int j = 0;
      if (topCard.length() == 3) {
         uTopCardNum = String.valueOf(topCard.charAt(0)) + String.valueOf(topCard.charAt(1));
         uTopCardFace = String.valueOf(topCard.charAt(2));
      } else if (topCard.length() == 2) {
         uTopCardNum = String.valueOf(topCard.charAt(0));
         uTopCardFace = String.valueOf(topCard.charAt(1));
      }
      

      while (canPlay(c1Hand, uTopCardNum + uTopCardFace)) {
         int numSpaces = c1Hand.length() - c1Hand.replace(" ", "").length();
         int i = 0;
         String temp = c1Hand;
         String s1 = "";
         String s2 = "";
         String s3 = "";
         while (i < numSpaces) { //iterates through the computer hand until if finds
                                 // a letter or number that matches that of the topCard
            s1 = temp.substring(0, temp.indexOf(" "));
            s2 = temp.substring(temp.indexOf(" ") + 1, temp.length());
            if (s1.length() == 2) {
               if (String.valueOf(s1.charAt(0)).equals(uTopCardNum)
                     || String.valueOf(s1.charAt(1)).equals(uTopCardFace)) {
                  s3 += s2 + "";
                  temp = s3;
                  return temp + "-" + s1;
               }
            } else if (s1.length() == 3) {
               if (String.valueOf(s1.charAt(0) + s1.charAt(1)).equals(uTopCardNum)
                     || String.valueOf(s1.charAt(2)).equals(uTopCardFace)) {
                  s3 += s2 + " ";
                  temp = s3;
                  return temp + "-" + s1;
               }
            }
            temp = s2;
            s3 += s1 + " ";
            i++;
         }
      }

      while (!canPlay(c1Hand, uTopCardNum + uTopCardFace)) {
         if (c1Hand.contains("8")) { //check to see if there is an 8 before trying to draw a card
            int cardIndex = c1Hand.indexOf("8");
            playCard = c1Hand.substring(cardIndex, cardIndex + 1);
            System.out.println("Computer 1 played a " + playCard);
            topCard = playCard;
            System.out.println(topCard);
         }

         while ((!c1Hand.contains(uTopCardNum) || !c1Hand.contains(uTopCardFace)) && j < 5) { 
            c1Hand += getCard("") + " "; //draws cards until either it finds a car with the same suit or number OR it has drawn 5 cards
            j++;
         }
         System.out.println();
         System.out.println("The computer drew a card!");
      }

      return c1Hand + "-" + topCard;
   }

   private static String processPlayer(String playerHand, String topCard) {
      int k = 0;
      Scanner in = new Scanner(System.in);
      String playCard = "";
      String uTopCardNum = "";
      String uTopCardFace = "";
      if (topCard.length() == 3) { //gets the topCard that has has a length of 3 (ex.10H)
         uTopCardNum = String.valueOf(topCard.charAt(0)) + String.valueOf(topCard.charAt(1));
         uTopCardFace = String.valueOf(topCard.charAt(2));
      } else if (topCard.length() == 2) { // gets the topCard that has a length of 2 (ex.JH)
         uTopCardNum = String.valueOf(topCard.charAt(0));
         uTopCardFace = String.valueOf(topCard.charAt(1));
      }
      while (!canPlay(playerHand, uTopCardNum + uTopCardFace)) { //first check if it can play or not
         if ((!playerHand.contains(uTopCardNum) || !playerHand.contains(uTopCardFace)) && k < 5) {
            playerHand += getCard("") + " "; //draws cards until either it finds a car with the same suit or number OR it has drawn 5 cards
            k++;
         }
         System.out.println("Your hand:" + playerHand); //prints you hand :)
      }

      while (canPlay(playerHand, uTopCardNum + uTopCardFace)) { //sees whether or not you can play
         playerHand = discard(in, playerHand, uTopCardNum + uTopCardFace);
         System.out.println("Which card would you like to place? "); 
         playCard = in.nextLine().toUpperCase(); //lets you type your card
         if (playerHand.contains(playCard) && canPlay(playCard, uTopCardNum + uTopCardFace)) { //check to see if you have the inputed card
            int cardIndex = playerHand.indexOf(playCard);
            String s1 = playerHand.substring(0, cardIndex);
            String s2 = playerHand.substring(cardIndex + playCard.length() + 1, playerHand.length());
            playerHand = s1 + s2;
            return playerHand + "-" + playCard;
         } else {
            System.out.println("You cannot play that card!");
         }
      }

      in.close();
      return playerHand + "-" + topCard; //returns the new topCard and hand of the player
   }

   private static boolean canPlay(String playerHand, String topCard) {
      /**
       * In order for the player to play: 1 card must have the same number or suit as
       * topCard OR the player must have an 8 in his hand
       */
      String cardNumber = topCard.substring(0, topCard.length() - 1);
      String cardSuit = topCard.substring(topCard.length() - 1);
      int findNumber = playerHand.indexOf(cardNumber);
      int findSuit = playerHand.indexOf(cardSuit);
      int findEight = playerHand.indexOf("8");
      if (findNumber != -1 || findEight != -1 || findSuit != -1) {
         return true;
      } else {
         return false;
      }
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

   private static String discard(Scanner in, String playerHand, String topCard) {
      int numCardsToReplace = getNumberToDiscard(in);
      String temp = playerHand;
      if (numCardsToReplace == 0)
         return playerHand;
      else if (numCardsToReplace == 1) {
         playerHand = getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
      } else {
         String cardToReplace = getCardToDiscard(in, playerHand, topCard);
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

   private static String getCardToDiscard(Scanner in, String playerHand, String topCard) {
      final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
      boolean validInput = false;
      String cards = "";
      while (!validInput) {
         System.out.println("Please enter the cards to play: (ex. 7H KD): ");
         cards = in.nextLine().toUpperCase();
         if ((playerHand.length() == 2 || playerHand.length() == 3) && VALID_CARDS.indexOf(cards) < 0) {
            System.out.println("Not a valid card: " + cards);
         } else if ((playerHand.length() == 2 || playerHand.length() == 3) && (playerHand.indexOf(cards) < 0))
            System.out.println("You don't have a " + cards);
         else if ((playerHand.length() == 2 || playerHand.length() == 3) && (playerHand.indexOf(cards) >= 0)) {
            validInput = true;
         } else if (playerHand.length() == 2 || playerHand.length() == 3) {
            int space = cards.indexOf(" ");

            String card = cards.substring(0, space);
            if (VALID_CARDS.indexOf(card) < 0)
               System.out.println("Not a valid card: " + card);

            else if (playerHand.indexOf(card) < 0)
               System.out.println("You don't have a " + card);
            // else if (card1.equals(card2))
            // System.out.println("You cannot discard the same card.");
            else
               validInput = true;
         }
      }
      return cards;
   }
}
