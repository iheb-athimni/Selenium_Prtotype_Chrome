
package Runner;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;


@Component
public class SendMailFromOutlook {


    private static String staticProjectName;
    private static String archivePath;




    public void init() {

        SendMailFromOutlook.staticProjectName = Constants.Project_Front_Name;
    }

    public void sendingMail() throws IOException {

        staticProjectName = Constants.Project_Front_Name;
        final String username = "iheb.athimni@outlook.com";
        final String password = "3310Danger3310*";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.required","true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.trust", "true");
        props.put("mail.smtp.ssl.protocols","TLSv1.2");

        //archivePath = compressRepportsFiles(Constants.Rapport_Path_Test);



        try {
            archivePath = compressRepportsFiles(Constants.Rapport_Path);
        } catch (IOException e) {
            System.out.println("Error archive the file , "+ e);
            e.printStackTrace();
        }
        //archivePath = "target/karate-reports";
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("iheb.athimni@outlook.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("iheb.athimni@outlook.com"));
            message.setSubject("[Test-Auto]: "+ staticProjectName + "-" +getCurrentDateUsingFormat(Constants.PATTERN_DATE));
//            message.setText("\n \nBonjour, \n \n Vouillez trouvez ci-joint la piece jointe de votre rapport qui vous avez lancé le :" + getCurrentDateUsingFormat(Constants.FULL_PATTERN_DATE)+" \n \n Bien Cordialement");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("\n \nBonjour, \n \n Vouillez trouvez ci-joint la piece jointe de votre rapport qui vous avez lancé le :" + getCurrentDateUsingFormat(Constants.FULL_PATTERN_DATE)+" \n \n Bien Cordialement");
            // creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // adds attachments
            if (archivePath != null && archivePath.length() > 0) {

                    MimeBodyPart attachPart = new MimeBodyPart();
                    try {
                        attachPart.attachFile(archivePath);
                    } catch (IOException ex) {
                        System.out.println("attache file exeption");
                        ex.printStackTrace();
                    }
                    multipart.addBodyPart(attachPart);
            }
            // sets the multi-part as e-mail's content
            message.setContent(multipart);

//            MimeBodyPart attachmentPart = new MimeBodyPart();
//            attachmentPart.attachFile(new File(archivePath));

            Transport.send(message);

            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");
            System.out.println("mail send to the specific mail : Done");
            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");
            System.out.println("                                                    *************************                      ");                                                             
            System.out.println("                                                    *************************                      ");                                                             
            System.out.println("                                                    ***  ***         ***  ***                      ");
            System.out.println("                                                    ***    ***     ***    ***                      ");
            System.out.println("                                                    ***       *****       ***                      ");
            System.out.println("                                                    ***         *         ***                      ");
            System.out.println("                                                    ***                   ***                      ");
            System.out.println("                                                    *************************                      ");
            System.out.println("                                                    *************************                      ");
            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");                                                                  
            System.out.println("                                    ***           ***         ********             *********       ");  
            System.out.println("                                    ****         ****       ***      ***         *************     ");  
            System.out.println("                                    *****       *****      ***                ***                  ");  
            System.out.println("                                    ******     ******       *******          ***      ***********  ");  
            System.out.println("                                    *** ***   *** ***            ******      ***      ***********  ");  
            System.out.println("                                    ***  *** ***  ***                ***      ***     ***    ***   ");  
            System.out.println("                                    ***   *****   ***      ***      ***         ****       ****    ");   
            System.out.println("                                    ***    ***    ***        ********              *********       ");   
            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");                                                                              
            System.out.println("                             *********               *********           ***      ***      ***********       ");                    
            System.out.println("                             ***********          ****       ****        ****     ***      ***********        ");                   
            System.out.println("                             ***      ***       ***            ***       *****    ***      ***                 ");                  
            System.out.println("                             ***       **      ***              ***      ******   ***      ***********         ");                  
            System.out.println("                             ***       **      ***              ***      *** ***  ***      ***********        ");                   
            System.out.println("                             ***      ***       ***            ***       ***   ******      ***                ");                   
            System.out.println("                             ***********          ****       ****        ***    *****      ***********        ");                   
            System.out.println("                             *********               *********           ***      ***      ***********      ");
            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");
            System.out.println("                                                                                                   ");

        } catch (MessagingException e) {
            System.out.println("Error sending email, {},{} "+ e);
            throw new RuntimeException(e);
        }
    }


    public static String compressRepportsFiles(String pathDirReport) throws IOException {
        String archivePath = staticProjectName + getCurrentDateUsingFormat(Constants.PATTERN_DATE)+".tar.gz";
        if(Files.exists((Paths.get(pathDirReport)))) {
            new SendMailFromOutlook().createTarGZ(pathDirReport, archivePath);
            return archivePath;
        }
        return "";
    }


    public static void createTarGZ(String dirPath, String tarGzPath) throws IOException {
        FileOutputStream fOut;
        BufferedOutputStream bOut;
        GzipCompressorOutputStream gzOut;
        TarArchiveOutputStream tOut;
        fOut = new FileOutputStream(new File(tarGzPath));
        bOut = new BufferedOutputStream(fOut);
        gzOut = new GzipCompressorOutputStream(bOut);
        tOut = new TarArchiveOutputStream(gzOut);
        addFileToTarGz(tOut, dirPath, "");
        tOut.finish();
        tOut.close();;
        gzOut.close();;
        bOut.close();;
        fOut.close();
    }
    public static void addFileToTarGz(TarArchiveOutputStream tOut, String path, String base) throws IOException {
        File f = new File(path);
        System.out.println("addFileToTarGz(), file <{}> exists ? : {}"+ f.getName() + f.exists());
        String entryName = base + f.getName();
        TarArchiveEntry tarEntry = new TarArchiveEntry(f, entryName);
        tOut.putArchiveEntry(tarEntry);
        if (f.isFile()) {
            System.out.println("file to add  : {}"+ f.getName());
            IOUtils.copy(new FileInputStream(f), tOut);
            tOut.closeArchiveEntry();
        } else {
            System.out.println("folder to add  : {}" + f.getName());
            tOut.closeArchiveEntry();
            File[] children = f.listFiles();
            Arrays.asList(children).stream().forEach(System.out::println);
            if (children != null) {
                for (File child : children) {
                    System.out.println("child name <{}>, child absolute path <{}>, entryName <{}>" + child.getName() + child.getAbsolutePath() + entryName);
                    addFileToTarGz(tOut, child.getAbsolutePath(), entryName + "/");
                }
            }
        }
    }

    public static String getCurrentDateUsingFormat(String formatDate){
        DateFormat dateFormat = new SimpleDateFormat(formatDate);
        return dateFormat.format(new Date());
    }

    public static void main(String[] args) {
        SendMailFromOutlook exec = new SendMailFromOutlook();

        exec.init();
        try {
            exec.sendingMail();
        } catch (Exception exp) {
            System.out.println("error running the send mail from the main class");
        }
    }

}
