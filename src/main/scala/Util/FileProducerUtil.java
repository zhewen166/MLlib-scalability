package dataSample;

/**
 * Created by cz on 16-12-9.
 */

import java.io.*;

/**
 * CSV Util(import or  export csv file)
 *
 * @version 1.0 Jan 27, 2014 4:30:58 PM
 */
public class FileProducerUtil {

    public static void main(String[] args){

        String  inputFile = "/home/cz/Hadoop2/training_set";
        try {
            ListRoots.displayDirsOrFiles(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * export
     *
     * @param file csv file
     * @return
     */
    public static boolean exportCsv(File file){

        String outPutFile = "/home/cz/Hadoop2/flink-all/flink-MlLib/data/als-data/netflix-prize.csv";
        boolean isSucess=false;

        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        PrintWriter pw = null;

        BufferedReader br = null;
        String line = "";
        double count = 0;
        String temp = "";

        try {
            br = new BufferedReader(new FileReader(file));
            out = new FileOutputStream(outPutFile,true);
            osw = new OutputStreamWriter(out);
            pw = new PrintWriter(osw);
            String newLine = "";
            while ((line = br.readLine()) != null) {
                count ++;
                if(count == 1)  {
                    temp = line.substring(0,line.length() -1);
                    System.out.println(temp);
                    continue;
                } else {
                    String[] array = line.split(",");
                    newLine = temp + "::"  + array[0] +"::" +array[1] + "::" + array[2];
                }
//                pw.println(newLine);
//                pw.flush();
            }
            isSucess = true;
        } catch (Exception e) {
            isSucess = false;
        } finally {
            try {
                br.close();
                pw.close();
                osw.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("--transfer end ----");
        return isSucess;
    }
}