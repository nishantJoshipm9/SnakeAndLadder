package com.nishant.snakandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardServiceImplementation {

    private  List<Box> board=null;
    private int capacity;
    private DiceService diceService=new DiceServiceImplementation();
    private LadderService ladderService=new LadderServiceImplementation();
    private SnakeService snakeService=new SnakeServiceImplementation();
    private PlayerService playerService=new PlayerServiceImplementation();
    private List<Player> players=null;
    public static  Box START=null;
    public static  Box END=null;


    private void startGame(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter board capacity - ");
        this.capacity = Integer.parseInt(sc.nextLine());
        board=new ArrayList<>(capacity);
        START=new Box(0);
        END=new Box(capacity);


        System.out.println("Enter Total number of snakes - ");
        int snakesCount=Integer.parseInt(sc.nextLine());
        int i = 1;
        while (i<=snakesCount){
            System.out.println("Enter Starting value of snake "+i);
            int start=Integer.parseInt(sc.nextLine());
            System.out.println("Enter Ending value of snake "+i);
            int end=Integer.parseInt(sc.nextLine());
            snakeService.addSnake(new Box(start),new Box(end));
            i++;
        }


        System.out.println("Enter Total number of ladders - ");
        int laddersCount=Integer.parseInt(sc.nextLine());
         i = 1;
        while (i<=laddersCount){
            System.out.println("Enter Starting and Ending value of ladder "+i);
            int start=Integer.parseInt(sc.nextLine());
            System.out.println("Enter Ending value of ladder "+i);
            int end=Integer.parseInt(sc.nextLine());
            ladderService.addLadder(new Box(start),new Box(end));
            i++;
        }


        System.out.println("Enter Total number of Players - ");
        int playersCount=Integer.parseInt(sc.nextLine());
        i = 1;
        while (i<=playersCount){
            System.out.println("Enter Name  of Player "+i);
            String name=(sc.nextLine());
            playerService.addPlayer(new Player(name));
            i++;
        }

        players =new ArrayList<>(playerService.getAllPlayers());
    }

    private int roll(){
        int totalVal=diceService.generateRandomNumber();
        while(totalVal%6==0){
            System.out.print("Dice roll - got 6 so rolling again\t");
            totalVal=diceService.generateRandomNumberAgain(totalVal);
        }
        System.out.println("dice roll - got "+totalVal%6+"");
        return totalVal;
    }


    public void play(){

        startGame();
        Player currentPlayer=players.get(0);
        while(true){

            int diceValue=roll();

                Box nextMove=new Box(diceValue);

                if(ladderService.checkIfLadderExists(nextMove)){
                    nextMove=ladderService.reachTop(nextMove);
                }
                else if(snakeService.checkIfSnakeExist(nextMove)){
                    nextMove= snakeService.reachBottom(nextMove);
                }

                playerService.move(currentPlayer,nextMove);

                print(currentPlayer,diceValue);




            if(isWinner(currentPlayer)){
                endGame(currentPlayer);
                return;
            }

            currentPlayer=nextPlayer(currentPlayer);

        }
    }

    private Player nextPlayer(Player player){

        return players.get((players.indexOf(player)+1)%players.size());



    }


    private boolean isWinner(Player player){
        return END.equals(playerService.currentState(player));
    }

    private void endGame(Player player){
        System.out.println(player.getName()+ ","+player.getId()+" is the winner");
    }


    private void print(Player player, int diceVal){
        System.out.println(player.getName()+" played "+diceVal+", so moving to "+playerService.currentState(player).getVal());
    }
}
