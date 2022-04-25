import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String fileName1 = "D:/myfile1.txt";
        String fileName2 = "D:/myfile2.txt";
        String myText1 = "It's just one line";
        String myText2 = "This is a similar string number 2";
        stringWriter(fileName1,myText1);
        stringWriter(fileName2,myText2);
        int len  = stringReader(fileName1).length();
        System.out.println(len);

    }
 private static void stringWriter(String fileName, String myText) {
    int len = myText.length();
try(FileWriter writer = new FileWriter(fileName,false))
        {
        String str = myText;
        writer.write(str);
        writer.append('\n');
        writer.flush();
        } catch (IOException e) {
        System.out.println(e.getMessage());
        }
        }
    private static String stringReader(String fileName) {
        String contents;

        try {
            // read file into string
            contents = Files.readString(Path.of(fileName));
            return contents;


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println();

        return null;
    }


}