package utils;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In java the special characters needs scape with double invert slash like that -> \\
 * This class i will used to do basic examples with regex
 */
public class RegexValidate {

    private final static Logger logger = Logger.getLogger(RegexValidate.class);

    /**
     *
     * @param name value of the name
     * @return true if the match with regex expression it is true or false it is false
     */
    public static boolean validateFirtsName(String name) {
        String CAPITALIZE_NAME_REGEX = "[A-Z][a-zA-Z]{1,50}";
        return name.matches(CAPITALIZE_NAME_REGEX);
    }

    /**
     *
     * @param cp value of postal code
     * @return true if the match with regex expression it is true or false it is false
     */
    public static boolean validateCP(String cp) {
        String CP_REGEX = "[0-9]{5}";
        return cp.matches(CP_REGEX);
    }

    /**
     *
     * @param email value of email
     * @return true if the match with regex expression it is true or false it is false
     */
    public static boolean validateEmail(String email) {
        String EMAIL_REGEX = "[^@]+@[^@]+\\.\\w+";
        return email.matches(EMAIL_REGEX);
    }

    /**
     *
     * @param mobileNumber value of mobile number
     * mobileNumber formats accepts "+11d" or "9d"
     * @return true if the match with regex expression it is true or false it is false
     */
    public static boolean validateMobileNumber(String mobileNumber) {
        String MOBILE_NUMBER_REGEX = "\\d{9}|\\+\\d{11}";
        return mobileNumber.matches(MOBILE_NUMBER_REGEX);
    }

    public static boolean checkPatternMatcher(String regex, String text) {

         return Pattern.matches(regex, text);

    }

    public static void findMatcher(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int count = 0 ;
        while (matcher.find()) {
            ++count;
            logger.info(
                    "\nThe "+ count +" coincidence starts in "+matcher.start()+ " and finish on "+matcher.end()+" "+matcher.group()+"\n");
        }
    }

    public static void lookingMatcher(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        logger.info("loockingAt() ->"+ matcher.lookingAt());
        logger.info("matches() ->"+ matcher.matches());

    }
}
