package com.interview.fan.constant;

import java.util.HashMap;
import java.util.Map;

 
public enum FanState {
	OFF(0), SPEED1(1), SPEED2(2), SPEED3(3),;

	private int level;
	private static final Map<Integer, FanState> fanStateMapByLevel = new HashMap<Integer, FanState>();

	static {
		for (FanState state : FanState.values()) {
			fanStateMapByLevel.put(state.getLevel(), state);
		}
	}

	FanState(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public static FanState getNextFanState(FanState state) {
		return fanStateMapByLevel.computeIfAbsent(state.getLevel() + 1, k -> FanState.OFF);
	}
}
