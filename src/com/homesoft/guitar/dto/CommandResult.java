package com.homesoft.guitar.dto;

public class CommandResult {

	private String output;
	
	private int exitStatus = -1;

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public int getExitStatus() {
		return exitStatus;
	}

	public void setExitStatus(int exitStatus) {
		this.exitStatus = exitStatus;
	}

	@Override
	public String toString() {
		return "CommandResult [output=" + output + ", exitStatus=" + exitStatus
				+ "]";
	}

}
