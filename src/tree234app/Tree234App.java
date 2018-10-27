//Name: Kyle Serrecchia
//Date: 25 Oct 2018
//Info: Turning a 234 Tree into a B-Tree 
//(og tree from 2nd edition Data Structures and Algorithms in Java textbook)

package tree234app;

import java.io.*;
import java.util.Scanner;

public class Tree234App
 
   {
 
   public static void main(String[] args) throws IOException
 
      {
 
      long value;
 
      Tree234 theTree = new Tree234();
 
      populate(theTree);

      while(true)
 
         {
 
         System.out.print("Enter first letter of ");
 
         System.out.print("show, insert, find, change order, read from file, or quit: ");
 
         char choice = getChar();
 
         switch(choice)
 
            {
 
            case 's':
 
               theTree.displayTree();
 
               break;
 
            case 'i':
 
               System.out.print("Enter value to insert: ");
 
               value = getInt();
 
               theTree.insert(value);
 
               break;
 
            case 'f':
 
               System.out.print("Enter value to find: ");
 
               value = getInt();
 
               int found = theTree.find(value);
 
               if(found != -1)
 
                  System.out.println("Found "+value);
 
               else
 
                  System.out.println("Could not find "+value);
 
               break;
            
            case 'c':
 
                //change order
                int order = 4;
                boolean loop = true;
                while(loop) {
                    System.out.println("What order would you like your tree to be? (must be 4 or greater)");
                    order = getInt();
                    if(order>=4){
                        loop = false;
                    } else{
                        System.out.println("Order out of range! Try again.");
                    }
                }
                
                Node.setOrder(order);
                
                if(order>4){
                    theTree = new BTree();
                } else{
                    theTree = new Tree234();
                }
                
                populate(theTree);
 
                break;
            
            case 'r':
 
               //tried to make a method as you asked and a test one as well, 
               //           but it messed up every time so I just have this reading all the records from the file
               System.out.println("What is the name of the file you would like to import?");
               String textFile = getString();
               System.out.println("The current order of the tree is " + Node.getOrder());
               System.out.println("Would you like change the order,(Y)es or (N)o?");
               char response = getChar();
               int desiredOrder = 4;
               if(response=='y' || response=='Y'){
                        //change order
                        boolean loop2 = true;
                        while(loop2) {
                            System.out.println("OK. What order would you like? (must be at least 4)");
                            desiredOrder = getInt();
                            if(desiredOrder>=4){
                                loop2 = false;
                            } else{
                                System.out.println("Order out of range! Try again.");
                            }
                        }
                        
                        Node.setOrder(desiredOrder);
                        
                        theTree = new BTree();
                        
                        //populate tree with data
                        String filename = textFile;
                        File fileobject = new File(filename);
                        Scanner input = new Scanner(fileobject);
                        while (input.hasNext()){
                            String line = input.nextLine();
                            theTree.insert(line);
                        }
                        input.close();
                        break;

               } else{
                   break;
               }
            
            case 'q':
 
               System.exit(0);
 
               break;
 
            default:
 
               System.out.print("Invalid entry\n");
 
            }  // end switch
 
         }  // end while
 
      }  // end main()
 
//--------------------------------------------------------------
 
  public static void populate(Tree234 tree)
    {
        tree.insert(50);

        tree.insert(40);

        tree.insert(60);

        tree.insert(30);

        tree.insert(70);
     }
//--------------------------------------------------------------
 
   public static String getString() throws IOException
 
      {
 
      InputStreamReader isr = new InputStreamReader(System.in);
 
      BufferedReader br = new BufferedReader(isr);
 
      String s = br.readLine();
 
      return s;
 
      }
 
//--------------------------------------------------------------
 
   public static char getChar() throws IOException
 
      {
 
      String s = getString();
 
      return s.charAt(0);
 
      }
 

 
//-------------------------------------------------------------
 
   public static int getInt() throws IOException
 
      {
 
      String s = getString();
 
      return Integer.parseInt(s);
 
      }
 
//-------------------------------------------------------------
 
   }  // end class Tree234App
 