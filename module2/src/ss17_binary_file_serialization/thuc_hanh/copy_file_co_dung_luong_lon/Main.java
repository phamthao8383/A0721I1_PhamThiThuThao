package ss17_binary_file_serialization.thuc_hanh.copy_file_co_dung_luong_lon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter source file: ");
        String sourcePath = input.nextLine();

        System.out.println("Enter destination file");
        String destinationPath = input.nextLine();

        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        try {
            copyFileUsingStream(sourceFile, destinationFile);
            //copyFileUsingJava7Files(sourceFile,destinationFile);
            System.out.println("Copy complete");
        } catch (IOException exception) {
            System.out.println("Cant copy file");
            System.out.println(exception.getMessage());
        }
    }

    private static void copyFileUsingStream(File source, File destination) throws IOException {

        try (InputStream inputStream = new FileInputStream(source); OutputStream outputStream = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
    }

    private static void copyFileUsingJava7Files(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
