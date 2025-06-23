package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Hotel;
import com.ms.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	//Save user
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel saveHotel = hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveHotel);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> fetchHotelById(@PathVariable String id){
		Hotel hotel = hotelService.getHotelById(id);
		return ResponseEntity.ok(hotel);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Hotel>> fetchAllHotel(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	

}
