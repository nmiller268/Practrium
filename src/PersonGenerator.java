import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {

    public static void main(String[] args) {
        ArrayList<String> Recs = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

        boolean done = false;
        //ID
        String personRec = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title ="";
        int YOB = 0;


        do {


            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits] ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter first name ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter last name ");
            title = SafeInput.getNonZeroLenString(in,"Enter title ");
            YOB = SafeInput.getRangedInt(in, "Enter the year of birth: ", 1000, 9999);

            personRec = ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
            Recs.add(personRec);

            done = SafeInput.getYNConfirm(in, "Are you done? ");

        } while(!done);



            //Create new file

            try {

                OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

                for (String rec : Recs) {
                    writer.write(rec, 0, rec.length());
                    writer.newLine();
                }
                writer.close();
                System.out.println("Data file written!");
            }
            catch (IOException e)
            {
            e.printStackTrace();
            }


        }

    }



