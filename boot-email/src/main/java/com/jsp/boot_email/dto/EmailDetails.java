package com.jsp.boot_email.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailDetails {
	private String to;
    private String subject;
    private String body;
    private String attachment;
}
