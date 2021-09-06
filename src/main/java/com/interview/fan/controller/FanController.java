package com.interview.fan.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.fan.handler.CeilingFanHandler;
import com.interview.fan.model.Fan;

@RestController
@RequestMapping("/fan")
public class FanController {

	@Autowired
	CeilingFanHandler fanHandler;

	@PostMapping("/pullCord")
	public Fan saveUser(@RequestBody Fan fan, @PathParam("pullCord") Integer pullCord) {
		return fanHandler.pullCord(pullCord, fan);
	}

}
