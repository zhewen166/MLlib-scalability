/**
 * Created by Ye on 2017/2/15.
 */
public class Tasks {

    private String taskId;
     private String stageId;
    private String executorId;
    private String jvmGcTime;
    private String executorRunTime;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getExecutorId() {
        return executorId;
    }

    public void setExecutorId(String executorId) {
        this.executorId = executorId;
    }

    public String getExecutorRunTime() {
        return executorRunTime;
    }

    public String getJvmGcTime() {
        return jvmGcTime;
    }

    public void setExecutorRunTime(String executorRunTime) {
        this.executorRunTime = executorRunTime;
    }

    public void setJvmGcTime(String jvmGcTime) {
        this.jvmGcTime = jvmGcTime;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
