package com.ms.service;

import java.util.List;

import com.ms.entity.Rating;

public interface RatingService {
	Rating saveRating(Rating rating);
	List<Rating> getAllRating();
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByHotelId(String hotelId);


}
