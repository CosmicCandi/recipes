package com.cosmiccandi.recipes.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmiccandi.recipes.models.Instruction;

public interface InstructionRepository extends JpaRepository <Instruction, Long>{

}
