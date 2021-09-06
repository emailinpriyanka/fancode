package com.interview.fan.handler;

import com.interview.fan.constant.FanDirection;
import com.interview.fan.constant.FanState;
import com.interview.fan.model.Fan;

public class CeilingFanHandler {

	/**
	 ** This handler method can handle any number of fan instance. Only one cord
	 * can be pulled at a given time.
	 * 
	 * @param cordNumber  Cord needed to be pulled for fan under consideration
	 * @param fanToHandle Need to pass a fan object whose cord we need to pull. If
	 *                    no fan object is passed then a new fan Object will be
	 *                    created and will be returned with corresponding state.
	 * @return Fan Fan object with state changed as per cord pulled.
	 */
	public Fan pullCord(Integer cordNumber, Fan fanToHandle) {
		Fan currentFanState = null;

		if (cordNumber == null || (cordNumber.intValue() != 1 && cordNumber.intValue() != 2)) {
			System.out.println("Please pull the valid cord...");
		} else {
			// If no fan object is passed then a new Fan entity will be created.
			if (fanToHandle == null) {
				fanToHandle = new Fan();
			}

			if (cordNumber == 1) {
				currentFanState = updateFanCurrentState(fanToHandle);
			} else {
				currentFanState = updateCurrentFanDirection(fanToHandle);
			}
		}
		return currentFanState;
	}

	private Fan updateFanCurrentState(Fan fanToHandle) {
		fanToHandle.setFanCurrentState(FanState.getNextFanState(fanToHandle.getFanCurrentState()));
		System.out.println("Fan state has been changed");
		return fanToHandle;
	}

	private Fan updateCurrentFanDirection(Fan fanToHandle) {
		if (fanToHandle.getFanCurrentState() == FanState.OFF) {
			System.out.println("Cann't reverse the Fan Direction as fan is currently Off.");
			return fanToHandle;
		}
		if (fanToHandle.getCurrentRotaionDirection() == (FanDirection.CLOCKWISE)) {
			fanToHandle.setCurrentRotaionDirection(FanDirection.ANTICLOCKWISE);
		} else {
			fanToHandle.setCurrentRotaionDirection(FanDirection.CLOCKWISE);
		}
		System.out.println("Fan Direction has been changed");
		return fanToHandle;
	}

}
