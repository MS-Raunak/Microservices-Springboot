package com.ms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

}
