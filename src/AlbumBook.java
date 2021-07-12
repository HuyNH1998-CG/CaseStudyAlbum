import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class AlbumBook implements Serializable {
    static List<Album> albumList = IOOperator.readDataFromFile("src/Album.txt");
    static Scanner input = new Scanner(System.in);
    @Serial
    private static final long serialVersionUID = 1L;
    private static final int yes = 1;
    public static void addNewAlbum(String name) {
        for (Album album : albumList) {
            if (album.getName().equals(name)) {
                System.out.println("Album already exist");
                return;
            }
        }
        albumList.add(new Album(name, Login.loggedInUser.getUsername()));
        IOOperator.writeToFile("src/Album.txt", albumList);
    }

    public static void changeAlbumName(String name, String user) {
        for (Album album : albumList) {
            if (album.getName().equals(name)) {
                if (album.getOwner().equals(user)) {
                    String newName = getNewName();
                    album.setName(newName);
                } else {
                    System.out.println("Cant make change to another user's album");
                }
            }
        }
        IOOperator.writeToFile("src/Album.txt", albumList);
    }

    private static String getNewName() {
        while (true) {
            try {
                System.out.println("input New Name");
                String newName = input.nextLine();
                for (Album album : albumList) {
                    if (album.getName().equals(newName)) {
                        throw new Exception("Album name exist");
                    }
                }
                return newName;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void removeAlbum(String name, String user) {
        for (Album album : albumList) {
            if (album.getName().equals(name)) {
                if (album.getOwner().equals(user)) {
                    System.out.println("Album found are you sure you want to remove?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int answer = Integer.parseInt(input.nextLine());
                    if (answer == yes) {
                        albumList.remove(album);
                        System.out.println("An Album have been removed");
                        return;
                    } else {
                        System.out.println("Canceled album remove process");
                    }
                } else {
                    System.out.println("Cant delete another user's album");
                }
            }
        }
        IOOperator.writeToFile("src/Album.txt", albumList);
    }

    public static void showAll() {
        for (Album album : albumList) {
            System.out.println(album);
        }
    }

    public static void getAlbumSong(String name, String user) {
        for (Album album : albumList) {
            if (album.getName().equals(name)) {
                if (album.getOwner().equals(user)) {
                    album.display();
                } else {
                    System.out.println("Cant see another user's album");
                }
            }
        }
    }
    public static void findAlbum(String name){
        for(Album album: albumList){
            if(album.getName().contains(name)){
                System.out.println(album);
            }
        }
    }
    public static void getSong(String name){
        for(Album album : albumList){
            for(Song song : album.getList()){
                if (song.getName().contains(name)){
                    System.out.println(name + " found in " + album);
                }
            }
        }
    }

    public static void addToAlbum(String name, String nameSong, String user) throws Exception {
        for (Album album : albumList) {
            if (album.getName().equals(name)) {
                if (album.getOwner().equals(user)) {
                    album.addSong(nameSong);
                    IOOperator.writeToFile("src/Album.txt", albumList);
                    return;
                } else {
                    System.out.println("Cant make change to another user's album");
                }
            }
        }
        throw new Exception();
    }
}
