import java.util.Scanner;

public class AlbumManager {
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
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1 -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.addNewAlbum(albumName);
                    }
                    case 2 -> {
                        String albumName = getAlbumName(input);
                        String songName = getSongName(input);
                        try {
                            AlbumBook.addToAlbum(albumName, songName, Login.loggedInUser.getUsername());
                        } catch (Exception e) {
                            System.out.println("Album not found");
                        }
                    }
                    case 3 -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.removeAlbum(albumName, Login.loggedInUser.getUsername());
                    }
                    case 4 -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.changeAlbumName(albumName, Login.loggedInUser.getUsername());
                    }
                    case 5 -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.getAlbumSong(albumName, Login.loggedInUser.getUsername());
                    }
                    case 6 -> AlbumBook.showAll();
                    case 7 -> {
                        String songName = getSongName(input);
                        AlbumBook.getSong(songName);
                    }
                    case 8 -> {
                        String albumName = getAlbumName(input);
                        AlbumBook.findAlbum(albumName);
                    }
                    case 9 -> System.exit(0);
                }
            }catch (NumberFormatException e){
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
