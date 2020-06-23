package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domani.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository hotelRepositor;
	
	/**
	 * 選択された値段による検索.
	 * @param selectprice 値段
	 * @return 得られたホテルの情報
	 */
	public List<Hotel> load(int selectprice){
		return hotelRepositor.load(selectprice);
	}
	
	/**
	 * ホテルの全件検索
	 * @return 得られたホテル情報
	 */
	public List<Hotel> findAll(){
		return hotelRepositor.findAll();
	}
}
