/**
 * Created by Yw on 2017/2/14.
 */
public class Stages {

    private String stageId;
    private String attemptId;
    private String numCompleteTasks;
    private String name;
    private String taskUrl;
    private String duration;

    public String getStageId() {
        return stageId;
    }
    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(String attemptId) {
        this.attemptId = attemptId;
    }

    public String getNumCompleteTasks() {
        return numCompleteTasks;
    }

    public void setNumCompleteTasks(String numCompleteTasks) {
        this.numCompleteTasks = numCompleteTasks;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    public String getTaskUrl() {
        return taskUrl;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
