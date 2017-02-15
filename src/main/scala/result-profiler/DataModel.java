/**
 * Created by YE on 2016/12/19.
 */

public class DataModel {

    private String JobID;
    private String Description;
    private String Duration;
    private String StageUrl;

    public String getJobID() {
        return JobID;
    }
    public void setJobID(String jobID) {
        JobID = jobID;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }

    public String getDuration() {
        return Duration;
    }
    public void setDuration(String duration) {
        Duration = duration;
    }

   public String getStageUrl() {
        return StageUrl;
    }

    public void setStageUrl(String stageUrl) {
        StageUrl = stageUrl;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
