package com.vmcms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vmcms.domain.VaccinationDetails;
import com.vmcms.exception.CitizenAlreadyExistsException;
import com.vmcms.exception.NoSuchCitizenExistsException;
import com.vmcms.repository.VaccinationDetailsRepository;

@Repository
public class VaccinationDaoImpl implements VaccinationDao {

	@Autowired
	VaccinationDetailsRepository VaccinationDetailsRepository;

	@PersistenceContext
	private EntityManager entityManger;

	@Override
	@Transactional
	public VaccinationDetails saveCitizen(VaccinationDetails vaccinationDetails) {
		Query q = entityManger.createQuery("SELECT so FROM VaccinationDetails so WHERE so.aadharNo = :aadharNo ");
		q.setParameter("aadharNo", vaccinationDetails.getAadharNo());
		List<VaccinationDetails> results = q.getResultList();
		System.out.println(results);
		if(results.isEmpty()) {
		entityManger.persist(vaccinationDetails);
		}else {
			throw new CitizenAlreadyExistsException("Such Citizen exists!! with adhar");
		}
		return vaccinationDetails;
	}

	@Override
	@Transactional
	public List<VaccinationDetails> retrieveMember() {
		List<VaccinationDetails> vaccinationDetails = new ArrayList<>();
		// vaccinationDetails = VaccinationDetailsRepository.findAll();

		String jpql = "SELECT v FROM VaccinationDetails v";
		TypedQuery<VaccinationDetails> query = entityManger.createQuery(jpql, VaccinationDetails.class);
		vaccinationDetails = query.getResultList();
		return vaccinationDetails;
	}

	@Override
	@Transactional
	public VaccinationDetails getCitizen(Long citizenId) {
		VaccinationDetails vaccinationDetails = entityManger.find(VaccinationDetails.class, citizenId);
		if (vaccinationDetails == null) {
			throw new NoSuchCitizenExistsException("No Such Citizen exists!!");
		}
		return vaccinationDetails;
	}

	@Override
	@Transactional
	public String deleteCitizenId(Long citizenId) {
		String status = "deleted";
		VaccinationDetails vaccinationDetails1 = entityManger.find(VaccinationDetails.class, citizenId);
		if (vaccinationDetails1 != null) {
			if (vaccinationDetails1.getNoOfvaccine() == 2) {
				entityManger.remove(vaccinationDetails1);
				status = "deleted";
			} else {
				status = " not deleted because two vaccine not completed";
			}
		}
		return status;

	}

	@Override
	@Transactional
	public VaccinationDetails updateCitizen(Long id, VaccinationDetails vaccinationDetails) {

		entityManger.getTransaction().begin();

		VaccinationDetails vaccinationDetails1 = entityManger.find(VaccinationDetails.class, id);

		if (vaccinationDetails1 != null) {
			vaccinationDetails1.setVaccinationStatus1(vaccinationDetails.getVaccinationStatus1());
			vaccinationDetails1.setVaccinationStatus2(vaccinationDetails.getVaccinationStatus2());
			entityManger.getTransaction().commit();
			entityManger.close();

			return vaccinationDetails1;
		} else {
			return null;
		}
	}

}
