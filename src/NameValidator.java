import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {
    private static final String albumName = "^\\w+[\\w\\s]+$";


    public static boolean validate(String toCheck){
        Pattern pattern = Pattern.compile(albumName);
        Matcher matcher = pattern.matcher(toCheck);
        return matcher.matches();
    }
}
