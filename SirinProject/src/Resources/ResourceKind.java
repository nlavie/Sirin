package Resources;

public enum ResourceKind {
	PERCENTAGE(1), USAGE(2);
	private int value;

	private ResourceKind(int value) {
		this.value = value;
	}
}
