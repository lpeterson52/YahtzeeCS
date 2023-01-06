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



//roll method 
    public void roll(){
      if(diceRolls.size() == 5){
        diceRolls.remove(4);
        diceRolls.remove(3);
        diceRolls.remove(2);
        diceRolls.remove(1);
        diceRolls.remove(0);
      }
      if(rollDice1){
        Dice1 = (int)(Math.random()*6) + 1; 
      }
      if(rollDice2==true){
        Dice2 = (int)(Math.random()*6) + 1;
      }
      if(rollDice3==true){
        Dice3 = (int)(Math.random()*6)+1;
      }
      if(rollDice4){
        Dice4 = (int)(Math.random()*6)+1;
      }
      if(rollDice5){
        Dice5 = (int)(Math.random() * 6 )+ 1;
      }
        diceRolls.add(Dice1);
        diceRolls.add(Dice2);
        diceRolls.add(Dice3);
        diceRolls.add(Dice4);
        diceRolls.add(Dice5);
  }


  public void printRolls(){
    for(int i = 0; i < diceRolls.size(); i++){
      System.out.println(diceRolls.get(i));
    }
  }



  public void runGame(){
    Console console = System.console();

    while ( lives != 0){
      if(totalScore == )
    while(lives != 0){
    roll();
    System.out.println(Dice1 +  Dice2 + Dice3 +  Dice4 + Dice5);
        keepDice();
    askPlayer();
    }
    
    
    }
  }
  public void askClaims(){
    Console console = System.console();
    String inputString = console.readLine("Enter what category to claim");
    if(inputString == "1" ){
      if(Ones()){
        if(onesClaimed){
          System.out.println("You have already claimed Ones");
        }
        else{
          claimOnes();
        }
      }

      if(Twos()){
        claimTwos();
        
      }      else{
        System.out.println("You have no Ones");
      }
    }
    else if(inputString == "2"){
      if(Twos()){
        if(twosClaimed){
          System.out.println("You have already claimed Twos");
        }
        else{
          claimTwos();
        }
      }
      else{
        System.out.println("You have no Twos");
      }
    }
    else if(inputString == "3"){
      if(Threes()){
        if(threesClaimed){
          System.out.println("You have already claimed Threes");
        }
        else{
          ClaimThrees();
        }
      }
      else{
        System.out.println("You have no Threes");
      }
    }
    else if(inputString == "4"){
      if(Fours()){
        if(foursClaimed){
          System.out.println("You have already claimed Fours");
        }
        else{
          claimFours();
        }
      }
    }
    else if(inputString == "5"){
      if(Fives()){
        if(fivesClaimed){
          System.out.println("You have already claimed Fives");

        }
        else{
          claimFives();
        }
      }
    }
    else if(inputString == "6"){
      if(Six()){
        if(sixesClaimed){
          System.out.println("You have already claimed Sixes");
        }
        else{
          claimSixes();
        }
      }
    }
    else if(inputString == "7"){
      if(Threeofakind()){
        if(threeOfAKindClaimed){
          System.out.println("You have already claimed Three of a Kind");
        }
        else{
          claimThreeOfAKind();
        }
      }
    }
  }


  //asks the player what dice they want to keep
  public void keepDice(){
  Console console = System.console();

  String inputString = console.readLine("Enter the dice you want to keep (0 to keep 1 to roll): ");

  System.out.println("The dice you want to keep: " + inputString);
  rollDice1 = inputString.substring(0,1).equals("1");
  rollDice2 = inputString.substring(1,2).equals("1");
  rollDice3 = inputString.substring(2,3).equals("1");
  rollDice4 = inputString.substring(3,4).equals("1");
  rollDice5 = inputString.substring(4,5).equals("1");
  }

  
  public void askPlayer(){
    Console console = System.console();
    String inputString = console.readLine("Enter 1 to roll Enter 0 to not roll");
    if (inputString.equals("1")){
      Collections.sort(diceRolls);
      roll();
    }
    if (inputString.equals("0")){
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


  
  public boolean Threeofakind(){
    int x = 0;
    Collections.sort(diceRolls);
    while (x != diceRolls.size()-3){
      if((diceRolls.get(x) == diceRolls.get(x + 1)) && (diceRolls.get(x+1) == diceRolls.get(x + 2))){
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
    rollsLeft = 3;
    threeOfAKindClaimed = true;
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
          }
public boolean yahtzee(){

  Collections.sort(diceRolls);

  if((diceRolls.get(0) == diceRolls.get(0 + 1)) && (diceRolls.get(0) == diceRolls.get(0 + 2)) && (diceRolls.get(0) == diceRolls.get(3)) && diceRolls.get(0) == diceRolls.get(4)){
    return true;
    }

            
              
  return false;
              
  }     
public boolean FullHouse(){
    Collections.sort(diceRolls);
  
    if(Threeofakind() == true && Threeofakindint() != Twoofakindint() && Twoofakind() == true) {
      return true;
    }
    return false;
}
    
  public boolean Largestraight(){
    Collections.sort(diceRolls);
    int x = 0;
    while ( x != 2){
    if(diceRolls.get(x)  == diceRolls.get(x + 1) -1 && diceRolls.get(x)  == diceRolls.get(x + 2)- 2 && diceRolls.get(x)  == diceRolls.get(x + 3)- 3 && diceRolls.get(x)  == diceRolls.get(x + 4)- 4 && diceRolls.get(x)  == diceRolls.get(x + 5)- 5){
      return true;
    }
    x++;
  }
  return false; 
}




public boolean Smallstraight(){
  Collections.sort(diceRolls);
  int x = 0;
  while(x<=3){
  if(diceRolls.get(x)+1 == diceRolls.get(x+1) && diceRolls.get(x) + 2 == diceRolls.get(x+2) && diceRolls.get(x) + 3 == diceRolls.get(x+3)){
    return true;
  }
  x++;
  }
  return false;
}

public void printScore(){
  System.out.println(totalScore);
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
}


public boolean Threes(){
  for(int i = 0; i < diceRolls.size(); i++){
    int x = diceRolls.get(i);
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
 
    threesClaimed = true;
    totalScore += x;
    rollsLeft = 3;
  }
}
public boolean Fours(){
  for(int i = 0; i < diceRolls.size(); i++){
    int x = diceRolls.get(i);
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
 
    threesClaimed = true;
    totalScore += x;
    rollsLeft = 3;
  }
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
 
    threesClaimed = true;
    totalScore += x;
    rollsLeft = 3;
  }
}

}
