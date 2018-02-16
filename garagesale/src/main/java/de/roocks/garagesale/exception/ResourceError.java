package de.roocks.garagesale.exception;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class ResourceError {
	private int code;
	private String message;
}
