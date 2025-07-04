import core.ExerciseDate;
import core.ExerciseThread;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static ExerciseDate exerciseDate = new ExerciseDate();
    static Scanner inputReader = new Scanner(System.in);


    public static void main(String[] args) {
        int exit = 0;
        do {
            System.out.println("Welcome to the Program.");
            try {
                System.out.println("1.- Calculate days between two dates.");
                System.out.println("2.- Thread Exercise.");
                System.out.print("\n\nTo continue, enter an option: ");
                int option = inputReader.nextInt();
                Run(option);
                System.out.print("\n\nEnter 0 to exit the program: ");
                exit = inputReader.nextInt();
            } catch (Exception e){
                System.out.println("Enter a correct value or option.");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                exit = 1;
            }
        } while (exit != 0);
    }

    public static void Run(int option){
        Scanner auxInputReader = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        switch (option){
            case 1:
                try {
                    System.out.println("\nEnter the start date in format dd-MM-yyyy.");
                    String inputStart = auxInputReader.nextLine();
                    System.out.println("\nEnter the end date in format dd-MM-yyyy.");
                    String inputEnd = auxInputReader.nextLine();
                    long days = exerciseDate.calculateDays(formatter.parse(inputStart),
                            formatter.parse(inputEnd));
                    System.out.println("The difference in days is: " + days + " days.");
                    System.out.println("¿Do you want to calculate stages? y/n");
                    String inputStages = auxInputReader.nextLine();
                    if (inputStages.equals("y") || inputStages.equals("yes")){
                        exerciseDate.calculateStages(formatter.parse(inputStart));
                    }
                } catch (Exception e){
                    System.out.println("An error has occurred. Please check your input.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                break;

            case 2:
                try {
                    System.out.println("1.- Executes 6 threads to form the sentence.");
                    System.out.println("2.- Executes 6 threads to form the sentence including the thread name.");
                    System.out.println("3.- Executes 6 threads to form the sentence with sleep.");
                    System.out.print("\n\nTo continue, enter an option: ");
                    int aux_option = auxInputReader.nextInt();
                    ExerciseThread exerciseThread = new ExerciseThread();
                    switch (aux_option){
                        case 1:
                            exerciseThread.executePoolTread();
                            break;
                        case 2:
                            exerciseThread.executePoolTreadDetail();
                            break;
                        case 3:
                            exerciseThread.executeTreadSleep();
                            break;
                    }

                } catch (Exception e){
                    System.out.println("An error has occurred. Please check your input.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                break;
        }
    }
}