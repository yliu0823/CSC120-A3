import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation {
  /**
* it's a chatbot that enables simple conversations, retrieving input from the user and give response.
* argument:strings 
* @param  Strings given by the user
* @return      N/A, just print out a conversation
*/
  public static void main(String[] arguments){
    //you will start all the conversations here
    ArrayList<String> printTranscript = new ArrayList<String>();//create arraylist for transcript
    printTranscript.add("TRANSCRIPT:");
    ArrayList<String> answer = new ArrayList<String>();//create arraylist for canned response
    answer.add("Sure!");
    answer.add("No thanks!");
    answer.add("Cool");
    answer.add("hmm...");
    answer.add("Sorry, I don't understand");


    System.out.println("How many rounds?");//print How many rounds
    Scanner input = new Scanner(System.in);//set up a scanner
    int round = input.nextInt();//get the number of rounds
    input.nextLine();//clear buffer
    System.out.println("Hi there! What's on your mind?");
    printTranscript.add("Hi there! What's on your mind?");

    for(int i=0;i<round;i++)//to run the required number of rounds
    { 
      String str = input.nextLine();
      int check = 0;//set up initial number of mirror words
      printTranscript.add(str);

      String[] splitstr = str.split(" ");
      for (int j = 0; j<splitstr.length; j++)
      {
        if (splitstr[j].equals("I")){
          check++;
          splitstr[j]="you";
        }
        else if (splitstr[j].equals("me")){
          check++;
          splitstr[j]="you";
        }
        else if (splitstr[j].equals("am")){
          check++;
          splitstr[j]="are";
        }
        else if (splitstr[j].equals("you")){
          check++;
          splitstr[j]="I";
        }
        else if (splitstr[j].equals("my")){
          check++;
          splitstr[j]="your";
        }
        else if (splitstr[j].equals("your")){
          check++;
          splitstr[j]="my";
        }
        else if (splitstr[j].equals("are")){
          check++;
          splitstr[j]="am";
        }
      }
      if (check==0)
      {
        Random r= new Random();//generates random response for sentences not detecting mirror words.
        int randomIndex = r.nextInt(answer.size());
        String randomAnswer = answer.get(randomIndex);
        System.out.println(randomAnswer);
        printTranscript.add(randomAnswer);
      }
      else{
        String response = String.join(" ",splitstr);
        System.out.println(response);
        printTranscript.add(response);//print the answer of the user
      }
    }
    System.out.println("See ya!");
    printTranscript.add("See ya!");
    for (int i = 0; i < printTranscript.size();i++) //print out the transcript
	      { 		      
	          System.out.println(printTranscript.get(i)); 		
	      }   
    System.out.println("```");
    input.close();
      }
    }



