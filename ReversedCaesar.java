package javaapplication29;

import java.util.Scanner;

public class ReversedCaesar {
       int FirstKey;
       int SecondKey;
 
       public ReversedCaesar(int FirstKey, int SecondKey) {
           //The keys are in the range of 26 characters
           this.FirstKey = (FirstKey%26);
           this.SecondKey = (SecondKey%26);
       }
       
       public  String encrypt(String text){
       String Result = "";
       
       //Shifting the characters to the right using the first key
       for(int position = 0; position < text.length(); position++){
           char char1 = (char)(text.charAt(position) + FirstKey);
           //Checking if the text is out of range or not
           if (Character.isLowerCase(text.charAt(position))&& char1 > 'z'  
            || Character.isUpperCase(text.charAt(position))&& char1 > 'Z')
               Result += (char)(text.charAt(position) - (26-FirstKey));
           else
               Result += (char)(text.charAt(position) + FirstKey);
       }
       
       //Reverse the text
       String ReverseResult="";
       for (int i = (Result.length()-1) ; i >=0 ; i--) {
           ReverseResult+=Result.charAt(i);
       }
       
       Result=ReverseResult;
       String FinalResult="";
       
       //Shifting the characters to the left using the second key
       for(int position = 0; position < Result.length(); position++){
           char char1 = (char)(Result.charAt(position) - SecondKey);
           //Checking if the text is out of range or not
           if (Character.isLowerCase(Result.charAt(position))&& char1 < 'a'
              || Character.isUpperCase(Result.charAt(position))&& char1 < 'A')
               FinalResult += (char)(Result.charAt(position) + (26-SecondKey));
           else
               FinalResult += (char)(Result.charAt(position) - SecondKey);
       }        
       return FinalResult;
   }
       
   public  String decrypt(String text){
       String Result = "";
       
       //Shifting the characters to the right using the second key
       for(int position = 0; position < text.length(); position++){
           char char1 = (char)(text.charAt(position) + SecondKey);
           //Checking if the text is out of range or not
           if (Character.isLowerCase(text.charAt(position))&& char1 > 'z'  
            || Character.isUpperCase(text.charAt(position))&& char1 > 'Z')
               Result += (char)(text.charAt(position) - (26-SecondKey));
           else
               Result += (char)(text.charAt(position) + SecondKey);
       }
       
       //Reverse the text
       String ReverseResult=""; 
       for (int i = (Result.length()-1) ; i >=0 ; i--) {
           ReverseResult+=Result.charAt(i);
       }
       
       Result=ReverseResult; 
       String FinalResult="";
       
       //Shifting the characters to the left using the first key
       for(int position = 0; position < Result.length(); position++){
           char char1 = (char)(Result.charAt(position) - FirstKey);
           //Checking if the text is out of range or not
           if (Character.isLowerCase(Result.charAt(position))&& char1 < 'a'
              || Character.isUpperCase(Result.charAt(position))&& char1 < 'A')
               FinalResult += (char)(Result.charAt(position) + (26-FirstKey));
           else
               FinalResult += (char)(Result.charAt(position) - FirstKey);
       }        
       return FinalResult;
   }  
   
      public static void main(String[] args) {
      
       Scanner input=new Scanner(System.in);
       System.out.println("Welcome to Our Reversed Caesar Algorithm.");
       System.out.println("");
       
       System.out.print("Enter The First Key:");
       int key1=input.nextInt();
       
       System.out.print("Enter The Second Key:");
       int key2=input.nextInt();
       
       ReversedCaesar myAlgo=new ReversedCaesar(key1,key2);
       input=new Scanner(System.in);
       System.out.println("");
       
       System.out.print("Enter Your Name: ");
       String Text=input.nextLine();
       System.out.println("");
       
       String EncryptedText=myAlgo.encrypt(Text);
       System.out.println("");
       
       System.out.println("After Encryption: "+EncryptedText);
       System.out.println("");
       
       String DecryptedText=myAlgo.decrypt(EncryptedText);
       System.out.println("");
       
       System.out.println("After Decryption: "+DecryptedText);
       
   }
   

}