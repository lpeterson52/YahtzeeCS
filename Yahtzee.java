import java.io.*;
import java.util.ArrayList;

import java.util.*;
public class Yahtzee {
  public int rollsLeft = 3;
  public int lives = 2;
  private int Dice1 = 0; 
  private int Dice2 = 0;
  private int Dice3 = 0; 
  private int Dice4 = 0;
  private int Dice5 = 0; 
  private int tempDice1 = 0; 
  private int tempDice2 = 0; 
  private int tempDice3 = 0; 
  private int tempDice4 = 0; 
  private int tempDice5 = 0; 
  //whether to roll dice or not(keep or not)
  private boolean rollDice1 = true;
  private boolean rollDice2 = true;
  private boolean rollDice3 = true;
  private boolean rollDice4 = true;
  private boolean rollDice5 = true;
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
  private int totalScore = 0;


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

      }
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
    }
    System.out.println(x);
  }



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
  
    }
    
    System.out.println("game over, out of rolls");
    System.out.println("Your score was " + totalScore);
    }
  
//(claimable() == false) || 
  public boolean claimable(){
    Collections.sort(diceRolls);
    if (((threeOfAKindClaimed == false) &&  (Threeofakind() == true)) || ((fourOfAKindClaimed == false) &&  (Fourofakind() == true)) || ((yahtzeeClaimed == false) &&  (yahtzee() == true)) || ((fullHouseClaimed == false) &&  (FullHouse() == true)) || ((smallStraightClaimed == false) &&  (Smallstraight() == true) || ((largeStraightClaimed == false) &&  (Largestraight() == true)))){
      return true;
    }
    else{
      return false;
    }
  }
  

  public void printClaimInstructions(){
    System.out.println("Enter a number 1-6 to claim Numbers");
    System.out.println("Enter 7 to claim Three of a Kind");
    System.out.println("Enter 8 to claim Four of a Kind");
    System.out.println("Enter 9 to claim Yahtzee");
    System.out.println("Enter s to claim Small Straight");
    System.out.println("Enter l to claim Large Straight");
    System.out.println("Enter f to claim Full House");
    System.out.println("Enter c to claim Chance");
  }
  //asks the player what dice they want to keep
  public void keepDice(){
  Console console = System.console();

  String inputString = console.readLine("Enter the dice you want to keep (0 to keep 1 to roll): ");
  String x = "";
  tempDice1 = 0; 
  tempDice2 = 0; 
  tempDice3 = 0; 
  tempDice4 = 0; 
  tempDice5 = 0; 
  if(inputString.length()<5){
    System.out.println("invalid input");
  }
  else{
    rollDice1 = inputString.substring(0,1).equals("1");
    rollDice2 = inputString.substring(1,2).equals("1");
    rollDice3 = inputString.substring(2,3).equals("1");
    rollDice4 = inputString.substring(3,4).equals("1");
    rollDice5 = inputString.substring(4,5).equals("1"); 
    if(rollDice1 != true){
      x += diceRolls.get(0) + " ";
      tempDice1 = diceRolls.get(0);
    }
    else{
      x += "_ ";
    }
    if(rollDice2 != true){
      tempDice2 = diceRolls.get(1);
      x += diceRolls.get(1)+ " ";
    }
    else{
      x += "_ ";
    }
    
    if(rollDice3 != true){
      tempDice3 = diceRolls.get(2);
      x += diceRolls.get(2)+ " ";
    }
    else{
      x += "_ ";
    }
  
    if(rollDice4 != true){
      tempDice4 = diceRolls.get(3);
      x += diceRolls.get(3)+ " ";
    }
    else{
      x += "_ ";
    }
    if(rollDice5 != true){
      tempDice5 = diceRolls.get(4);
      x += diceRolls.get(4)+ " ";
    }
    else{
      x += "_ ";
    }
    System.out.println("The dice you want to keep: " + x);
  }
  }
  public void resetDice(){
    Dice1 = 0; 
    Dice2 = 0;
    Dice3 = 0; 
    Dice4 = 0;
    Dice5 = 0; 
    tempDice1 = 0; 
    tempDice2 = 0; 
    tempDice3 = 0; 
    tempDice4 = 0; 
    tempDice5 = 0; 
    diceRolls.remove(4);
    diceRolls.remove(3);
    diceRolls.remove(2);
    diceRolls.remove(1);
    diceRolls.remove(0);
    diceRolls.add(Dice5);
    diceRolls.add(Dice5);
    diceRolls.add(Dice5);
    diceRolls.add(Dice5);
    diceRolls.add(Dice5);
  }
  
  public void askPlayer(){
    Console console = System.console();
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

    public boolean Twoofakind(){
      int x = 0;
      Collections.sort(diceRolls);
      while (x != diceRolls.size()-3){
        if((diceRolls.get(x) == diceRolls.get(x + 1))){
         return true;
          }
        x++;
          }     
    return false ;
      }

public int Threeofakindint(){
    int x = 0;
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
        return true;
        }
      x++;
        }     
      return false;
      
    }

  public void claimThreeOfAKind(){
    int x = 0;
    for(int i = 0; i < diceRolls.size(); i++){
      x += diceRolls.get(i);
    }
    totalScore += x;
    threeOfAKindClaimed = true;
    resetDice();
  }

