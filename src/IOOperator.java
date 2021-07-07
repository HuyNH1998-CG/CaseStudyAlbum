import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOOperator {
    public static void writeToFile(String path, List<Album> albums) {
        try {
            FileOutputStream fos = new FileOutputStream(path, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(albums);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToUserFile(String path, List<User> users) {
        try {
            FileOutputStream fos = new FileOutputStream(path, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Album> readDataFromFile(String path) {
        ArrayList<Album> albums = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            albums = (ArrayList<Album>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.out.println("File not found or empty");
        }
        return albums;
    }

    public static ArrayList<User> readDataFromUserFile(String path) {
        ArrayList<User> user = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            user = (ArrayList<User>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.out.println("File not found or empty");
        }
        return user;
    }
}
