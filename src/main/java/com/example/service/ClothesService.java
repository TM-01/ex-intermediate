package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domani.Clothes;
import com.example.repository.ClothesRepository;

/**
 * 衣類情報の操作の呼び出し.
 * @author tatsuro.miyazaki
 *
 */

@Service
@Transactional
public class ClothesService {
	
	@Autowired
	private ClothesRepository clothesRepository;
	
	/**
	 * 性別と色から検索.
	 * @param gender 性別
	 * @param color 色
	 * @return 検索された情報
	 */
	public List<Clothes> load(int gender, String color){
		return clothesRepository.load(gender, color);
	}
}
