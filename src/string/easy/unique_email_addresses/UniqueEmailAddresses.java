package string.easy.unique_email_addresses;

import org.junit.Test;
import sun.security.util.Length;

/**
 * @author zlb
 * @description: 929. Unique Email Addresses
 * @date 2019/4/23 22:12
 */
public class UniqueEmailAddresses {

    @Test
    public void test() {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        numUniqueEmails(emails);
    }

    public int numUniqueEmails(String[] emails) {
        int resultLength = 0;
        String[] resultEmails = new String[emails.length];
        String emailStr = "";
        for (int i = 0, j = 0; i < emails.length; i++) {
            String email = emails[i];
            String[] emailStrArray = email.split("@");
            String localName = emailStrArray[0];
            while (localName.contains(".")) {
                String[] localNameStrArray = localName.split("\\.");
                localName = "";
                for (int k=0; k<localNameStrArray.length; k++) {
                    localName += localNameStrArray[k];
                }
            }
            while (localName.contains("+")) {
                localName = localName.split("\\+")[0];
            }
            email = localName + "@" + emailStrArray[1];
            if (!emailStr.contains(email)) {
                emailStr += "@@" + email;
                resultEmails[j] = email;
                resultLength = ++j;
            }
        }
        for (String result : resultEmails) {
            System.out.println(result);
        }
        System.out.println("resultLength: " + resultLength);
        return resultLength;
    }

}
