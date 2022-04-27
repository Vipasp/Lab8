import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {
        String fileName1 = "D:/myfile1.txt";
        String fileName2 = "D:/myfile2.txt";
        String myText2 = "Это первая строка";
        String myText1 = "Задача:  создать два текстовых документа с помощью IDEA. Наполнить их произвольным текстом. \n" +
                   "Из первого текстового файла во второй надо переписать все строки, вставив в конец каждой строки ее длину.\n" +
                  "Способ выполнения: посредством IDE.";
        stringWriter(fileName1,myText1,false);
        stringWriter(fileName2,myText2,false);
        //       int len  = stringReader(fileName1).length();
        //stringWriter(fileName2," " + len,true);;
        readFileLine(fileName1,fileName2);

         }
 private static void stringWriter(String fileName, String myText, boolean myAppend) {
    int len = myText.length();
try(FileWriter writer = new FileWriter(fileName,myAppend))
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
            // считаем файл в строку
            contents = Files.readString(Path.of(fileName));
            return contents;


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println();

        return null;
    }
    // построчное считывание файла
    private static void readFileLine (String fileName1, String fileName2) {
        int LineLenght;
               try {
            File file = new File(fileName1);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                LineLenght=line.length();
                stringWriter(fileName2,line+LineLenght,true);//допишем в конец длину строки
                // считываем остальные строки в цикле
                line = reader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}