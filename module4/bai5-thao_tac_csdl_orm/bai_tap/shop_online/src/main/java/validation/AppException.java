package validation;

public class AppException extends RuntimeException {
    private int code;
    private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AppException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public AppException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AppException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AppException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AppException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
    
}
