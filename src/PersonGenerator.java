
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class PersonGenerator {

    public static void main(String[] args) {
        ArrayList<String> Recs = new ArrayList<>();
        //ID



            Scanner myID = new Scanner(System.in);
            System.out.println("Enter ID: ");

            String iD = myID.nextLine();
            //System.out.println("ID is: " + iD);
            //First Name
            Scanner myName = new Scanner(System.in);
            System.out.println("Enter first name: ");
            String fname = myName.nextLine();

            // Last Name

            Scanner myLastName = new Scanner(System.in);
            System.out.println("Enter Last name: ");
            String lName = myLastName.nextLine();
            //Title
            Scanner myTitle = new Scanner(System.in);
            System.out.println("Enter your title: ");
            String mTitle = myTitle.nextLine();
            //Year of birth
            Scanner myBirthYear = new Scanner(System.in);
            System.out.println("Enter your year of birth: ");
            int year = myBirthYear.nextInt();


            System.out.println("Record is: " + iD + ", " + fname + ", " + lName + ", " + mTitle + ", " + year);
            System.out.println("Do you want to enter another?");



            //Create new file

            try {
                File personTest = new File("PersonTestData.txt");
                if (personTest.createNewFile()) {
                    System.out.println("File Created: " + personTest.getName());
                } else {
                    System.out.println("File Already exists");
                }
            } catch (IOException e) {
                System.out.println("An error occured");
                e.printStackTrace();
            }

            //Write to file

            try {
                FileWriter dataWriter = new FileWriter("PersonTestData.txt");
                dataWriter.write( fname + ", " + lName + ", " + iD + ", " + mTitle + ", " + year);
                dataWriter.close();
                System.out.println("Successfully wrote! ");
            } catch (IOException e) {
                System.out.println("Error Occurred");
                e.printStackTrace();
            }



        }

    }



