package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domani.Hotel;
import com.example.service.HotelService;
/**
 * ホテル検索の遷移.
 * @author tatsuro.miyazaki
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	/**
	 * ホテル検索のページへ遷移.
	 * @return ホテル検索フォームへ遷移
	 */
	@RequestMapping("")
	public String index() {
		return "hotel/hotelinput";
	}
	
	/**
	 * 値段以下のホテルの表示.
	 * @param model ホテルの情報
	 * @param budget フォームで入力された値段
	 * @return 検索したホテルの情報へ遷移
	 */
	@RequestMapping("/hotelShowList")
	public String showList(Model model, String budget) {
		model.addAttribute("budget", budget);
		if("".equals(budget)) {
			List<Hotel> hotels = hotelService.findAll();
			model.addAttribute("hotels", hotels);
		}else {
			List<Hotel> hotels = hotelService.load(Integer.parseInt(budget));
			model.addAttribute("hotels", hotels);
		}
		return "hotel/hotelinput";
	}
}
