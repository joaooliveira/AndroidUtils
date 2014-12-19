package br.com.marph.android.exceptions;

public class WSTimeoutRuntimeException extends WSRuntimeException {

	private static final long serialVersionUID = 1L;

	public WSTimeoutRuntimeException() {
	}

	public WSTimeoutRuntimeException(String detailMessage) {
		super(detailMessage);
	}

	public WSTimeoutRuntimeException(Throwable throwable) {
		super(throwable);
	}

	public WSTimeoutRuntimeException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

}
