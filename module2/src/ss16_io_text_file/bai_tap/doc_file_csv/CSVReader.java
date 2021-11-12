package ss16_io_text_file.bai_tap.doc_file_csv;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVReader {
    public static void main(String[] args) {
        File file = null;

        //write csv file
        try {
            file = new File("country.csv");
            if (file.exists()) {
                throw new FileAlreadyExistsException(file.getAbsolutePath());
            }
            createCSVFile(file);
        } catch (FileAlreadyExistsException exception) {
            System.out.println("file already exist");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //read csv file
        try {
            readCSVFile(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
    public static void createCSVFile(File file) throws IOException {
        try (
                //FileWriter is like FileOutputStream can add a boolean parameter if you want to append value instead of
                //delete old file and create new one with new data
                //PrintWriter csvPrintWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)))
                PrintWriter csvPrintWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))
        ) {
            //generate data
            ArrayList<ArrayList<String>> rows = new ArrayList<>();
            rows.add(new ArrayList<>(Arrays.asList("1.0.0.0", "1.0.0.255", "16777216", "16777471", "AU", "Australia")));
            rows.add(new ArrayList<>(Arrays.asList("1.0.1.0", "1.0.3.255", "16777472", "16778239", "CN", "China"
            )));
            rows.add(new ArrayList<>(Arrays.asList("1.0.4.0", "1.0.7.255", "16778240", "16779263", "AU", "Australia"
            )));
            rows.add(new ArrayList<>(Arrays.asList("1.0.8.0", "1.0.15.255", "16779264", "16781311", "CN", "China"
            )));
            rows.add(new ArrayList<>(Arrays.asList("1.0.16.0", "1.0.31.255", "16781312", "16785407", "JP", "Japan"
            )));
            rows.add(new ArrayList<>(Arrays.asList("1.0.32.0", "1.0.63.255", "16785408", "16793599", "CN", "China"
            )));
            rows.add(new ArrayList<>(Arrays.asList("1.0.64.0", "1.0.127.255", "16793600", "16809983", "JP", "Japan"
            )));
            rows.add(new ArrayList<>(Arrays.asList("1.0.128.0", "1.0.255.255", "16809984", "16842751", "TH", "Thailand"
            )));

            //write to file
            for (ArrayList<String> row : rows) {
                csvPrintWriter.println(String.join(",", row));
            }

            csvPrintWriter.flush();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readCSVFile(File csvFile) throws IOException {
        String line;
        try (
                BufferedReader csvBufferedReader = new BufferedReader(new FileReader(csvFile));
        ) {
            while ((line = csvBufferedReader.readLine()) != null) {
                String[] country = line.split(",");
                System.out.println("Country [code=" + country[4] + ", name=" + country[5] + "]");
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
