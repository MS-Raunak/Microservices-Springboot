package com.ms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.Rating;
import com.ms.exception.ResourceNotFoundException;
import com.ms.repo.RatingRepo;


@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating saveRating(Rating rating) {
		String randomUserId = UUID.randomUUID().toString();
		rating.setRatingId(randomUserId);
		
		return this.ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

	

}
