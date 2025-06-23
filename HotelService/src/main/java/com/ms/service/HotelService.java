package com.ms.service;

import java.util.List;

import com.ms.entity.Hotel;

public interface HotelService {
	Hotel saveHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelById(String id);

}
