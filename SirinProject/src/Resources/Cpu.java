package Resources;

public class Cpu extends Resource {

	private static Cpu instance = null; // Implementing singleton//
	private static String RESOURCE_NAME = "Recent CPU Usage";
	ResourceKind CPUKind = ResourceKind.USAGE;

	private Cpu() {// just for creating an object//
		super();
	}

	public static Cpu getInstance() {
		if (instance == null) {
			instance = new Cpu();// will be called only once//

		}
		return instance;
	}

	@Override
	public Integer getCurrentStatus() {
		@SuppressWarnings("restriction")
		com.sun.management.OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory
				.getOperatingSystemMXBean();
		@SuppressWarnings("restriction")
		double cpuUsg = bean.getSystemCpuLoad();

		return ((int) (cpuUsg));
	}

	@Override
	public ResourceKind getKind() {
		return CPUKind;
	}

	@Override
	public String getResourceName() {
		return RESOURCE_NAME;
	}

}
