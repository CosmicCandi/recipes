package com.cosmiccandi.recipes.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmiccandi.recipes.models.Measure;

public interface MeasureRepository extends JpaRepository<Measure, Long> {

}
