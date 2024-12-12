import java.util.Random; 
import java.util.Scanner;
import java.util.ArrayList;

public class Conversation {
    // attributes 
    // Number of rounds needed 
    public Integer rounds;  

/**
 * Constructor for the conversation 
 * @param arguments
 */
    public static void main(String[] arguments) {
        // input Scanner 
        Scanner input = new Scanner(System.in);
        System.out.print("How many rounds do you want? "); 
        int rounds = input.nextInt();
        input.nextLine();
        
        // Transcript Array List 
        ArrayList < String > transcript = new ArrayList<>();
        
        //Random Responses 
        String [] responses = {"Ok!", "Really!", "No Way!"};
        Random random = new Random (); 

        //Greeting 
        String greeting = "Hello! What's on your mind?";
        System.out.println(greeting);

        // makes bot work 
        for(int i=0; i< rounds; i++){
            String answer = input.nextLine();
            String [] splitAnswer = answer.split(" "); 
            transcript.add(answer); 

        // filters through the split responses and mirrors the words  
            for(int j=0; j< splitAnswer.length; j++){
                if (splitAnswer[j].equals ("I")){
                    splitAnswer[j] = "you"; 
                }
                else if (splitAnswer[j].equals ("me")){
                    splitAnswer[j] = "you";
                }
                else if (splitAnswer[j].equals ("am")){
                    splitAnswer[j] = "are";
                }
                else if (splitAnswer[j].equals ("are")){
                    splitAnswer[j] = "am";
                }
                else if (splitAnswer[j].equals ("you")){
                    splitAnswer[j] = "I";
                }
                else if (splitAnswer[j].equals ("my")){
                    splitAnswer[j] = "your";
                }
                else if (splitAnswer[j].equals ("your")){
                    splitAnswer[j] = "my";
                }
            }
            // puts split sentence back into a sentence 
            String mirrorAnswer = "";
            for(int k=0; k< splitAnswer.length; k++){
                mirrorAnswer = mirrorAnswer + splitAnswer[k] + " ";
            }

            // provides automated responses 
            if (mirrorAnswer.contains(answer)){
                int randomIndex = random.nextInt(responses.length);
                String randomResponse = responses [randomIndex]; 
                System.out.println(randomResponse);
                transcript.add(randomResponse);
            }else{
                System.out.println(mirrorAnswer);
                transcript.add(mirrorAnswer);
            }
            
        }
            System.out.println("Ok! Goodbye");
            System.out.println();
            System.out.println("Transcript:");
            for (int i=0; i < transcript.size (); i++){
                System.out.println(transcript.get(i));
            }
            
        
        }
    }

