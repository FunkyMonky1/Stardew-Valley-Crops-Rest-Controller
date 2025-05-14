package com.funkymonk.stradew_valley_crop_api;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropsRepository extends JpaRepository<Crops, Long> {
    List<Crops> findBySeasonsIgnoreCase(String seasons);
}