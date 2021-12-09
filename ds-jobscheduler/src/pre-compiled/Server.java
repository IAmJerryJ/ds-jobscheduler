//44434065 Runde Jia
public class Server{
    
	//Collect server information
	public int id;
	public String type;
	public int limit;
	public int bootupTime;
	public float hourlyRate;
	public int coreCount;
	public int memory;
	public int disk;
	public int state;
	public String state1;
	public int availableTime;
	public int curStartTime;
	public int wJobs;
	public int rJobs;

       Server(int id, String type, int limit, int bootupTime, float hourlyRate, int coreCount, int memory, int disk){
    	   this.id = id;
    	   this.type = type;
    	   this.limit = limit;
    	   this.bootupTime = bootupTime;
    	   this.hourlyRate = hourlyRate;
    	   this.coreCount = coreCount;
    	   this.memory = memory;
    	   this.disk = disk;
       }
       
       Server(String tipe, int id, int state, int availTime, int core, int mem, int disk) {
   		this.type = tipe;
   		this.id = id;
   		this.state = state;
   		this.availableTime = availTime;
   		this.coreCount = core;
   		this.memory = mem;
   		this.disk = disk;
   	}
       
       Server(String type, int id, String state1, int curStartTime, int core, int mem, int disk, int wJobs, int rJobs){
    	   this.type = type;
    	   this.id = id;
    	   this.state1 = state1;
    	   this.curStartTime = curStartTime;
    	   this.core = core;
    	   this.mem = mem;
    	   this.disk = disk;
    	   this.wJobs = wJobs;
    	   this.rJobs = rJobs;
       }
}
