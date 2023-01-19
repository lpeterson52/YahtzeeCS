import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class Yahtzee {
  public int rollsLeft = 4;
  public int lives = 2;
  private int tempDice1 = 0;
  private int tempDice2 = 0;
  private int tempDice3 = 0;
  private int tempDice4 = 0;
  private int tempDice5 = 0;
  // whether to roll dice or not(keep or not)
  private boolean rollDice1 = true;
  private boolean rollDice2 = true;
  private boolean rollDice3 = true;
  private boolean rollDice4 = true;
  private boolean rollDice5 = true;
  // what categories have been claimed
  private boolean onesClaimed = false;
  private boolean twosClaimed = false;
  private boolean threesClaimed = false;
  private boolean foursClaimed = false;
  private boolean fivesClaimed = false;
  private boolean sixesClaimed = false;
  private boolean threeOfAKindClaimed = false;
  private boolean fourOfAKindClaimed = false;
  private boolean yahtzeeClaimed = false;
  private boolean fullHouseClaimed = false;
  private boolean smallStraightClaimed = false;
  private boolean largeStraightClaimed = false;
  private boolean chanceClaimed = false;
  // the total score of the player
  private int totalScore = 0;

  ArrayList<Die> diceRolls = new ArrayList<Die>();


  public void resetKeeps(){
    for (int i = 0; i < diceRolls.size(); i++) {
      diceRolls.get(i).setKeep(false);
    }
  }

  // adds dice to diceRolls
  public void addDice() {
    while (diceRolls.size() < 5) {
      diceRolls.add(new Die(0, false));
    }
  }

  // roll method
  public void rollDice() {
    for (int i = 0; i < diceRolls.size(); i++) {
      diceRolls.get(i).roll();
    }

  }
  //test
  public void printTempDice() {
    System.out.println(tempDice1);
    System.out.println(tempDice2);
    System.out.println(tempDice3);
    System.out.println(tempDice4);
    System.out.println(tempDice5);
  }
  //prints out the rolls
  public void printRolls() {
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    String x = "";

    for (int i = 0; i < diceRolls.size(); i++) {
      x += diceRolls.get(i).getValue() + " ";
    }
    System.out.println(x);
  }
  //runs the game
  public void runGame() {
    addDice();
    printClaimInstructions();
    while (rollsLeft > -1) {
      rollDice();
      printRolls();
      keepDice();
      askPlayer();
    }

    System.out.println("game over, out of rolls");
  }
  public boolean claimable() {
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    if (((threeOfAKindClaimed == false) && (Threeofakind() == true))
        || ((fourOfAKindClaimed == false) && (Fourofakind() == true))
        || ((yahtzeeClaimed == false) && (yahtzee() == true)) || ((fullHouseClaimed == false) && (FullHouse() == true))
        || ((smallStraightClaimed == false) && (Smallstraight() == true)
            || ((largeStraightClaimed == false) && (Largestraight() == true)))) {
      return true;
    } else {
      return false;
    }
  }
  //prints out the instructions to claim certain categories
  public void printClaimInstructions() {
    System.out.println("Enter a number 1-6 to claim Numbers");
    System.out.println("Enter 7 to claim Three of a Kind");
    System.out.println("Enter 8 to claim Four of a Kind");
    System.out.println("Enter 9 to claim Yahtzee");
    System.out.println("Enter s to claim Small Straight");
    System.out.println("Enter l to claim Large Straight");
    System.out.println("Enter f to claim Full House");

  }

  // asks the player what dice they want to keep
  public void keepDice() {
    Console console = System.console();

    String inputString = console.readLine("Enter the dice you want to keep (0 to keep 1 to roll): ");
    String x = "";
    if (inputString.length() < 5) {
      System.out.println("invalid input");
    } else {
      for (int i = 0; i < diceRolls.size(); i++) {
        diceRolls.get(i).setKeep(inputString.substring(i, i + 1).equals("0"));
      }
      for (int y = 0; y < diceRolls.size(); y++) {
        if (diceRolls.get(y).getKeep()) {
          x += diceRolls.get(y).getValue() + " ";
        }
        else{
          x += "_ ";
        }
      }
      System.out.println("The dice you want to keep: " + x);
    }
  }
  //asks player whether they want to roll or claim categories
  public void askPlayer() {
    Console console = System.console();
    String inputString = console.readLine("Enter 1 to roll Enter 0 to claim categories: ");
    if (rollsLeft == 0) {
      System.out.println("You are out of rolls");
    }
    if (inputString.equals("1")) {
      Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
      rollDice();
    }
    if (inputString.equals("0")) {
      askClaims();
    }
  }
//checks whether there is a three of a kind
  public boolean Threeofakind() {
    int x = 0;
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    while (x < 3) {
      if ((diceRolls.get(x).getValue() == diceRolls.get(x + 1).getValue()) && (diceRolls.get(x).getValue() == diceRolls.get(x + 2).getValue())) {
        return true;
      }
      x++;
    }
    return false;

  }
//claims three of a kind
  public void claimThreeOfAKind() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    }
    totalScore += x;
    rollsLeft = 4;
    threeOfAKindClaimed = true;
    rollDice();
  }
