package com.cworld.timeline.service;

public class TimerStatus {
	private String timerName;
	private boolean isRunning;
	private boolean isCoalesces;
	private boolean isRepeats;
	public TimerStatus() {
		// TODO Auto-generated constructor stub
	}
	public String getTimerName() {
		return timerName;
	}
	public void setTimerName(String timerName) {
		this.timerName = timerName;
	}
	public boolean getRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	public boolean getCoalesces() {
		return isCoalesces;
	}
	public void setCoalesces(boolean isCoalesces) {
		this.isCoalesces = isCoalesces;
	}
	public boolean getRepeats() {
		return isRepeats;
	}
	public void setRepeats(boolean isRepeats) {
		this.isRepeats = isRepeats;
	}
	public TimerStatus(String timerName, boolean isRunning, boolean isCoalesces, boolean isRepeats) {
		super();
		this.timerName = timerName;
		this.isRunning = isRunning;
		this.isCoalesces = isCoalesces;
		this.isRepeats = isRepeats;
	}
	
}
