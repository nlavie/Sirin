package Graphic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Resources.IResource;

public class RunGraph {//creates run graph with list of resources for showing
	private static ArrayList<IResource> ResourceList;
	public RunGraph(ArrayList<IResource> ResourceList){
		this.ResourceList=ResourceList;
	}
	public static void paint()
			throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				DrawGraph.createAndShowGui(ResourceList);//activate thr graph update
			}
		});

	}
}