//checks if there is a four of a kind
  public boolean Fourofakind() {
    int x = 0;
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    while (x != diceRolls.size() - 4) {
      if ((diceRolls.get(x).getValue() == diceRolls.get(x + 1).getValue()) && (diceRolls.get(x).getValue() == diceRolls.get(x + 2).getValue())
          && (diceRolls.get(x).getValue() == diceRolls.get(x + 3).getValue())) {
        return true;
      }
      x++;
    }

    return false;

  }
//claims four of a kind
  public void claimFourOfAKind() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      x += diceRolls.get(i).getValue();
    }
    totalScore += x;
    rollsLeft = 4;
    fourOfAKindClaimed = true;
    rollDice();
  }
//checks if there is a yahtzee
  public boolean yahtzee() {

    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));

    if ((diceRolls.get(0).getValue() == diceRolls.get(0 + 1).getValue()) && (diceRolls.get(0).getValue() == diceRolls.get(0 + 2).getValue())
        && (diceRolls.get(0).getValue() == diceRolls.get(3).getValue()) && diceRolls.get(0).getValue() == diceRolls.get(4).getValue()) {
      return true;
    }

    return false;

  }
//claims the yahtzee
  public void claimYahtzee() {
    yahtzeeClaimed = true;
    totalScore += 50;
    rollsLeft = 4;
    rollDice();
  }
//checks if there is a full house
  public boolean FullHouse() {
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));

    if ((diceRolls.get(0).getValue() == diceRolls.get(1).getValue()) && (diceRolls.get(0).getValue() == diceRolls.get(2).getValue())
        && (diceRolls.get(3).getValue() == diceRolls.get(4).getValue()) && (diceRolls.get(2).getValue() != diceRolls.get(3).getValue())
        || (diceRolls.get(0).getValue() == diceRolls.get(1).getValue()) && (diceRolls.get(2).getValue() == diceRolls.get(3).getValue())
            && (diceRolls.get(3).getValue() == diceRolls.get(4).getValue()) && (diceRolls.get(0).getValue() != diceRolls.get(4).getValue())) {
      return true;
    }
    return false;
  }
