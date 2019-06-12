import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.log4j.Logger;
import utils.RegexValidate;

/**
 * Regex basic tips
 * ----Urls to checkup regex----
 * 1- https://regex101.com/
 * 2- https://www.regexplanet.com/
 *
 * ----Notes----
 * Two possible way to compare with regex
 * first way :
 * "Hi world" // it content regex expression "Hi"
 * Second way :
 * Hi world" // it dont be equals regex expression "Hi"
 *
 * ----Special Characteres ----
 * If we want use special character in our regular expression we need scape it
 * If we want to know if our string have any of this special characteres, ussualy we need scape it before of this special
 *character we will use invert slash.
 * "." -> equals to any character for example -> "a"
 * "[0-9]\.[0-9]" -> it will match with float integers in string format -> "1.5"
 *(in this example we are scaping the special character "." for the literal) .
 *----starts at ends in----
 * ^ -> This is used to say where is the start
 * $ -> This is used to say where is the end
 *
 * Example ^
 * regex => "^Hi" will match success with -> "Hi world" and it will match failure with "hi world"
 * Example $
 * regex => "world$" will match success with -> "Hi world" and it will match failure with "hi World"
 * Example combined ^ and $
 * regex => "^Hi World$" It only will match success with -> "Hi World"
 * We can verify a character by groups of characters :
 * regex => "[hH]i world" it can do success match with the following examples . "hi world" and "Hi world"
 * regex => "^[hH]i [wW]orld$" it can do success match with all casuistry of case sensitive results between hi world words.
 * We can verify a character by range of type of characters :
 * regex => "[0-9][a-zA-Z]" it can do: (the group of range only will evaluate a character)
 * success match with -> "1a" , "0A", "3aA", "4R4"
 * failure match with -> "a1" , "12a"
 * We can use so group of range like we needs
 * regex => "[0-9][a-zA-Z][0-9]" it will match success with for example "1a9", "1A9"
 *
 * We can use ^ character inside of group of ranges or group of characters to do negative expressions
 * regex => [^0-9] it will match success with this example "a", "b" etc.. and will match failue with "0" ,"1", "2" etc..
 * In this case the first character can not be in range of 0-9
 *
 * ----Shortcuts of ranges----
 * For all ranges of words :
 * Regex "[a-zA-Z]" == \w
 * Regex "[^a-zA-Z]" == \W  No words
 * Regex "[0-9]" == \d
 * Regex "[^0-9]" == \D No numbers
 * Regex "[" "]" == \s Empty space or tabs
 * Regex "[^" "]" == \S No empty space or tabs
 * "hi" -> It is a word \w, It is not numbers \D, It is not white spaces \S "\w\D\S"
 * "Two turtles" -> It is word \w it have not number \D and it have white spaces \s
 *
 * ----Quantifiers------
 * We was going to see how we can use regex on character position.
 * If we need use a regex expression for a field of 3 character of length we can do it :
 * "[0-9][0-9][0-9]" and it is perfectly valid for "123", "999", "000"
 * But when the expression regular is very long or complex it is not the best way
 * For simplify the work we can use the quantifiers, we will reproduce the last example again:
 * "[0-9]{3,3}" Where [0-9] it is saying what we permit only number format and {3,3} indicate {min of char,max of chars}
 * If we want to do a expression :
 * from 0 to N char we can use {0,} == \d*
 * from 1 to N char we can use {1,} == \d+
 * Regex -> "[0-9]{3,3}\d?" it can match success "abc" and "abc1" where ? symbol represent an optional character
 * Regex -> "[0-9]{3,3}" == "\d{3}"
 * Example Email regex expression
 * "\w{4,}@\w+\.\w{2,}"
 * "[^@]+@[^@]+\.\w+"
 *
 */
public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);


    public static String[] results = new String[10];


    public static void main(String[] args){

        results = prepareResults();

        for (String result : results) {
            logger.info(result);
        }


        logger.info(RegexValidate.checkPatternMatcher("\\w+","Hello"));
        RegexValidate.findMatcher("pepe","It is a man called pepe, pepe was a genius");
        RegexValidate.lookingMatcher("fo","foooooooo");


    }

    public static String[] prepareResults() {

        String VALID_NAME = "Drohne";
        String INVALID_NAME = "drohne";
        String VALID_CP = "99999";
        String INVALID_CP = "123456";
        String VALID_EMAIL = "drohne@gmail.com";
        String INVALID_EMAIL = "@hora@1@.com";
        String VALID_MOBILE1 = "123456789";
        String INVALID_MOBILE1 = "12345";
        String VALID_MOBILE2 = "+34123456789";
        String INVALID_MOBILE2 = "+123456";

        results[0] ="The name of -> "+VALID_NAME +" Is it pass the regex validation ? "+ (RegexValidate.validateFirtsName(VALID_NAME));
        results[1] ="The name of -> "+INVALID_NAME +" Is it pass the regex validation ? "+ (RegexValidate.validateFirtsName(INVALID_NAME));
        results[2] ="The cp of -> "+VALID_CP +" Is it pass the regex validation ? "+ (RegexValidate.validateCP(VALID_CP));
        results[3] ="The cp of -> "+INVALID_CP +" Is it pass the regex validation ? "+ (RegexValidate.validateCP(INVALID_CP));
        results[4] ="The email of -> "+VALID_EMAIL +" Is it pass the regex validation ? "+ (RegexValidate.validateEmail(VALID_EMAIL));
        results[5] ="The email of -> "+INVALID_EMAIL +" Is it pass the regex validation ? "+ (RegexValidate.validateEmail(INVALID_EMAIL));
        results[6] ="The mobile -> "+VALID_MOBILE1 +" Is it pass the regex validation ? "+ (RegexValidate.validateMobileNumber(VALID_MOBILE1));
        results[7] ="The mobile -> "+INVALID_MOBILE1 +" Is it pass the regex validation ? "+ (RegexValidate.validateMobileNumber(INVALID_MOBILE1));
        results[8] ="The mobile -> "+VALID_MOBILE2 +" Is it pass the regex validation ? "+ (RegexValidate.validateMobileNumber(VALID_MOBILE2));
        results[9] ="The mobile -> "+INVALID_MOBILE2 +" Is it pass the regex validation ? "+ (RegexValidate.validateMobileNumber(INVALID_MOBILE2));

        return results;
    }


}

