import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class Yahtzee {
  public int rollsLeft = 3;
  public int lives = 2;
  private int tempDice1 = 0;
  private int tempDice2 = 0;
  private int tempDice3 = 0;
  private int tempDice4 = 0;
  private int tempDice5 = 0;
  // whether to roll dice or not(keep or not)
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

<<<<<<< HEAD
  public void resetKeeps() {
    for (int i = 0; i < diceRolls.size(); i++) {
      diceRolls.get(i).setKeep(false);
    }
  }
=======
  ArrayList<Integer> diceRolls = new ArrayList<>();
  ArrayList<Integer> displayDiceRolls = new ArrayList<>();




//roll method 
    public void roll(){

      Collections.sort(diceRolls);
      diceRolls.clear();
      if(diceRolls.size() == 5){

          diceRolls.remove(4);
          diceRolls.remove(3);
          diceRolls.remove(2);
          diceRolls.remove(1);
          diceRolls.remove(0);
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

  // roll method
  public void roll() {
    for (int i = 0; i < diceRolls.size(); i++) {
      if (diceRolls.get(i).getKeep() != true) {
        diceRolls.get(i).roll();
      }
<<<<<<< HEAD
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
  public void printRolls() {
    String x = "";
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    for (int i = 0; i < diceRolls.size(); i++) {
      x += diceRolls.get(i).getValue() + " ";
=======
      if(displayDiceRolls.size()==5){
        displayDiceRolls.remove(4);
        displayDiceRolls.remove(3);
        displayDiceRolls.remove(2);
        displayDiceRolls.remove(1);
        displayDiceRolls.remove(0);
      }
        Dice1 = (int)(Math.random()*6)+1; 
      
        Dice2 = (int)(Math.random()*6)+1;
      
        Dice3 = (int)(Math.random()*6)+1;
      
        Dice4 = (int)(Math.random()*6)+1;
      
        Dice5 = (int)(Math.random()*6)+1;

        if(tempDice1 != 0){
          diceRolls.add(tempDice1);
          displayDiceRolls.add(tempDice1);
        }
        else{
          diceRolls.add(Dice1);
          displayDiceRolls.add(Dice1);
        }
        if(tempDice2 != 0){
          diceRolls.add(tempDice2);
          displayDiceRolls.add(tempDice2);
        }
        else{
          diceRolls.add(Dice2);
          displayDiceRolls.add(Dice2);
        }
        if(tempDice3 != 0){
          diceRolls.add(tempDice3);
          displayDiceRolls.add(tempDice3);
        }
        else{
          diceRolls.add(Dice3);
          displayDiceRolls.add(Dice3);
        }
        if(tempDice4 != 0){
          diceRolls.add(tempDice4);
          displayDiceRolls.add(tempDice4);
        }
        else{
          diceRolls.add(Dice4);
          displayDiceRolls.add(Dice4);
        }
        if(tempDice5 != 0){
          diceRolls.add(tempDice5);
          displayDiceRolls.add(tempDice5);
        }
        else{
          diceRolls.add(Dice5);
          displayDiceRolls.add(Dice5);
        }
        rollsLeft--;
  }
  public void printTempDice(){
    System.out.println(tempDice1);
    System.out.println(tempDice2);
    System.out.println(tempDice3);
    System.out.println(tempDice4);
    System.out.println(tempDice5);
  }

  public void printRolls(){
    String x = "";
    
    for(int i = 0; i < displayDiceRolls.size(); i++){
      x += displayDiceRolls.get(i)  + " ";
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
    }
    System.out.println(x);
  }

<<<<<<< HEAD
  public void runGame() {
    roll();
    addDice();
    printClaimInstructions();
    while (rollsLeft > -1) {
      roll();
      printRolls();
      keepDice();
      askPlayer();
=======


  public void runGame(){
   // int lives = 1;
    diceRolls.add(Dice5);
    diceRolls.add(Dice5);
    diceRolls.add(Dice5);
    diceRolls.add(Dice5);
    diceRolls.add(Dice5);
    roll();
    printClaimInstructions();
    printRolls();
    keepDice();
     while (rollsLeft > -1){
      // if (!(rollsLeft <= -1)){
      //   lives--;
      // }
    askPlayer();
    if(rollsLeft < 0 && chanceClaimed == false){
      claimChance();
      }
  
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
    }

    System.out.println("game over, out of rolls");
<<<<<<< HEAD
  }

  public boolean claimable() {
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    if (((threeOfAKindClaimed == false) && (Threeofakind() == true))
        || ((fourOfAKindClaimed == false) && (Fourofakind() == true))
        || ((yahtzeeClaimed == false) && (yahtzee() == true)) || ((fullHouseClaimed == false) && (FullHouse() == true))
        || ((smallStraightClaimed == false) && (Smallstraight() == true)
            || ((largeStraightClaimed == false) && (Largestraight() == true)))) {
=======
    System.out.println("Your score was " + totalScore);
    }
  
//(claimable() == false) || 
  public boolean claimable(){
    Collections.sort(diceRolls);
    if (((threeOfAKindClaimed == false) &&  (Threeofakind() == true)) || ((fourOfAKindClaimed == false) &&  (Fourofakind() == true)) || ((yahtzeeClaimed == false) &&  (yahtzee() == true)) || ((fullHouseClaimed == false) &&  (FullHouse() == true)) || ((smallStraightClaimed == false) &&  (Smallstraight() == true) || ((largeStraightClaimed == false) &&  (Largestraight() == true)))){
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
      return true;
    } else {
      return false;
    }
  }

  // prints out the instructions to claim certain categories
  public void printClaimInstructions() {
    System.out.println("Enter a number 1-6 to claim Numbers");
    System.out.println("Enter 7 to claim Three of a Kind");
    System.out.println("Enter 8 to claim Four of a Kind");
    System.out.println("Enter 9 to claim Yahtzee");
    System.out.println("Enter s to claim Small Straight");
    System.out.println("Enter l to claim Large Straight");
    System.out.println("Enter f to claim Full House");
<<<<<<< HEAD
=======
    System.out.println("Enter c to claim Chance");
  }
  //asks the player what dice they want to keep
  public void keepDice(){
  Console console = System.console();
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

  }

  // asks the player what dice they want to keep
  public void keepDice() {
    Console console = System.console();
<<<<<<< HEAD

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
        } else {
          x += "_ ";
        }
      }
      System.out.println("The dice you want to keep: " + x);
    }
  }

  // asks player whether they want to roll or claim categories
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
=======
    System.out.println("You have " + rollsLeft + " rolls left");
    if(rollsLeft==0){
      System.out.println("You are out of rolls, claim categories");
    }
    String inputString = console.readLine("Enter 1 to Roll, Enter 0 to claim categories: ");
    if (inputString.equals("1")){
      Collections.sort(diceRolls);
      roll();
      printRolls();
      keepDice();
    }
    else if (inputString.equals("0")){
      askClaims();
    }
    else{
      System.out.println("Invalid input");
      askPlayer();
  } 
}
  public int Twoofakindint(){
    int x = 0;
    Collections.sort(diceRolls);
    while (x != diceRolls.size()-3){
      if((diceRolls.get(x) == diceRolls.get(x + 1))){
        return x;
        }
      x++;
        }     
  return 0 ;
    }
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

  // checks whether there is a three of a kind
  public boolean Threeofakind() {
    int x = 0;
<<<<<<< HEAD
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    while (x < 3) {
      if ((diceRolls.get(x).getValue() == diceRolls.get(x + 1).getValue())
          && (diceRolls.get(x).getValue() == diceRolls.get(x + 2).getValue())) {
=======
    Collections.sort(diceRolls);
    while (x != diceRolls.size()-2){
      if((diceRolls.get(x) == diceRolls.get(x + 1)&& diceRolls.get(x) == diceRolls.get(x+2))){
        return x;
        }
      x++;
        }     
  return 0 ;
}
  
  public boolean Threeofakind(){
    int x = 0;
    Collections.sort(diceRolls);
    while (x < 3){
      if((diceRolls.get(x) == diceRolls.get(x + 1)) && (diceRolls.get(x) == diceRolls.get(x + 2))){
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
        return true;
      }
      x++;
    }
    return false;

  }

  // claims three of a kind
  public void claimThreeOfAKind() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    }
    totalScore += x;
    threeOfAKindClaimed = true;
    rollDice();
  }

  // checks if there is a four of a kind
  public boolean Fourofakind() {
    int x = 0;
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    while (x != diceRolls.size() - 4) {
      if ((diceRolls.get(x).getValue() == diceRolls.get(x + 1).getValue())
          && (diceRolls.get(x).getValue() == diceRolls.get(x + 2).getValue())
          && (diceRolls.get(x).getValue() == diceRolls.get(x + 3).getValue())) {
        return true;
      }
      x++;
    }

    return false;

  }

  // claims four of a kind
  public void claimFourOfAKind() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      x += diceRolls.get(i).getValue();
    }
    totalScore += x;
<<<<<<< HEAD
    rollsLeft = 4;
    fourOfAKindClaimed = true;
    rollDice();
=======
    threeOfAKindClaimed = true;
    resetDice();
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
  }

  // checks if there is a yahtzee
  public boolean yahtzee() {

    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));

<<<<<<< HEAD
    if ((diceRolls.get(0).getValue() == diceRolls.get(0 + 1).getValue())
        && (diceRolls.get(0).getValue() == diceRolls.get(0 + 2).getValue())
        && (diceRolls.get(0).getValue() == diceRolls.get(3).getValue())
        && diceRolls.get(0).getValue() == diceRolls.get(4).getValue()) {
      return true;
=======
          public void claimFourOfAKind(){
            int x = 0;
            for(int i = 0; i < diceRolls.size(); i++){
              x += diceRolls.get(i);
            }
            totalScore += x;
            rollsLeft = 3;
            fourOfAKindClaimed = true;
            resetDice();
          }
public boolean yahtzee(){

  Collections.sort(diceRolls);

  if((diceRolls.get(0) == diceRolls.get(0 + 1)) && (diceRolls.get(0) == diceRolls.get(0 + 2)) && (diceRolls.get(0) == diceRolls.get(3)) && diceRolls.get(0) == diceRolls.get(4)){
    return true;
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
    }

    return false;

<<<<<<< HEAD
  }
=======
public void claimYahtzee(){
  yahtzeeClaimed =  true;
  totalScore += 50;
  rollsLeft = 3;
  resetDice();
}
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

  // claims the yahtzee
  public void claimYahtzee() {
    yahtzeeClaimed = true;
    totalScore += 50;
    rollsLeft = 4;
    rollDice();
  }

  // checks if there is a full house
  public boolean FullHouse() {
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));

    if ((diceRolls.get(0).getValue() == diceRolls.get(1).getValue())
        && (diceRolls.get(0).getValue() == diceRolls.get(2).getValue())
        && (diceRolls.get(3).getValue() == diceRolls.get(4).getValue())
        && (diceRolls.get(2).getValue() != diceRolls.get(3).getValue())
        || (diceRolls.get(0).getValue() == diceRolls.get(1).getValue())
            && (diceRolls.get(2).getValue() == diceRolls.get(3).getValue())
            && (diceRolls.get(3).getValue() == diceRolls.get(4).getValue())
            && (diceRolls.get(0).getValue() != diceRolls.get(4).getValue())) {
      return true;
    }
    return false;
  }

  // checks if there is a large straight
  public boolean Largestraight() {
    Collections.sort(diceRolls, Comparator.comparing(Die::getValue));
    int x = 0;
<<<<<<< HEAD
    while (x != 2) {
      if (diceRolls.get(x).getValue() == diceRolls.get(x + 1).getValue() - 1
          && diceRolls.get(x).getValue() == diceRolls.get(x + 2).getValue() - 2
          && diceRolls.get(x).getValue() == diceRolls.get(x + 3).getValue() - 3
          && diceRolls.get(x).getValue() == diceRolls.get(x + 4).getValue() - 4) {
        return true;
      }
=======
    while ( x  != 2){
    if(diceRolls.get(x)  == diceRolls.get(x + 1) -1 && diceRolls.get(x)  == diceRolls.get(x + 2)- 2 && diceRolls.get(x)  == diceRolls.get(x + 3)- 3 && diceRolls.get(x)  == diceRolls.get(x + 4)- 4){
      return true;
    }
    x++;
  }
  return false; 
}




public boolean Smallstraight(){
  Collections.sort(diceRolls);
  int x = 0;
  while(x<2){
  if((diceRolls.get(x)+1 == diceRolls.get(x+1)) && (diceRolls.get(x) + 2 == diceRolls.get(x+2)) && (diceRolls.get(x) + 3 == diceRolls.get(x+3))){
    return true;
  }
  x++;
  }
  return false;
}

public void claimSmallStraight(){
  smallStraightClaimed = true;
  totalScore += 30;
  rollsLeft = 3;
  resetDice();
}
public void claimLargeStraight(){
  largeStraightClaimed = true;
  totalScore += 40;
  rollsLeft = 3;
  resetDice();
}
public void printScore(){
  System.out.println("Your score is : " + totalScore);
}

public boolean Ones(){
  for(int i = 0; i < diceRolls.size(); i++){
    int x = diceRolls.get(i);
    if(x == 1){
      return true;
    }
  }
  return false;
}

public void claimOnes(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    if(diceRolls.get(i) == 1){
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
      x++;
    }
    return false;
  }
<<<<<<< HEAD
=======
  onesClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

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
<<<<<<< HEAD
=======
  twosClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

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
<<<<<<< HEAD
=======
  threesClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

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
<<<<<<< HEAD
=======
  return false;
}
public void claimFours(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    if(diceRolls.get(i) == 4){
      x+=4;
    }
 
  }
  foursClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}
