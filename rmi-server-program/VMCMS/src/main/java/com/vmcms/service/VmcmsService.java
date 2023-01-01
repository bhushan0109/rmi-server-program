package com.vmcms.service;

import java.util.List;
import java.util.Optional;

import com.vmcms.domain.VaccinationDetails;

public interface VmcmsService {

	List<VaccinationDetails> retrieveMember();

	VaccinationDetails getCitizen(Long citizenId);

	VaccinationDetails updateCitizen(Long citizensId, VaccinationDetails vaccinationDetails);

	VaccinationDetails saveCitizen(VaccinationDetails vaccinationDetails);

	String deleteCitizenId(Long citizenId);

}
