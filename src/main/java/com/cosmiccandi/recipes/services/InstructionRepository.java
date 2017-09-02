package com.cosmiccandi.recipes.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmiccandi.recipes.models.Instruction;

@Repository
public interface InstructionRepository extends JpaRepository <Instruction, Long>{

}
