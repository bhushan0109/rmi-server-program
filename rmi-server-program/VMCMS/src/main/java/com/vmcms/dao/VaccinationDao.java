package com.vmcms.dao;

import java.util.List;
import java.util.Optional;

import com.vmcms.domain.VaccinationDetails;

public interface VaccinationDao {
	
	List<VaccinationDetails> retrieveMember();

	VaccinationDetails getCitizen(Long citizenId);

	VaccinationDetails updateCitizen(Long citizensId, VaccinationDetails vaccinationDetails);

	VaccinationDetails saveCitizen(VaccinationDetails vaccinationDetails);

	String deleteCitizenId(Long citizenId);

}
