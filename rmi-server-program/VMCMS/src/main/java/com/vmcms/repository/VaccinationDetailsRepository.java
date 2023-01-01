package com.vmcms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmcms.domain.VaccinationDetails;
@Repository
public interface VaccinationDetailsRepository extends JpaRepository<VaccinationDetails, Long> {

	void save(Optional<VaccinationDetails> citizenld);

}
