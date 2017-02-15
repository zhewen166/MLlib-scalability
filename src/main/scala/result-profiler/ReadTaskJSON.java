/**
 * Created by YE on 2016/12/19.
 */

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ReadTaskJSON {

    private List<Tasks> tasksList = new ArrayList<Tasks>();
    private String stageId;
    private String taskUrl;
    //  private Tasks task;


    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public void taskwsu() throws IOException {

        URL url = new URL(getTaskUrl());

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        //  connection.setConnectTimeout(8000);
        //  connection.setReadTimeout(8000);
        String line = null;

        StringBuilder response = new StringBuilder();
        try {
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            // StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {

                response.append(line).append("\r\n");

                continue;
            }
            reader.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        String s = response.toString();
        //   System.out.println(s);

        try {
            JsonParser parser = new JsonParser();  //创建JSON解析器
            JsonElement el = parser.parse(s);
            JsonArray array = null;
            if (el.isJsonArray()) {
                array = el.getAsJsonArray();
            }

            for (int i = 0; i < array.size(); i++) {


                JsonObject subObject = array.get(i).getAsJsonObject();
                // JsonArray subArray = subObject.get("stageIds").getAsJsonArray();
                JsonObject subsubObject = subObject.get("taskMetrics").getAsJsonObject();

                Tasks task = new Tasks();
                task.setTaskId(subObject.get("taskId").getAsString());
                task.setExecutorId(subObject.get("executorId").getAsString());
                task.setExecutorRunTime(subsubObject.get("executorRunTime").getAsString());
                task.setJvmGcTime(subsubObject.get("jvmGcTime").getAsString());
                task.setStageId(getStageId());


                tasksList.add(task);

            }


        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }


    }

    public List<Tasks> getTasksList() {
        return tasksList;
    }
}
