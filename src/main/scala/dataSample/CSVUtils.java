package dataSample;

/**
 * Created by cz on 16-12-9.
 */

import java.io.*;

/**
 * CSV操作(导出和导入)
 *
 * @version 1.0 Jan 27, 2014 4:30:58 PM
 */
public class CSVUtils {

    public static void main(String[] args){
        exportCsv(new File("/home/cz/Hadoop2/flink-all/flink-MlLib/data/SUSY/SUSY"));
    }
    /**
     * 导出
     *
     * @param file csv文件(路径+文件名)，csv文件不存在会自动创建
     * @return
     */
    public static boolean exportCsv(File file){


        String outPutFile = "/home/cz/Hadoop2/flink-all/flink-MlLib/data/SUSY/SUSY-test";
        boolean isSucess=false;

        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        PrintWriter pw = null;

        BufferedReader br = null;
        String line = "";
        double count  = 0;
        System.out.println("转换开始");
        try {
            br = new BufferedReader(new FileReader(file));
            out = new FileOutputStream(outPutFile);
            osw = new OutputStreamWriter(out);
            pw = new PrintWriter(osw);
            while ((line = br.readLine()) != null) {
               count ++;
              if(count == 11000) break;
                pw.println(line);
                pw.flush();
            }
            isSucess = true;
            System.out.println("转换结束");
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
        return isSucess;
    }
}