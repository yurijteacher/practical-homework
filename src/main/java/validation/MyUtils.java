package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {

    public boolean checkEmail(String text){

        /*
        A valid username in an email must start with a letter and end with a letter or number, may contain Latin letters, numbers and a dot.
        [A-Za-z0-9\\.]
        without "_"

        There must be at least two domain levels after the @ symbol.
        i => 2

        The top-level domain must be at least two letters long. (>=2)
        .com
        .ua
         */

        String pattern = "[A-Za-z]+[\\.A-Za-z0-9]+[A-Za-z0-9]@(([A-Za-z0-9]+\\.)+[A-Za-z0-9]{2,})";  //\\w{2,}";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        return (matcher.matches ()) ? true : false;
    }

}
