import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utils.RegexValidate;

@RunWith(JUnit4.class)
public class RegexValidateTest {

    private static String VALID_NAME = "Drohne";
    private static String INVALID_NAME = "drohne";
    private static String VALID_CP = "99999";
    private static String INVALID_CP = "123456";
    private static String VALID_EMAIL = "drohne@gmail.com";
    private static String INVALID_EMAIL = "@hora@1@.com";
    private static String VALID_MOBILE1 = "123456789";
    private static String INVALID_MOBILE1 = "12345";
    private static String VALID_MOBILE2 = "+34123456789";
    private static String INVALID_MOBILE2 = "+123456";
    private static RegexValidate regexValidate = new RegexValidate();

    @Test()
    public void validateName(){
        Assert.assertTrue(
                "The name of -> "+VALID_NAME +" Is it pass the regex validation ? "+ (RegexValidate.validateFirtsName(VALID_NAME)),
                regexValidate.validateFirtsName(VALID_NAME));
    }

    @Test
    public void noValidateName(){
        Assert.assertFalse(
                "The name of -> "+INVALID_NAME +" Is it pass the regex validation ? "+ (RegexValidate.validateFirtsName(INVALID_NAME)),
                regexValidate.validateFirtsName(INVALID_NAME));
    }

    @Test
    public void ValidateCP(){
        Assert.assertTrue(
                "The cp of -> "+VALID_CP +" Is it pass the regex validation ? "+ (RegexValidate.validateCP(VALID_CP)),
                regexValidate.validateCP(VALID_CP));
    }

    @Test
    public void noValidateCP(){
        Assert.assertFalse(
                "The cp of -> "+INVALID_CP +" Is it pass the regex validation ? "+ (RegexValidate.validateCP(INVALID_CP)),
                regexValidate.validateCP(INVALID_CP));
    }

    @Test
    public void ValidateEmail(){
        Assert.assertTrue(
                "The email of -> "+VALID_EMAIL +" Is it pass the regex validation ? "+ (RegexValidate.validateEmail(VALID_EMAIL)),
                regexValidate.validateEmail(VALID_EMAIL));
    }

    @Test
    public void NovalidateEmail(){
        Assert.assertFalse(
                "The email of -> "+INVALID_EMAIL +" Is it pass the regex validation ? "+ (RegexValidate.validateEmail(INVALID_EMAIL)),
                regexValidate.validateEmail(INVALID_EMAIL));
    }

    @Test
    public void ValidateMobile(){
        Assert.assertTrue(
                "The mobile of -> "+VALID_MOBILE1 +" Is it pass the regex validation ? "+ (RegexValidate.validateMobileNumber(VALID_MOBILE1)),
                regexValidate.validateMobileNumber(VALID_MOBILE1));

        Assert.assertTrue(
                "The mobile of -> "+VALID_MOBILE2 +" Is it pass the regex validation ? "+ (RegexValidate.validateMobileNumber(VALID_MOBILE2)),
                regexValidate.validateMobileNumber(VALID_MOBILE2));
    }

    @Test
    public void noValidateMobile(){
        Assert.assertFalse(
                "The mobile of -> "+INVALID_MOBILE1 +" Is it pass the regex validation ? "+ (RegexValidate.validateMobileNumber(INVALID_MOBILE1)),
                regexValidate.validateMobileNumber(INVALID_MOBILE1));

        Assert.assertFalse(
                "The mobile of -> "+INVALID_MOBILE2 +" Is it pass the regex validation ? "+ (RegexValidate.validateMobileNumber(INVALID_MOBILE2)),
                regexValidate.validateMobileNumber(INVALID_MOBILE2));
    }


}
