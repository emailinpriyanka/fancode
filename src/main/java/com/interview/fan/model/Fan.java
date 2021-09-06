package com.interview.fan.model;

import com.interview.fan.constant.FanDirection;
import com.interview.fan.constant.FanState;

public class Fan {

	private FanState fanCurrentState = FanState.OFF;
	private FanDirection currentRotaionDirection = FanDirection.CLOCKWISE;

	public Fan(FanState fanCurrentState, FanDirection currentRotaionDirection) {
		super();
		this.fanCurrentState = fanCurrentState;
		this.currentRotaionDirection = currentRotaionDirection;
	}
 
	public Fan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FanState getFanCurrentState() {
		return fanCurrentState;
	}

	public void setFanCurrentState(FanState fanCurrentState) {
		this.fanCurrentState = fanCurrentState;
	}

	public FanDirection getCurrentRotaionDirection() {
		return currentRotaionDirection;
	}

	public void setCurrentRotaionDirection(FanDirection currentRotaionDirection) {
		this.currentRotaionDirection = currentRotaionDirection;
	}

	@Override
	public String toString() {
		return "CeilingFan CurrentState=" + fanCurrentState + " and current Rotaion Direction= "
				+ (fanCurrentState == FanState.OFF ? "NONE" : currentRotaionDirection);
	}

}