//checks if there is a large straight
  public boolean Largestraight() {
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    int x = 0;
    while (x != 2) {
      if (diceRolls.get(x).getValue() == diceRolls.get(x + 1).getValue() - 1
          && diceRolls.get(x).getValue() == diceRolls.get(x + 2).getValue() - 2
          && diceRolls.get(x).getValue() == diceRolls.get(x + 3).getValue() - 3
          && diceRolls.get(x).getValue() == diceRolls.get(x + 4).getValue() - 4) {
        return true;
      }
      x++;
    }
    return false;
  }

  public boolean Smallstraight() {
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    int x = 0;
    while (x < 2) {
      if ((diceRolls.get(x).getValue() + 1 == diceRolls.get(x + 1).getValue())
          && (diceRolls.get(x).getValue() + 2 == diceRolls.get(x + 2).getValue())
          && (diceRolls.get(x).getValue() + 3 == diceRolls.get(x + 3).getValue())) {
        return true;
      }
      x++;
    }
    return false;
  }

  public void claimSmallStraight() {
    smallStraightClaimed = true;
    totalScore += 30;
    rollsLeft = 3;
    rollDice();
  }

  public void claimLargeStraight() {
    largeStraightClaimed = true;
    totalScore += 40;
    rollsLeft = 4;
    rollDice();
  }

  public void printScore() {
    System.out.println("Your score is : " + totalScore);
  }

  public boolean Ones() {
    for (int i = 0; i < diceRolls.size(); i++) {
      int x = diceRolls.get(i).getValue();
      if (x == 1) {
        return true;
      }
    }
    return false;
  }

  public void claimOnes() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      if (diceRolls.get(i).getValue() == 1) {
        x++;
      }
    }
    onesClaimed = true;
    totalScore += x;
    rollsLeft = 4;
    rollDice();
  }

  public boolean Twos() {
    for (int i = 0; i < diceRolls.size(); i++) {
      int x = diceRolls.get(i).getValue();
      if (x == 2) {
        return true;
      }
    }
    return false;
  }

  public void claimTwos() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      if (diceRolls.get(i).getValue() == 2) {
        x += 2;
      }
    }
    twosClaimed = true;
    totalScore += x;
    rollsLeft = 4;
    rollDice();
  }

  public void ClaimThrees() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      if (diceRolls.get(i).getValue() == 3) {
        x += 3;
      }
    }
    threesClaimed = true;
    totalScore += x;
    rollsLeft = 4;
    rollDice();
  }

  public boolean Threes() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      x = diceRolls.get(i).getValue();
      if (x == 3) {
        return true;
      }
    }
    return false;
  }

  public void claimFours() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      if (diceRolls.get(i).getValue() == 4) {
        x += 4;
      }

    }
    foursClaimed = true;
    totalScore += x;
    rollsLeft = 4;
    rollDice();
  }

  public boolean Fours() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      x = diceRolls.get(i).getValue();
      if (x == 4) {
        return true;
      }
    }
    return false;

  }

  public boolean Fives() {
    for (int i = 0; i < diceRolls.size(); i++) {
      int x = diceRolls.get(i).getValue();
      if (x == 5) {
        return true;
      }
    }
    return false;
  }

  public void claimFives() {
    int x = -5;
    for (int i = 0; i < diceRolls.size(); i++) {
      if (diceRolls.get(i).getValue() == 5) {
        x += 5;
      }

    }
    fivesClaimed = true;
    totalScore += x;
    rollsLeft = 4;
    rollDice();
  }

  public boolean Six() {
    for (int i = 0; i < diceRolls.size(); i++) {
      int x = diceRolls.get(i).getValue();
      if (x == 6) {
        return true;
      }
    }
    return false;
  }

  public void claimSixes() {
    int x = -6;
    for (int i = 0; i < diceRolls.size(); i++) {
      if (diceRolls.get(i).getValue() == 6) {
        x += 6;
      }
    }

    sixesClaimed = true;
    totalScore += x;
    rollsLeft = 4;
    rollDice();
  }

  public void askClaims() {
    Console console = System.console();
    String inputString = console.readLine("Enter what category to claim: ");
    System.out.println("You entered: " + inputString);
    if (inputString.equals("1")) {
      if (Ones()) {
        if (onesClaimed) {
          System.out.println("You have already claimed Ones");
          askClaims();
        } else {
          claimOnes();
        }
      } else {
        System.out.println("You have no Ones");
        askClaims();
      }
    } else if (inputString.equals("2")) {
      if (Twos()) {
        if (twosClaimed) {
          System.out.println("You have already claimed Twos");
          askClaims();
        } else {
          claimTwos();
        }
      } else {
        System.out.println("You have no Twos");
        askClaims();
      }
    } else if (inputString.equals("3")) {
      if (Threes()) {
        if (threesClaimed) {
          System.out.println("You have already claimed Threes");
          askClaims();
        } else {
          ClaimThrees();
        }
      } else {
        System.out.println("You have no Threes");
        askClaims();
      }
    } else if (inputString.equals("4")) {
      if (Fours()) {
        if (foursClaimed) {
          System.out.println("You have already claimed Fours");
          askClaims();
        } else {
          claimFours();
        }
      } else {
        System.out.println("You have no Fours");
        askClaims();
      }
    } else if (inputString.equals("5")) {
      if (Fives()) {
        if (fivesClaimed) {
          System.out.println("You have already claimed Fives");
          askClaims();

        } else {
          claimFives();
        }
      } else {
        System.out.println("You have no Fives");
        askClaims();
      }
    } else if (inputString.equals("6")) {
      if (Six()) {
        if (sixesClaimed) {
          System.out.println("You have already claimed Sixes");
          askClaims();
        } else {
          claimSixes();
        }
      } else {
        System.out.println("You have no Sixes");
        askClaims();
      }
    } else if (inputString.equals("7")) {
      if (Threeofakind()) {
        if (threeOfAKindClaimed) {
          System.out.println("You have already claimed Three of a Kind");
          askClaims();
        } else {
          claimThreeOfAKind();
        }
      } else {
        System.out.println("You don't have a Three of a Kind");
        askClaims();
      }
    } else if (inputString.equals("8")) {
      if (Fourofakind()) {
        if (fourOfAKindClaimed) {
          System.out.println("You have already claimed Four of a Kind");
          askClaims();
        } else {
          claimFourOfAKind();
        }
      } else {
        System.out.println("You don't have a Four of a Kind");
        askClaims();
      }
    } else if (inputString.equals("9")) {
      if (yahtzee()) {
        if (yahtzeeClaimed) {
          totalScore += 100;
          rollDice();
        } else {
          claimYahtzee();
        }
      }
      System.out.println("You don't have a Yahtzee");
      askClaims();
    } else if (inputString.equals("s")) {
      if (Smallstraight()) {
        if (smallStraightClaimed) {
          System.out.println("You have already claimed Small Straight");
        } else {
          claimSmallStraight();
        }
      } else {
        System.out.println("You don't have a Small Straight");
        askClaims();
      }
    } else if (inputString.equals("l")) {
      if (Largestraight()) {
        if (largeStraightClaimed) {
          System.out.println("You have already claimed Large Straight");
          askClaims();
        } else {
          claimLargeStraight();
        }
      } else {
        System.out.println("You don't have a large straight");
        askClaims();
      }
    } else if (inputString.equals("f")) {
      if (FullHouse() == true) {
        if (fullHouseClaimed) {
          System.out.println("You have already claimed Full House");
          askClaims();
        } else {
          totalScore += 25;
          fullHouseClaimed = true;
          rollDice();
        }
      } else {
        System.out.println("You do not have a full house");
        askClaims();
      }
    }
    printScore();
    rollsLeft = 4;
    resetKeeps();
    rollDice();
  }
}
