package ss17_binary_file_serialization.bai_tap.quanlysanpham;

import java.io.*;

public class ProductManager {
    public static void main(String[] args) {
        try (
                ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object.dat")));
        ) {
            output.writeObject(new Product("iPhone10", 2000, "Apple"));
            output.writeObject(new Product("galaxy10", 1500, "Samsung"));
            output.writeObject(new Product("note9", 200, "Xiaomi"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (
                ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("object.dat")))
        ) {
            Product readObject;
            while ((readObject = (Product) input.readObject()) != null) {
                System.out.println(readObject);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        } catch (EOFException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

