package com.service;

public class TestImplement  implements TestInterface{

	public String testA() {
		return "test call a " ;
	}

	@Override
	public String testb() {
		return "test call b" ;
	}

}
