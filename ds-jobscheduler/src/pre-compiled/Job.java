//44434065 Runde Jia

public class Job {

	//Collect job information
	private int jobId;
    private int subitTime;
    private int estRunTime;
    private int cores;
    private int memory;
    private int disk;
    public Job( int subitTime,int jobId, int estRunTime, int cores, int memory, int disk) {
        this.jobId = jobId;
        this.subitTime = subitTime;
        this.estRunTime = estRunTime;
        this.cores = cores;
        this.memory = memory;
        this.disk = disk;
    }
 

    public int getId() {
        return jobId;
    }

    public void id(int jobId) {
        this.jobId = jobId;
    }

    public int getSubitTime() {
        return subitTime;
    }

    public void setSubitTime(int subitTime) {
        this.subitTime = subitTime;
    }

    public int getEstRunTime() {
        return estRunTime;
    }

    public void setEstRunTime(int estRunTime) {
        this.estRunTime = estRunTime;
    }

    public int cores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }


}
