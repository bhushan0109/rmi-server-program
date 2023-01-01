package com.vmcms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vmcms.domain.VaccinationDetails;
import com.vmcms.service.VmcmsService;

@RestController
@RequestMapping("/v1")
public class VaccinationController {

	VmcmsService vmcmsService;

	public VaccinationController(VmcmsService todoService) {
		this.vmcmsService = todoService;
	}

	// this api for save Citizen

	@PostMapping
	public ResponseEntity<VaccinationDetails> saveCitizen(@RequestBody VaccinationDetails vaccinationDetails) {
		VaccinationDetails citizen = vmcmsService.saveCitizen(vaccinationDetails);

		return new ResponseEntity<>(citizen, HttpStatus.CREATED);
	}

	// this api for get single Citizen

	@GetMapping({ "/{citizenId}" })
	public ResponseEntity<VaccinationDetails> getCitizen(@PathVariable Long citizenId) {
		VaccinationDetails vaccinationDetails = null;
		vaccinationDetails = vmcmsService.getCitizen(citizenId);
		if (vaccinationDetails != null) {
			return new ResponseEntity<>(vaccinationDetails, HttpStatus.OK);
		}
		return new ResponseEntity<>(vaccinationDetails, HttpStatus.NOT_FOUND);

	}

	// this api for get all Citizen

	@GetMapping
	public ResponseEntity<List<VaccinationDetails>> getAllCitizens() {
		try {
			List<VaccinationDetails> citizens = vmcmsService.retrieveMember();
			if (citizens.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(citizens, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	// this api for edit Citizen

	@PutMapping({ "/{citizensId}" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<VaccinationDetails> updateCitizen(@PathVariable("citizensId") Long citizensId,
			@RequestBody VaccinationDetails vaccinationDetails) {
		vmcmsService.updateCitizen(citizensId, vaccinationDetails);
		return new ResponseEntity<>(vmcmsService.updateCitizen(citizensId, vaccinationDetails), HttpStatus.OK);
	}

	// this api for delete Citizen

	@DeleteMapping({ "/{citizensId}" })
	public ResponseEntity<String> deleteCitizen(@PathVariable("citizensId") Long citizensId) {
		String deleteCitizenId = vmcmsService.deleteCitizenId(citizensId);
		return new ResponseEntity<>(deleteCitizenId, HttpStatus.OK);
	}
}