package br.com.marph.android.exceptions;

public class WSRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WSRuntimeException() {
	}

	public WSRuntimeException(String detailMessage) {
		super(detailMessage);
	}

	public WSRuntimeException(Throwable throwable) {
		super(throwable);
	}

	public WSRuntimeException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

}
