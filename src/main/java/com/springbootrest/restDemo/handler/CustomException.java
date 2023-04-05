package com.springbootrest.restDemo.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{

	private String msg;
	private String errorCode;

}
