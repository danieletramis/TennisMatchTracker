package it.dtsoft.tennismatchtracker.dataaccess.exception;

public class AmbiguousSearchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8017655620609585541L;

	public AmbiguousSearchException(String msg) {
		super(msg);
	}
}
