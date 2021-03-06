package at.c02.aai.app.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import at.c02.aai.app.db.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>, DoctorRepositoryCustom {

	@EntityGraph(attributePaths = { "facility" })
	@Query("select doctor from Doctor doctor")
	List<Doctor> findAllWithFacility();

	@EntityGraph(attributePaths = { "facility", "specialities", "insurances", "facility.hours" })
	@Query("select doctor from Doctor doctor")
	List<Doctor> findAllWithDetails();

}
