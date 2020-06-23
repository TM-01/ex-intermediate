package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domani.Clothes;
import com.example.form.ClothesForm;
import com.example.service.ClothesService;
/**
 * 画面の遷移と衣類の操作.
 * @author tatsuro.miyazaki
 *
 */
@Controller
@RequestMapping("/clothes")
public class ClothesController {
	
	@Autowired
	private ClothesService clothesService;
	
	/**
	 * 衣類入力フォームの表示.
	 * @return 衣類入力フォームへ遷移
	 */
	@RequestMapping("")
	public String index() {
		return "clothes/clothesinput";
	}
	
	@ModelAttribute
	public ClothesForm setUpFrom() {
		return new ClothesForm();
	}
	
	/**
	 * 検索した衣類情報の表示.
	 * @param form 入力フォームから得た性別と色
	 * @param model 衣類情報
	 * @return 衣類情報の表示
	 */
	@RequestMapping("/clothesShowList")
	public String showList(ClothesForm form, Model model) {
		List<Clothes> clothes = clothesService.load(Integer.parseInt(form.getGender()), form.getColor());
		model.addAttribute("clothes", clothes);
		System.out.println(clothes.toString());
		
		return "clothes/clothesinput";
	}
}
