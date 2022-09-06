package Runner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
public class zipClass {
    private static String archivePath;
    private static String staticProjectName;

    public zipClass(){
    }

    public String executeTasks() throws IOException {
        archivePath = compressRepportsFiles(Constants.Rapport_Path);
        return archivePath;
    }

    public static String compressRepportsFiles(String pathDirReport) throws IOException {
        staticProjectName = "Project.Front.Name";
        String archivePath = staticProjectName+ getCurrentDateUsingFormat(Constants.PATTERN_DATE)+".tar.gz";
        if(Files.exists((Paths.get(pathDirReport)))) {
            new zipClass().createTarGZ(pathDirReport, archivePath);
            return archivePath;
        }
        return "";
    }

    public static String getCurrentDateUsingFormat(String formatDate){
        DateFormat dateFormat = new SimpleDateFormat(formatDate);
        return dateFormat.format(new Date());
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
        tOut.finish();
        tOut.close();;
        gzOut.close();;
        bOut.close();;
        fOut.close();
    }
}
