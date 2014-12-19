package br.com.marph.android.exceptions;

public class WSException extends Exception {

	private static final long serialVersionUID = 4711879011852188286L;

	public WSException() {
	}

	public WSException(String detailMessage) {
		super(detailMessage);
	}

	public WSException(Throwable throwable) {
		super(throwable);
	}

	public WSException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

}