public boolean Fours(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    x = diceRolls.get(i);
    if(x == 4){
      return true;
    }
  }
  return false;
  
}
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

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

<<<<<<< HEAD
  public boolean Threes() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      x = diceRolls.get(i).getValue();
      if (x == 3) {
        return true;
      }
=======
public void claimFives(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    if(diceRolls.get(i) == 5){
      x+=5;
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
    }
    return false;
  }
<<<<<<< HEAD
=======
  fivesClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb

  public void claimFours() {
    int x = 0;
    for (int i = 0; i < diceRolls.size(); i++) {
      if (diceRolls.get(i).getValue() == 4) {
        x += 4;
      }

<<<<<<< HEAD
=======
public void claimSixes(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    if(diceRolls.get(i) == 6){
      x+=6;
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
    }
    foursClaimed = true;
    totalScore += x;
    rollsLeft = 4;
    rollDice();
  }
<<<<<<< HEAD

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
=======
   
  sixesClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}

public void claimChance(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    x += diceRolls.get(i);
  }
  totalScore += x;
  rollsLeft = 3;
  chanceClaimed = true;
}
public void askClaims(){
  Console console = System.console();
  String inputString = console.readLine("Enter what category to claim: ");
  System.out.println("You entered: " + inputString);
  if(inputString.equals("1")){
    if(Ones()){
      if(onesClaimed){
        System.out.println("You have already claimed Ones");
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
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
<<<<<<< HEAD
    } else if (inputString.equals("9")) {
      if (yahtzee()) {
        if (yahtzeeClaimed) {
          totalScore += 100;
          rollDice();
        } else {
          claimYahtzee();
        }
=======
      else{
        claimLargeStraight();
        rollsLeft = 3;
>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
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
<<<<<<< HEAD
=======
  else if(inputString.equals("c")){
    if(chanceClaimed){
      System.out.println("You have already claimed Chance");
      askClaims();
    }
    else{
      claimChance();
    }
  }
  printScore();
  rollsLeft = 3;
}

>>>>>>> 39525ed846aecb0e6ddb26fde77201ae2ac2e2cb
}
