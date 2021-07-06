package com.GetCertifiedOnline.Exception;


	
public class ErrorInfo {
	private String url;
	private String message;
	
	public ErrorInfo() {
		
	}

	public ErrorInfo(String url, String message) {
		super();
		this.url = url;
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorInfo [url=" + url + ", message=" + message + "]";
	}


}

