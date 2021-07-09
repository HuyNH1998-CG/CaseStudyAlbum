import java.util.List;
import java.util.Scanner;

public class Login {
    public static User loggedInUser;
    public static List<User> userList = IOOperator.readDataFromUserFile("src/User.txt");

    public static void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Welcome to the album management");
                System.out.println("1. Login");
                System.out.println("2. Register new user");
                System.out.println("3. Exit");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1 -> {
                        login(input);
                    }
                    case 2 -> {
                        register(input);
                    }
                    case 3 -> System.exit(0);
                }
            }catch (NumberFormatException e){
                System.out.println("Command Must input number");
            }
        }
    }

    private static void register(Scanner input) {
        System.out.println("Registering new user");
        String username = getUsername(input);
        System.out.println("Password");
        String password = input.nextLine();
        userList.add(new User(username, password));
        IOOperator.writeToUserFile("src/User.txt", userList);
    }

    private static void login(Scanner input) {
        System.out.println("Username");
        String username = input.nextLine();
        System.out.println("Password");
        String password = input.nextLine();
        boolean loggedIn = false;
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                System.out.println("Welcome " + user.getUsername());
                loggedIn = true;
                loggedInUser = user;
            }
        }
        if (loggedIn) {
            AlbumManager.Menu();
        } else {
            System.out.println("Wrong username or password");
        }
    }

    private static String getUsername(Scanner input) {
        while (true) {
            System.out.println("Username");
            String username = input.nextLine();
            boolean exist = false;
            if(NameValidator.validate(username)){
                for (User user : userList) {
                    if (user.getUsername().equalsIgnoreCase(username)) {
                        System.out.println("User already exist");
                        exist = true;
                    }
                }
            }
            if (!exist) {
                return username;
            }
        }
    }
}
