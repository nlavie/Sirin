package Resources;
import java.lang.String;
import java.util.ArrayList;
public interface IResource {
	final static int KindPercentage = 1;
	final static int KindUsage = 2;
	//will return usage//
	public Integer getCurrentStatus();//returns jvm usage//
	//will return data type - Percantage or usage//
	//1 - for %, 2 for usage//
	public ResourceKind getKind();
	//will return resource name//
	public String getResourceName();
	//will be holding last 18 stat's - implemented FIFO//
	public ArrayList<Integer> getLastStat(int amount);

}
