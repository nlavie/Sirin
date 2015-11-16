/**
 * 
 */
package Resources;

import java.util.ArrayList;

public abstract class Resource implements IResource {
	private static int UPDATE_WITHOUT_CHANGE=2;
	private int hasNotChangeCounter=0;
	public Resource() {
		lastStats = new ArrayList<Integer>();
	}

	protected ArrayList<Integer> lastStats;

	@Override
	public abstract Integer getCurrentStatus();

	@Override
	public abstract ResourceKind getKind();

	@Override
	public abstract String getResourceName();

	@Override
	public ArrayList<Integer> getLastStat(int amount) {//gill the last amount resault in order to freath the graph at the first run
		if (lastStats.size() < amount) {
			for (int k = 0; k < amount; k++) {
				lastStats.add(0, this.getCurrentStatus());
			}
		}

		if (lastStats.size() >= amount) {// remove last and add first
			if (this.getCurrentStatus() != lastStats.get(0)) {//update last stats only if there is a difference from last stat
				lastStats.add(0, this.getCurrentStatus());		//in case it remains without change for the UPDATE_WITHOUT_CHANGE parameter times
				lastStats.remove(lastStats.size() - 1);			//it will be updated anyway

			}else{
				if(hasNotChangeCounter==UPDATE_WITHOUT_CHANGE){ //in case number of last updates without changes equal parameter
					lastStats.add(0, this.getCurrentStatus());//change it in order to smoove the graph
					lastStats.remove(lastStats.size() - 1);	
					hasNotChangeCounter=0;
				}else{
					hasNotChangeCounter++;
				}
			}

		}
		return switchListDirection(lastStats);
	}

	private ArrayList<Integer> switchListDirection(ArrayList<Integer> list) { //switch list direction in order 
		ArrayList<Integer> list2 = new ArrayList<Integer>();				//to make the graph run from left to right
		for (int i = 0; i < list.size(); i++) {								//adjustment to graph drawing component
			list2.add(list.get(list.size() - i - 1));
		}
		return list2;
	}

}
