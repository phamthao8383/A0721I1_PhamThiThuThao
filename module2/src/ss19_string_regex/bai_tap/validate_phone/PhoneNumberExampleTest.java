package ss19_string_regex.bai_tap.validate_phone;

public class PhoneNumberExampleTest {
    private static PhoneNumberExample phoneNumberExample;

    public static final String[] validPhoneNumber = new String[] {"(+84)-(0978489648)","(+84)-(0966084689)","(+358)-(0123456789)"};
    public static final String[] invalidPhoneNumber = new String[] {"(+a8)-(222222222)","(+1)-(0123456789","(+2345)-(0123456789)","(+84)-(012345678)","(+84)-(01234a6789)"};

    public static void main(String[] args) {
        phoneNumberExample = new PhoneNumberExample();

        for (String phoneNumber : validPhoneNumber) {
            boolean isValid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number " + phoneNumber + " is valid: " + isValid);
        }

        for (String phoneNumber : invalidPhoneNumber) {
            boolean isValid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number " + phoneNumber + " is valid: " + isValid);
        }
    }
}
