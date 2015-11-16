package Resources;

public class Ram extends Resource {

	private static Ram instance = null; // Implementing singleton//
	private static String RESOURCE_NAME = "RAM Usage";
	ResourceKind RamKind = ResourceKind.PERCENTAGE;

	private Ram() {// just for creating an object//
		super();
	}

	public static Ram getInstance() {
		if (instance == null) {
			instance = new Ram();// will be called only once//

		}
		return instance;
	}

	@Override
	public Integer getCurrentStatus() {// /Implanted for machine - not jvm
		@SuppressWarnings("restriction")
		com.sun.management.OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory
				.getOperatingSystemMXBean();
		@SuppressWarnings("restriction")
		long totalRam = bean.getTotalPhysicalMemorySize();
		@SuppressWarnings("restriction")
		long used = totalRam - bean.getFreePhysicalMemorySize();
		return ((int) (100 * used / totalRam));
	}

	@Override
	public ResourceKind getKind() {
		return RamKind;
	}

	@Override
	public String getResourceName() {
		return RESOURCE_NAME;
	}

}
