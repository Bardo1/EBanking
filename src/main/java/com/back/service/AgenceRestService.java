package com.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.AgenceRepository;

@RestController
public class AgenceRestService {

	@Autowired
	private AgenceRepository agenceRepository;
}
