package ss16_io_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class CopyTextFile {
    public static void main(String[] args) {
        //write source file
        try {
            File sourceFile = new File("sourceFile.txt");
            if (sourceFile.exists()) {
                throw new FileAlreadyExistsException(sourceFile.getAbsolutePath());
            }
            FileWriter sourceFileWriter = new FileWriter(sourceFile);

            sourceFileWriter.write("This is the source file");
            sourceFileWriter.close();
        }
        catch (FileAlreadyExistsException ex) {
            System.out.println("file already exist");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        //read source file and copy to target file
        try {
            //read source file
            File sourceFile = new File("sourceFile.txt");
            //File sourceFile = new File("notExistTest.txt");
            if (!sourceFile.exists()) {
                throw new FileNotFoundException();
            }
            FileReader sourceFileReader = new FileReader(sourceFile);
            BufferedReader sourceFileBuffer = new BufferedReader(sourceFileReader);

            //write to target file
            File targetFile = new File("targetFile.txt");
            if (targetFile.exists()) {
                throw new FileAlreadyExistsException(targetFile.getAbsolutePath());
            }
            FileWriter targetFileWriter = new FileWriter("targetFile.txt");
            String sourceFileLine;
            String targetFileLine;
            while ((sourceFileLine = sourceFileBuffer.readLine()) != null) {
                targetFileLine = sourceFileLine.replaceAll("source", "target");
                targetFileWriter.write(targetFileLine);
            }
            targetFileWriter.close();
            sourceFileBuffer.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("file is not found");
        }
        catch(FileAlreadyExistsException ex) {
            System.out.println("file already exist");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        //read target file after copy
        try {
            File targetFile = new File("targetFile.txt");
            FileReader targetFileReader = new FileReader(targetFile);
            BufferedReader targetFileBuffer = new BufferedReader(targetFileReader);
            String targetFileLine;
            int fileSize = 0;
            while((targetFileLine = targetFileBuffer.readLine()) != null) {
                fileSize += targetFileLine.length();
                System.out.println(targetFileLine);
            }
            System.out.println("The file size is " + fileSize);
            targetFileBuffer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }

