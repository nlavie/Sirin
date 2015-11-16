package Resources;

public class RamJVM extends Resource {

	private static RamJVM instance = null; // Implementing singleton//
	private static String RESOURCE_NAME = "JVM RAM Usage";
	ResourceKind JVMRamKind = ResourceKind.PERCENTAGE;

	private RamJVM() {// just for creating an object//

	}

	public static RamJVM getInstance() {
		if (instance == null) {
			instance = new RamJVM();// will be called only once//
		}
		return instance;
	}

	@Override
	public Integer getCurrentStatus() {// /Implanted for jvm memory - not
										// machine
		long totalRam = Runtime.getRuntime().totalMemory();
		long used = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();

		return ((int) (100 * used / totalRam));
	}

	@Override
	public ResourceKind getKind() {
		return JVMRamKind;
	}

	@Override
	public String getResourceName() {
		return RESOURCE_NAME;
	}

}
