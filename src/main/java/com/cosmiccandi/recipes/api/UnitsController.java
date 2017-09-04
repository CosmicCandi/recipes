package com.cosmiccandi.recipes.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmiccandi.recipes.models.Unit;

@RestController
public class UnitsController {
	
	@GetMapping("/api/units") 
	public List<UnitViewModel> getAllUnits() {
		List<UnitViewModel> models = new ArrayList<UnitViewModel>();
		for (Unit u : Unit.values()) {
			models.add(new UnitViewModel(u.name(), u.getReadableUnit()));
		}
		return models;
	}
	
	public static class UnitViewModel {
		private String name;
		private String value;

		public UnitViewModel(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}
		public String getValue() {
			return value;
		}
	}

}
