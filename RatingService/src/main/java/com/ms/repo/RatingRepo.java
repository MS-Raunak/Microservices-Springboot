package com.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, String>{
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
