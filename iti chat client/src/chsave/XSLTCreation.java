/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chsave;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 7amouda
 */
public class XSLTCreation {

    public XSLTCreation() {
        createXSLTfile();
    }

    private void createXSLTfile() {
        try {

            String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n"
                    + "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">" + "\n"
                    + "<xsl:template match=\"Session\">" + "\n"
                    + "<html>" + "\n"
                    + "<body>" + "\n"
                    + "<xsl:for-each select=\"msg\">" + "\n"
                    + "<font>" + "\n"
                    + "<xsl:attribute name=\"size\">" + "\n"
                    + "<xsl:value-of select=\"size\" />" + "\n"
                    + "</xsl:attribute>" + "\n"
                    + "<xsl:attribute name=\"color\">" + "\n"
                    + "<xsl:value-of select=\"color\" />" + "\n"
                    + "</xsl:attribute>" + "\n"
                    + "<xsl:attribute name=\"face\">" + "\n"
                    + "<xsl:value-of select=\"face\"/>" + "\n"
                    + "</xsl:attribute>"
                    + "<xsl:value-of select=\"body\" />" + "\n"
                    + "</font>" + "\n"
                    + "<br/>" + "\n"
                    + "<br/>" + "\n"
                    + "</xsl:for-each>" + "\n"
                    + "</body>" + "\n"
                    + "</html>" + "\n"
                    + "</xsl:template>" + "\n"
                    + "</xsl:stylesheet>";

            File file = new File("C:/message.xsl");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();

            } else {
                file.delete();
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
                bw.close();
            }

            Process process = Runtime.getRuntime().exec("attrib +H " + file.getPath());
            process.waitFor();




            System.out.println("Done");

        } catch (InterruptedException ex) {
            Logger.getLogger(XSLTCreation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
