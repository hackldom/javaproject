package view;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputReader
{
    private Scanner reader;

    public InputReader(String fname) {
        try {
            reader = new Scanner(new File(fname));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InputReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] nextLine()
    {
        String[] input = reader.nextLine().trim().split(" ");
        return input;
    }
}