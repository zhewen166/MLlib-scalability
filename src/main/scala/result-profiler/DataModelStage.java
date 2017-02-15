/**
 * Created by YE on 2016/12/19.
 */


public class DataModelStage {

    private String StageID;
    private String StageDescription;
    private String StageDuration;
    private String TaskUrl;
    private String JobID;
    private String JobDescription;
    private String JobDuraion;
    //private int StageCount;

    public String getStageID() {
        return StageID;
    }

    public void setStageID(String stageID) {
        StageID = stageID;
    }

    public String getStageDescription() {
        return StageDescription;
    }

    public void setStageDescription(String stageDescription) {
        StageDescription = stageDescription;
    }

    public String getStageDuration() {
        return StageDuration;
    }

    public void setStageDuration(String stageDuration) {
        StageDuration = stageDuration;
    }

    public String getTaskUrl() {
        return TaskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        TaskUrl = taskUrl;
    }

    public String getJobID() {
        return JobID;
    }

    public void setJobID(String jobID) {
        JobID = jobID;
    }

    public String getJobDescription() {
        return JobDescription;
    }
    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }
    public String getJobDuraion() {
        return JobDuraion;
    }
    public void setJobDuraion(String jobDuraion) {
        JobDuraion = jobDuraion;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}