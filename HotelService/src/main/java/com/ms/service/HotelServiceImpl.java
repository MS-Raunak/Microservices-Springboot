package com.ms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.Hotel;
import com.ms.exception.ResourceNotFoundException;
import com.ms.repo.HotelRepo;


@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String randomUserId = UUID.randomUUID().toString();
		hotel.setId(randomUserId);
		
		return this.hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String userId) {
		return hotelRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with this id on server: " + userId));
	}

}
