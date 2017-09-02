package com.cosmiccandi.recipes.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmiccandi.recipes.models.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long> {

}
