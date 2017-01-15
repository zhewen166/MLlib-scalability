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
public class CSVUtils2 {

    public static void main(String[] args){
        exportCsv1(new File("/home/cz/Hadoop2/spark-all/SparkFaultBench-master/data/mllib/NetFlix-prize/netflix-prize.csv"));
    }
    /**
     * 导出
     *
     * @param file csv文件(路径+文件名)，csv文件不存在会自动创建
     * @return
     */
    public static boolean exportCsv1(File file){


        String outPutFile = "/home/cz/Hadoop2/spark-all/SparkFaultBench-master/data/mllib/NetFlix-prize/netflix-prize -15.csv";
        boolean isSucess=false;

        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        PrintWriter pw = null;

        BufferedReader br = null;
        String line = "";
        double count = 0;

        try {
            br = new BufferedReader(new FileReader(file));
            out = new FileOutputStream(outPutFile);
            osw = new OutputStreamWriter(out);
            pw = new PrintWriter(osw);
            System.out.println("----转换开始 -------");
            String newLine = "";
            while ((line = br.readLine()) != null) {
                count ++;
                if(count == 15) {
                    pw.println(line);
                    pw.flush();
                    count = 0;
                }

//                String[] array = line.split(",");
//                newLine = array[0] +"::" +array[1] + "::" + array[2] + "::" + array[3];

            }
            isSucess = true;
            System.out.println(count);
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
        System.out.println("转换结束");
        return isSucess;
    }
}