public boolean Fourofakind(){
        int x = 0;
        Collections.sort(diceRolls);
        while (x != diceRolls.size()-4){
          if((diceRolls.get(x) == diceRolls.get(x + 1)) && (diceRolls.get(x) == diceRolls.get(x + 2)) && (diceRolls.get(x) == diceRolls.get(x + 3))){
            return true;
          }
          x++;
        }
          
          return false;
          
          }     


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
    }

            
              
  return false;
              
  }   

public void claimYahtzee(){
  yahtzeeClaimed =  true;
  totalScore += 50;
  rollsLeft = 3;
  resetDice();
}

public boolean FullHouse(){
    Collections.sort(diceRolls);
    
    if((diceRolls.get(0) == diceRolls.get(1)) && (diceRolls.get(0) == diceRolls.get(2))&&(diceRolls.get(3) == diceRolls.get(4))&&(diceRolls.get(2)!=diceRolls.get(3)) || (diceRolls.get(0) == diceRolls.get(1)) && (diceRolls.get(2) == diceRolls.get(3))&&(diceRolls.get(3) == diceRolls.get(4))&&(diceRolls.get(0)!=diceRolls.get(4))) {
      return true;
    }
    return false;
}
    
  public boolean Largestraight(){
    Collections.sort(diceRolls);
    int x = 0;
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
      x++;
    }
  }
  onesClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}

public boolean Twos(){
  for(int i = 0; i < diceRolls.size(); i++){
    int x = diceRolls.get(i);
    if(x ==2){
      return true;
    }
  }
  return false;
}

public void claimTwos(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    if(diceRolls.get(i) == 2){
      x+=2;
    }
  }
  twosClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}



public void ClaimThrees(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    if(diceRolls.get(i) == 3){
      x+=3;
    }
  }
  threesClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}


public boolean Threes(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    x = diceRolls.get(i);
    if(x == 3){
      return true;
    }
  }
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

public boolean Fives(){
  for(int i = 0; i < diceRolls.size(); i++){
    int x = diceRolls.get(i);
    if(x == 5){
      return true;
    }
  }
  return false;
}

public void claimFives(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    if(diceRolls.get(i) == 5){
      x+=5;
    }
 
  }
  fivesClaimed = true;
  totalScore += x;
  rollsLeft = 3;
  resetDice();
}

public boolean Six(){
  for(int i = 0; i < diceRolls.size(); i++){
    int x = diceRolls.get(i);
    if(x == 6){
      return true;
    }
  }
  return false;
}

