package Task;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import Graphic.DrawGraph;
import Graphic.RunGraph;
import Resources.Cpu;
import Resources.IResource;
import Resources.Ram;
import Resources.RamJVM;

public class Main {

	public static void main(String[] args) throws InvocationTargetException,
			InterruptedException {
		final int SECONDS_TO_UPDATE = 5;
		ArrayList<IResource> ResourceList = new ArrayList<IResource>();
		// initiate Resources//
		Ram ram = Ram.getInstance();
		Cpu cpu = Cpu.getInstance();
		RamJVM ramJvm = RamJVM.getInstance();
		ResourceList.add(ram);
		ResourceList.add(cpu);
		ResourceList.add(ramJvm);
		while (true) {
			RunGraph Run = new RunGraph(ResourceList);
			Run.paint();
			Thread.sleep(SECONDS_TO_UPDATE * 1000);
		}

	}

}
