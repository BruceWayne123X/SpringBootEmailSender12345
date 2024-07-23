package com.jsp.boot_email.dto;

import lombok.Data;

@Data
public class EmailList {

	String[] to;
	String subject;
	String body;

}
