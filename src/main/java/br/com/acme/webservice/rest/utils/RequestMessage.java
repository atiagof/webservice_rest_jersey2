package br.com.acme.webservice.rest.utils;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestMessage implements Serializable {

	/**
	 * @author jean.bezerra
	 * @since 01/10/2017
	 */
	private static final long serialVersionUID = 1L;

	private int responseCode;
	private Date responseDate;
	private String responseMessage;

	public RequestMessage() {
		// TODO Auto-generated constructor stub
	}

	public RequestMessage(int responseCode, Date responseDate, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseDate = responseDate;
		this.responseMessage = responseMessage;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "RequestMessage [responseCode=" + responseCode + ", responseDate=" + responseDate + ", responseMessage="
				+ responseMessage + "]";
	}

}
