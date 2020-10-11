
import java.io.*;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;



public class Company {
   
   
   private static String DATA_FILE_NAME = ".company_book_demo";
   
   
   public static void main(String[] args) {
      
      String name, price;  

      TreeMap<String,String>  comBook;   
      
      comBook = new TreeMap<String,String>();
      
      
      
      
      File userHomeDirectory = new File( System.getProperty("user.home") );
      File dataFile = new File( userHomeDirectory, DATA_FILE_NAME );
      
      
      
      
      if ( ! dataFile.exists() ) {
         System.out.println("No items data file found.");
         System.out.println("A new one will be created.");
         System.out.println("File name:  " + dataFile.getAbsolutePath());
      }
      else {
         System.out.println("Reading item list data...");
         try {
            Scanner scanner = new Scanner( dataFile );
            while (scanner.hasNextLine()) {
               String phoneEntry = scanner.nextLine();
               int separatorPosition = phoneEntry.indexOf('%');
               if (separatorPosition == -1)
                  throw new IOException("File is not a  data file.");
               name = phoneEntry.substring(0, separatorPosition);
               price = phoneEntry.substring(separatorPosition+1);
               comBook.put(name,price);
            }
         }
         catch (IOException e) {
            System.out.println("Error in store data file.");
            System.out.println("File name:  " + dataFile.getAbsolutePath());
            System.out.println("This program cannot continue.");
            System.exit(1);
         }
      }
      
      
      
      
      Scanner in = new Scanner( System.in );
      boolean changed = false;  // Have any changes been made to the directory?
      
      mainLoop: while (true) {
         System.out.println("\nSelect the action that you want to perform:");
         System.out.println("   1.  Look up a price and item name.");
         System.out.println("   2.  Add or change a price.");
         System.out.println("   3.  Remove an entry from your lists.");
         System.out.println("   4.  List the entire items.");
         System.out.println("   5.  Display Emp 2.");
         System.out.println("   6.  Display Emp 3.");
         System.out.println("   7.  Display Emp 4.");
         System.out.println("   8.  Display Emp 6.");
         System.out.println("   9.  Exit from the program.");
         System.out.println("Enter action price (1-5):  ");
         int command;
         if ( in.hasNextInt() ) {
            command = in.nextInt();
            in.nextLine();
         }
         else {
            System.out.println("\nILLEGAL RESPONSE.  YOU MUST ENTER A PRICE.");
            in.nextLine();
            continue;
         }
         switch(command) {
         case 1:
            System.out.print("\nEnter the name which price you want to look up: ");
            name = in.nextLine().trim().toLowerCase();
            price = comBook.get(name);
            if (price == null)
               System.out.println("\nSORRY, NO PRICE FOUND FOR " + name);
            else
               System.out.println("\n PRICE FOR " + name + ":  " + price);
            break;
         case 2:
            System.out.print("\nEnter the item name: ");
            name = in.nextLine().trim().toLowerCase();
            if (name.length() == 0)
               System.out.println("\nNAME CANNOT BE BLANK.");
            else if (name.indexOf('%') >= 0)
               System.out.println("\nNAME CANNOT CONTAIN THE CHARACTER \"%\".");
            else { 
               System.out.print("Enter Price here: ");
               price = in.nextLine().trim();
               if (price.length() == 0)
                  System.out.println("\nPRICE CANNOT BE BLANK.");
               else {
                  comBook.put(name,price);
                  changed = true;
               }
            }
            break;
         case 3:
            System.out.print("\nEnter the item name which entry you want to remove: ");
            name = in.nextLine().trim().toLowerCase();
            price = comBook.get(name);
            if (price == null)
               System.out.println("\nSORRY, THERE IS NO ENTRY FOR " + name);
            else {
               comBook.remove(name);
               changed = true;
               System.out.println("\n DATA ENTRY REMOVED FOR " + name);
            }
            break;
         case 4:
            System.out.println("\nLIST OF ENTRIES IN YOUR STORE:\n");
            for ( Map.Entry<String,String> entry : comBook.entrySet() )
               System.out.println("   " + entry.getKey() + ": " + entry.getValue() );
            break;
            case 5:
              /*System.out.println("The Numbers are a= "+a+" b= "+b+" c= "+c);
                int max = (a>b ? (a>c ? a : c): (b>c ? b : c));
                System.out.println("Max= "+max);
                int min = (a<b ? (a<c ? a : c): (b<c ? b : c));
                System.out.println("Min= "+min);*/
            System.out.println("\n Here the goodies that are selected for distribution are:\n");
            System.out.println("\n Microwave Oven: 9800 \n Alexa: 9999 \n");
            break;
            case 6:
              /*System.out.println("The Numbers are a= "+a+" b= "+b+" c= "+c);
                int max = (a>b ? (a>c ? a : c): (b>c ? b : c));
                System.out.println("Max= "+max);
                int min = (a<b ? (a<c ? a : c): (b<c ? b : c));
                System.out.println("Min= "+min);*/
            System.out.println("\n Here the goodies that are selected for distribution are:\n");
            System.out.println("\n Microwave Oven: 9800 \n Alexa: 9999 \n MI Brand: 999 \n");
            break;
            case 7:
              /*System.out.println("The Numbers are a= "+a+" b= "+b+" c= "+c);
                int max = (a>b ? (a>c ? a : c): (b>c ? b : c));
                System.out.println("Max= "+max);
                int min = (a<b ? (a<c ? a : c): (b<c ? b : c));
                System.out.println("Min= "+min);*/
            System.out.println("\n Here the goodies that are selected for distribution are:\n");
            System.out.println("\n Fitbit Plus: 7980 \n Microwave Oven: 9800 \n Alexa: 9999 \n Digital Camera: 11101 \n");
            break;
            case 8:
              /*System.out.println("The Numbers are a= "+a+" b= "+b+" c= "+c);
                int max = (a>b ? (a>c ? a : c): (b>c ? b : c));
                System.out.println("Max= "+max);
                int min = (a<b ? (a<c ? a : c): (b<c ? b : c));
                System.out.println("Min= "+min);*/
            System.out.println("\n Here the goodies that are selected for distribution are:\n");
            System.out.println("\n Sandwich Toaster: 2195 \n Cult Pass: 2799 \n Scale: 4999 \n Fitbit Plus: 7980 \n Microwave Oven: 9800 \n Alexa: 9999 \n");
            break;
         case 9:
            System.out.println("\nExiting program.");
            break mainLoop;
         default:
            System.out.println("\nILLEGAL ACTION NUMBER.");
         }
      }
      
      
     
      
      if (changed) {
         System.out.println("Saving phone directory changes to file " + 
               dataFile.getAbsolutePath() + " ...");
         PrintWriter out;
         try {
            out = new PrintWriter( new FileWriter(dataFile) );
         }
         catch (IOException e) {
            System.out.println("ERROR: Can't open data file for output.");
            return;
         }
         for ( Map.Entry<String,String> entry : comBook.entrySet() )
            out.println(entry.getKey() + "%" + entry.getValue() );
         out.close();
         if (out.checkError())
            System.out.println("ERROR: Some error occurred while writing data file.");
         else
            System.out.println("Done.");
      }
   
   }

}