package dataSample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class ListRoots {

	private static ArrayList<String> mfiles = new ArrayList<String>();

	/**
	 * 得到给定路径下的目录或是文件
	 * @param strPath
	 * @throws Exception
	 */
	public static void displayDirsOrFiles(String strPath) throws Exception {
		try {
			File f = new File(strPath);
			if (f.isDirectory()) {
				File[] fList = f.listFiles();
				for (int j = 0; j < fList.length; j++) {
					if (fList[j].isDirectory()) {
						System.out.println("Directory is: "	+ fList[j].getPath());
						displayDirsOrFiles(fList[j].getPath()); // 对当前目录下仍是目录的路径进行遍历
					}
				}
				for (int j = 0; j < fList.length; j++) {
					if (fList[j].isFile()) {
						String name = fList[j].getPath().toString();
						System.out.println("Filename is: " + name);
						mfiles.add(fList[j].getPath());
					}
				}
			}
			writeDetailToFiles(mfiles);
		} catch (Exception e) {
			System.err.println("Error： " + e);
		}
	}

	/**
	 * 向文件中写入数据
	 * @param dirOrfiles
	 * @throws IOException
	 */
	public static void writeDetailToFiles(ArrayList<String> dirOrfiles) throws IOException {
		Collections.sort(dirOrfiles);
		for (String file : dirOrfiles) {
            FileProducerUtil.exportCsv(new File(file));
		}
	}

//	/**
//	 * 获得写入数据的路径
//	 * @return
//	 */
//	public static String getLogPath() {
//		return "/home/cz/Hadoop2/flink-all/flink-MlLib/data/als-data/netflix-prize1.csv";
//	}
//
//	/**
//	 * 向dir路径下写入数据data
//	 * @param path
//	 * @param fileData
//	 */
//	public static void toFiles(String path, String fileData) throws IOException {
//		File file = new File(path);
//		if (!file.exists()) {
//			file.createNewFile();
//		}
//        FileProducerUtil.exportCsv(new File(path),new File(fileData));
//	}

}