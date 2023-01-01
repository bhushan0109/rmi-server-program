package com.vmcms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmcms.dao.VaccinationDaoImpl;
import com.vmcms.domain.VaccinationDetails;
import com.vmcms.repository.VaccinationDetailsRepository;

@Service
class VmcmsServiceImpl implements VmcmsService {

	@Autowired
	VaccinationDaoImpl vaccinationDaoImpl;

	@Override
	public VaccinationDetails saveCitizen(VaccinationDetails vaccinationDetails) {
		return vaccinationDaoImpl.saveCitizen(vaccinationDetails);
	}

	@Override
	public List<VaccinationDetails> retrieveMember() {
		List<VaccinationDetails> vaccinationDetails = new ArrayList<>();
		vaccinationDetails = vaccinationDaoImpl.retrieveMember();
		return vaccinationDetails;
	}

	@Override
	public VaccinationDetails getCitizen(Long citizenId) {
		return vaccinationDaoImpl.getCitizen(citizenId);
	}

	@Override
	public String deleteCitizenId(Long citizenId) {

		String status = vaccinationDaoImpl.deleteCitizenId(citizenId);

		return status;

	}

	@Override
	public VaccinationDetails updateCitizen(Long id, VaccinationDetails vaccinationDetails) {

		VaccinationDetails citizen = vaccinationDaoImpl.getCitizen(id);
		citizen.setVaccinationStatus1(vaccinationDetails.getVaccinationStatus1());
		citizen.setVaccinationStatus2(vaccinationDetails.getVaccinationStatus2());
		VaccinationDetails citizen2 = vaccinationDaoImpl.saveCitizen(citizen);

		return citizen2;

	}

}
