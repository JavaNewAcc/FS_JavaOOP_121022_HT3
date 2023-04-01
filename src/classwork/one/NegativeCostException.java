package classwork.one;

public class NegativeCostException extends Exception {

	public NegativeCostException() {
		super();
	}

	public NegativeCostException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeCostException(String message) {
		super(message);
	}

	public NegativeCostException(Throwable cause) {
		super(cause);
	}
}