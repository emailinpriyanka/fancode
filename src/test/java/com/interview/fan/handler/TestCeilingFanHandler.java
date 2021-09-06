package com.interview.fan.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.interview.fan.constant.FanDirection;
import com.interview.fan.constant.FanState;
import com.interview.fan.model.Fan;

public class TestCeilingFanHandler {

	 
	private CeilingFanHandler fanHandler;

    @Before                                        
    public void setUp() throws Exception {
    	fanHandler = new CeilingFanHandler();
    }
    
    
	@Test
	public void testFanStart() {
		Fan fan = new Fan(FanState.OFF,FanDirection.CLOCKWISE);
		Fan currentFan = fanHandler.pullCord(1,fan);
		assertEquals(FanState.SPEED1, currentFan.getFanCurrentState());
	}
	
	@Test
	public void testFanOff() {
		Fan fan = new Fan(FanState.SPEED3,FanDirection.CLOCKWISE);
		Fan currentFan = fanHandler.pullCord(1,fan);
		assertEquals(FanState.OFF, currentFan.getFanCurrentState());
	}
	
	@Test
	public void testFanSpeedIncrease() {
		Fan fan = new Fan(FanState.SPEED1,FanDirection.CLOCKWISE);
		Fan currentFan = fanHandler.pullCord(1,fan);
		assertEquals(FanState.SPEED2, currentFan.getFanCurrentState());
		
		currentFan = fanHandler.pullCord(1,currentFan);
		assertEquals(FanState.SPEED3, currentFan.getFanCurrentState());
	}
	
	@Test
	public void testFanSpeedDecrease() {
		Fan fan = new Fan(FanState.SPEED3,FanDirection.CLOCKWISE);
		Fan currentFan = fanHandler.pullCord(1,fan); //  switching it off
		currentFan = fanHandler.pullCord(1,fan);
		assertEquals(FanState.SPEED1, currentFan.getFanCurrentState());
		
	} 
	
	@Test
	public void testReverseFanDirection() {
		Fan fan = new Fan(FanState.SPEED1,FanDirection.CLOCKWISE);
		Fan currentFan = fanHandler.pullCord(2,fan);
		assertEquals(FanState.SPEED1, currentFan.getFanCurrentState());
		assertEquals(FanDirection.ANTICLOCKWISE, currentFan.getCurrentRotaionDirection());
		
		currentFan = fanHandler.pullCord(2,fan);
		assertEquals(FanState.SPEED1, currentFan.getFanCurrentState());
		assertEquals(FanDirection.CLOCKWISE, currentFan.getCurrentRotaionDirection());
	}
	
	@Test
	public void testReverseFanDirectionWhileFanIsOff() {
		Fan fan = new Fan(FanState.OFF,FanDirection.CLOCKWISE);
		Fan currentFan = fanHandler.pullCord(2,fan);
		assertEquals(FanState.OFF, currentFan.getFanCurrentState());
		assertEquals(FanDirection.CLOCKWISE, currentFan.getCurrentRotaionDirection());
	}
}