public void claimSixes(){
  int x = 0;
  for(int i = 0; i < diceRolls.size(); i++){
    if(diceRolls.get(i) == 6){
      x+=6;
    }
  }
   
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
        askClaims();
      }
      else{
        claimOnes();
      }
    }
    else{
      System.out.println("You have no Ones");
      askClaims();
    }
  }
  else if(inputString.equals("2")){
    if(Twos()){
      if(twosClaimed){
        System.out.println("You have already claimed Twos");
        askClaims();
      }
      else{
        claimTwos();
      }
    }
    else{
      System.out.println("You have no Twos");
      askClaims();
    }
  }
  else if(inputString.equals("3")){
    if(Threes()){
      if(threesClaimed){
        System.out.println("You have already claimed Threes");
        askClaims();
      }
      else{
        ClaimThrees();
      }
    }
    else{
      System.out.println("You have no Threes");
      askClaims();
    }
  }
  else if(inputString.equals("4")){
    if(Fours()){
      if(foursClaimed){
        System.out.println("You have already claimed Fours");
        askClaims();
      }
      else{
        claimFours();
      }
    }
    else{
      System.out.println("You have no Fours");
      askClaims();
    }
  }
  else if(inputString.equals("5")){
    if(Fives()){
      if(fivesClaimed){
        System.out.println("You have already claimed Fives");
        askClaims();

      }
      else{
        claimFives();
      }
    }
    else{
      System.out.println("You have no Fives");
      askClaims();
    }
  }
  else if(inputString.equals("6")){
    if(Six()){
      if(sixesClaimed){
        System.out.println("You have already claimed Sixes");
        askClaims();
      }
      else{
        claimSixes();
      }
    }
    else{
      System.out.println("You have no Sixes");
      askClaims();
    }
  }
  else if(inputString.equals("7")){
    if(Threeofakind()){
      if(threeOfAKindClaimed){
        System.out.println("You have already claimed Three of a Kind");
        askClaims();
      }
      else{
        claimThreeOfAKind();
      }
    }
    else{
      System.out.println("You don't have a Three of a Kind");
      askClaims();
    }
  }
  else if(inputString.equals("8")){
    if(Fourofakind()){
      if(fourOfAKindClaimed){
        System.out.println("You have already claimed Four of a Kind");
        askClaims();
      }
      else{
        claimFourOfAKind();
      }
    }
    else{
      System.out.println("You don't have a Four of a Kind");
      askClaims();
    }
  }
  else if(inputString.equals("9")){
    if(yahtzee()){
      if(yahtzeeClaimed){
        totalScore+=100;
        rollsLeft=4;
        resetDice();
      }
    else{
      claimYahtzee();
    }
    }
    System.out.println("You don't have a Yahtzee");
    askClaims();
  }
  else if(inputString.equals("s")){
    if(Smallstraight()){
      if(smallStraightClaimed){
        System.out.println("You have already claimed Small Straight");
      }
      else{
        claimSmallStraight();
      }
    }
    else{
      System.out.println("You don't have a Small Straight");
      askClaims();
    }
  }
  else if(inputString.equals("l")){
    if(Largestraight()){
      if(largeStraightClaimed){
        System.out.println("You have already claimed Large Straight");
        askClaims();
      }
      else{
        claimLargeStraight();
        rollsLeft = 3;
      }
    }
    else{
      System.out.println("You don't have a large straight");
      askClaims();
    }
  }
  else if(inputString.equals("f")){
    if(FullHouse()==true){
      if(fullHouseClaimed){
        System.out.println("You have already claimed Full House");
        askClaims();
      }
      else{
        totalScore += 25;
        fullHouseClaimed = true;
        rollsLeft =4;
        resetDice();
      }
    }
    else{
      System.out.println("You do not have a full house");
      askClaims();
    }
  }
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

}
