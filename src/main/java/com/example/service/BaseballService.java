package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domani.Baseball;
import com.example.repository.BaseballRepository;

@Service
@Transactional
public class BaseballService {
	
	@Autowired
	private BaseballRepository baseballRepository;
	
	public List<Baseball> findAll(){
		return baseballRepository.findAll();
	}
	
	public Baseball load(int id) {
		return baseballRepository.load(id);
	}
}
