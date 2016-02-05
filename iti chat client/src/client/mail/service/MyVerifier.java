/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.mail.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author 7amouda
 */
public class MyVerifier extends InputVerifier {

    String mailregex;

    @Override
    public boolean verify(JComponent input) {
        mailregex = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]*.com";
        boolean check = false;
        JTextField mailTF = (JTextField) input;
        String mailst = mailTF.getText();
        Pattern pattern = Pattern.compile(mailregex);
        Matcher match = pattern.matcher(mailst);
        if (match.matches()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }
}
