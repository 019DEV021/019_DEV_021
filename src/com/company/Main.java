package com.company;
import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        newBowl();
    }

    public static void newBowl() {

        Scanner input = new Scanner(System.in);

        //DECLARED VARIABLES
        int[] BowlRoll1 = new int[14];  //First ball result count
        int[] BowlRoll2 = new int[14];  //Second ball result count
        int[] FrameScore = new int[14]; //First + Second ball result count
        int[] RunTotal = new int[14];  //Total result count'
        int FrameCount=10; //Number of Frames
        int bottle = 10; // Number of Bottles
        int balBowl = 0;
        int count = 0;
        int zero=0;
        int[] tenbowl = new int[2];
        String name;

        //CONSTANT VARIABLES
        char X = 'X';
        char spare = '/';
        char miss ='-';

        System.out.println("\tWelcome to Bowling with BNPP!");
        System.out.println("\tEnter your Score and it should NOT be greater than 10 ");
        System.out.println("____________________________________________");
        System.out.print("\t Enter your name :- " );
        name=input.next();

        //LOOP FOR THE 10 FRAMES AND EACH FRAME HAS 2 CHANCE.
        for (int i = 1; i <= FrameCount; ) {
            if (balBowl == 0) {
                // FRAME COUNT
                System.out.printf("%n*** Frame %d ***", i);
                System.out.print("\nEnter result first  bowl: ");

                try {
                    BowlRoll1[i] = Integer.parseInt(input.next());
                } catch (NumberFormatException e) {
                    System.out.println("String Not allowed need Integer value...!!! ");
                    BowlRoll1[i] = 0;
                    FrameScore[i] = BowlRoll1[i];
                    System.out.println("Result First bowl: " + FrameScore[i]);
                }
                if (BowlRoll1[i] > bottle) {
                        count++;
                }
                else {
                        count = 0;
                }
                if (count == 2) {
                    System.out.println("You Entered Invalid Count for First Bowl... ");
                    BowlRoll1[i] = 0;
                    FrameScore[i] = BowlRoll1[i];
                    System.out.println("Result First bowl: " + FrameScore[i]);
                    if (i<10){
                        i++;
                        continue;
                    }

                }
            }
            if (BowlRoll1[i] <= bottle) {
                if (BowlRoll1[i] == bottle) {
                    FrameScore[i] = BowlRoll1[i];
                    if (BowlRoll1[i] == bottle) {
                        balBowl = 0;
                        if (i<10){
                            i++;
                            continue;
                        }
                    } else {
                        balBowl = 1;
                    }

                } else {
                    System.out.print("Enter result second bowl: ");
                    try {
                        BowlRoll2[i] = Integer.parseInt(input.next());
                    } catch (NumberFormatException e) {
                        System.out.println("String Not allowed need Integer value...!!!");
                        BowlRoll2[i] = 0;
                        FrameScore[i] = BowlRoll1[i];
                        System.out.println("Result Second bowl: " + FrameScore[i]);
                    }
                    if (bottle - BowlRoll1[i] >= BowlRoll2[i]) {
                        FrameScore[i] = BowlRoll1[i] + BowlRoll2[i];
                        balBowl = 0;

                    } else {
                        System.out.println("You Entered Invalid Count For Second Bowl... ");
                        BowlRoll2[i] = 0;
                        FrameScore[i] = BowlRoll2[i];
                        System.out.println("Result second bowl: " + FrameScore[i]);
                    }
                    if (i<FrameCount){
                        i++;
                        continue;
                    }
                }

            } else {
                System.out.print("Invalid Bottle Count");
                System.out.print("\nEnter result first  bowl: ");
                try {
                    BowlRoll1[i] = Integer.parseInt(input.next());
                } catch (NumberFormatException e) {
                    System.out.println("String Not allowed need Integer value...!!! ");
                    BowlRoll1[i] = 0;
                    FrameScore[i] = BowlRoll1[i];
                    System.out.println("Result First bowl: " + FrameScore[i]);
                }

                if (BowlRoll1[i] > bottle) {
                    BowlRoll1[i] = 0;
                }
                count=0;
                if (i<FrameCount){
                    i++;
                    continue;
                }
            }

            //CONDITION FOR THE LAST THAT IS 10 FRAME IF IT SCORES THE SPARE OR STRIKE
            if (i == 10)
            {
                if ((BowlRoll1[i] + BowlRoll2[i] == bottle) || (BowlRoll1[i] == bottle) || (BowlRoll2[i] == bottle))
                {
                    System.out.print("\nCongrats you score 10 points in last frame");
                    System.out.print("\nYou got 2 extra rolls..!!");
                    System.out.print("\nEnter result first bowl: ");
                    //tenbowl[0]= input.nextInt();
                    try {
                        tenbowl[0] = Integer.parseInt(input.next());
                        if (tenbowl[0]>10)
                            tenbowl[0]= 0;
                    } catch (NumberFormatException e) {
                        System.out.println("String Not allowed need Integer value...!!!");
                        System.out.println("Result First bowl: " + tenbowl[0]);
                    }

                    System.out.print("Enter result second bowl: ");
                    try {
                        tenbowl[1] = Integer.parseInt(input.next());
                        if (tenbowl[1]>10)
                            tenbowl[1]= 0;
                    } catch (NumberFormatException e) {
                        System.out.println("String Not allowed need Integer value...!!!");
                        System.out.println("Result Second bowl: " + tenbowl[1]);
                    }

                    FrameScore[i] = BowlRoll1[i] + BowlRoll2[i] + tenbowl[0]+tenbowl[1];
                }
                RunTotal[i] += FrameScore[i];
                i++;
                continue;
            }

            RunTotal[i] += FrameScore[i];
        }

        System.out.print("\n*** SCORECARD ***");
        System.out.print("\n_____________________________________________________________________________________");
        System.out.print("\nHello "+name+" Your Score is here:- ");
        System.out.print("\n_____________________________________________________________________________________");
        System.out.printf("%n%-15s", "Frame:");
        for (int i = 1; i <= 10; i++)
            System.out.printf("%-7d", i);
        System.out.print("\n_____________________________________________________________________________________");
        System.out.printf("%n%-15s", "Result:");

        for (int i = 1; i <= FrameCount; i++) {
            // Strike Logic
            if ((BowlRoll1[i] == bottle)||(BowlRoll2[i] == bottle))
                {
                    System.out.printf("%-7c", X);
                    RunTotal[i] = BowlRoll1[i]  + BowlRoll2[i] + BowlRoll1[i+1] + BowlRoll2[i+1]; //+ roll1[i+2] + roll2[i+2] ;
                 }
                 //Miss Logic
            else if (BowlRoll1[i] + BowlRoll2[i] == 0)
                {
                    RunTotal[i]=0;
                    System.out.printf("%-7c",miss);
                }
                //Spare Logic
            else if (BowlRoll1[i] + BowlRoll2[i] == bottle)
                {
                    System.out.printf("%-7c", spare);
                    RunTotal[i] =BowlRoll1[i] + BowlRoll2[i]+ BowlRoll1[i+1] ;//+ roll2[i+1];
                }

            else {
                RunTotal[i] = BowlRoll1[i] + BowlRoll2[i];
                if ((BowlRoll1[i] == 0)&& (BowlRoll2[i] != 0)) {
                    System.out.printf("%-1c%-6c", spare,  RunTotal[i]);
                }
                else if ((BowlRoll2[i] == 0)&& (BowlRoll1[i] != 0))
                    System.out.printf("%-1d%-6c", BowlRoll1[i], spare);
                else
                    System.out.printf("%-1d%-6c", BowlRoll1[i], BowlRoll2[i]);
                }
        }
        //SCORE BOARD
        System.out.print("\n_____________________________________________________________________________________");
        System.out.printf("%n%-15s", "Frame Score:");
        for (int i = 1; i <= FrameCount; i++) {
            System.out.printf("%-7d", FrameScore[i]);
        }
        System.out.print("\n_____________________________________________________________________________________");
        System.out.printf("%n%-15s", "Total Score:");
        count=0;
        for (int i = 1; i <= FrameCount; i++) {
            count+=RunTotal[i];
        }
        System.out.printf("%-7d", count);
        System.out.print("\n_____________________________________________________________________________________");
    }

}