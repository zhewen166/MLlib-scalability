/**
 * Created by YE on 2016/12/19.
 */

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {

    public static void main(String[] args) throws WriteException, IOException, BiffException {
        // write your code here

        String appid = "app-20170119143952-0014";


        JxlUtil ju1 = new JxlUtil();
        ju1.setPath("C:\\Users\\Job.xls");

        JxlUtil ju2 = new JxlUtil();
        ju2.setPath("C:\\Users\\Stage.xls");

        JxlUtil ju3 = new JxlUtil();
        ju3.setPath("C:\\Users\\Task.xls");

        /*Get Job Information from the Web Page and Write it into Excel*/

        WebSpiderVerOne wsu1 = new WebSpiderVerOne();
        wsu1.setUrl("http://133.133.10.1:18080/history/"+appid+"/jobs/");
        wsu1.CaputerData();
        List<DataModel> Job = wsu1.getDataModelList();

        Map<String, List<List<String>>> listListMap1 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList1 = new ArrayList<List<String>>();
        List<String> list1 = new ArrayList<String>();
        list1.add("JobID");
        list1.add("JobDescription");
        list1.add("JobDuration");
        // list1.add("URL");

        listList1.add(list1);
        for (int i = 0; i < Job.size(); i++) {
            List<String> list11 = new ArrayList<String>();
            list11.add(Job.get(i).getJobID());
            list11.add(Job.get(i).getDescription());
            list11.add(Job.get(i).getDuration());
            listList1.add(list11);
        }

        listListMap1.put("Job History", listList1);
        ju1.write(listListMap1);

        /*Get Stage Information from the Web Page and Write it into Excel*/

        Map<String, List<List<String>>> listListMap2 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList2 = new ArrayList<List<String>>();
        List<String> list2 = new ArrayList<String>();
        list2.add("JobID");
        list2.add("JobDescription");
        list2.add("JobDuration");
        list2.add("StageID");
        list2.add("StageDescription");
        list2.add("StageDuration");

        listList2.add(list2);
        StageSpiderVerOne wsu2 = new StageSpiderVerOne();
        for (int i = 0; i < wsu1.getDataModelList().size(); i++) {
            wsu2.setStageUrl(wsu1.getDataModelList().get(i).getStageUrl());
            wsu2.setJobID(wsu1.getDataModelList().get(i).getJobID());
            wsu2.setJobDescription(wsu1.getDataModelList().get(i).getDescription());
            wsu2.setJobDuration(wsu1.getDataModelList().get(i).getDuration());
            wsu2.CaputerStageData();
        }
        List<DataModelStage> Stage = wsu2.getDataModelStageList();
        for (int j = 0; j < wsu2.getDataModelStageList().size(); j++) {
            List<String> list22 = new ArrayList<String>();
            list22.add(Stage.get(j).getJobID());
            list22.add(Stage.get(j).getJobDescription());
            list22.add(Stage.get(j).getJobDuraion());
            list22.add(Stage.get(j).getStageID());
            list22.add(Stage.get(j).getStageDescription());
            list22.add(Stage.get(j).getStageDuration());
            //          list22.add(Stage.get(j).getTaskUrl());
            listList2.add(list22);
        }
        listListMap2.put("Stage History", listList2);
        ju2.write(listListMap2);



        ReadStageJSON read2 = new ReadStageJSON();
        read2.setStageUrl(appid);
        read2.stagewsu();
        List<Stages> stage = read2.getStagesList();


        ReadTaskJSON read3 = new ReadTaskJSON();
        for(int i=0;i<stage.size();i++)
        {
      //      System.out.println(stage.get(i).getTaskUrl());
            read3.setTaskUrl(stage.get(i).getTaskUrl());
            read3.setStageId(stage.get(i).getStageId());
            read3.taskwsu();
        }

        List<Tasks> task = read3.getTasksList();

        Map<String, List<List<String>>> listListMap3 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList3 = new ArrayList<List<String>>();
        List<String> list3 = new ArrayList<String>();
        list3.add("TaskID");
        list3.add("StageID");
        list3.add("ExecutorID");
        list3.add("GC Time/ms");
        list3.add("Duration/ms");
        //   list1.add("StageID");
        listList3.add(list3);
        for (int i = 0; i < task.size(); i++) {
            List<String> list33 = new ArrayList<String>();
            list33.add(task.get(i).getTaskId());
            list33.add(task.get(i).getStageId());
            list33.add(task.get(i).getExecutorId());
            list33.add(task.get(i).getJvmGcTime());
            list33.add(task.get(i).getExecutorRunTime());

            listList3.add(list33);
        }

        listListMap3.put("Job History", listList3);
        ju3.write(listListMap3);




    }
}


