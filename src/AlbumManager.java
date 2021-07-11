import java.util.Scanner;

public class AlbumManager {
    private static final int createAlbum = 1;
    private static final int addSong = 2;
    private static final int deleteAlbum = 3;
    private static final int editAlbum = 4;
    private static final int showSong = 5;
    private static final int showAlbum = 6;
    private static final int searchSong = 7;
    private static final int searchAlbum = 8;
    private static final int exit = 9;
    private static final int logOut = 0;

    public static void Menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Welcome to user album list");
                System.out.println("1. Create new Album");
                System.out.println("2. Add song to Album");
                System.out.println("3. Delete an Album");
                System.out.println("4. Edit Album name");
                System.out.println("5. Show all song in an Album");
                System.out.println("6. Show all Album");
                System.out.println("7. Search songs");
                System.out.println("8. Search Album");
                System.out.println("9. Exit");
                System.out.println("0. Log out");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case createAlbum -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.addNewAlbum(albumName);
                    }
                    case addSong -> {
                        String albumName = getAlbumName(input);
                        String songName = getSongName(input);
                        try {
                            AlbumBook.addToAlbum(albumName, songName, Login.loggedInUser.getUsername());
                        } catch (Exception e) {
                            System.out.println("Album not found");
                        }
                    }
                    case deleteAlbum -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.removeAlbum(albumName, Login.loggedInUser.getUsername());
                    }
                    case editAlbum -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.changeAlbumName(albumName, Login.loggedInUser.getUsername());
                    }
                    case showSong -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.getAlbumSong(albumName, Login.loggedInUser.getUsername());
                    }
                    case showAlbum -> AlbumBook.showAll();
                    case searchSong -> {
                        String songName = getSongName(input);
                        AlbumBook.getSong(songName);
                    }
                    case searchAlbum -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.findAlbum(albumName);
                    }
                    case exit -> System.exit(0);
                    case logOut -> {
                        return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Command Must be Number");
            }
        }
    }

    private static String getSongName(Scanner input) {
        while (true) {
            System.out.println("Input Song name");
            String songName = input.nextLine();
            if (NameValidator.validate(songName)) {
                return songName;
            }
            System.out.println("Song name cannot be empty");
        }
    }

    private static String getAlbumName(Scanner input) {
        while (true) {
            System.out.println("Input Album name");
            String albumName = input.nextLine();
            if (NameValidator.validate(albumName)) {
                return albumName;
            }
            System.out.println("Album name cannot be empty");
        }
    }


}
