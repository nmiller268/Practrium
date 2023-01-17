import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class PersonReader {

    public static void main(String[] args) {

        try {

            File personTest = new File("PersonTestData.txt");

            Scanner myReader = new Scanner(personTest);

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                System.out.printf("%-7s%-8s%-7s%-8s%-8s\n", "ID ", "Last ", "First",  "Title",  "Birth Year");
                System.out.println(data);

            }

            myReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("An error occurred.");

            e.printStackTrace();

        }

    }

}


