package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domani.Hotel;
@Repository
public class HotelRepository {
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		
		return hotel;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 選択された値段による検索.
	 * @param selectprice　値段
	 * @return 得られたホテルの情報
	 */
	public List<Hotel> load(int selectprice){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :selectprice ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("selectprice", selectprice);
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		
		return hotelList;
	}
	
	/**
	 * ホテルの全件検索
	 * @return 得られたホテル情報
	 */
	public List<Hotel> findAll(){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY price DESC;";
		List<Hotel> allHotes = template.query(sql, HOTEL_ROW_MAPPER);
		
		return allHotes;
	}
}
