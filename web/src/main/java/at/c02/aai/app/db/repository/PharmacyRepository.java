package at.c02.aai.app.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import at.c02.aai.app.db.entity.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

	@EntityGraph(attributePaths = { "facility", "facility.hours" })
	@Query("select pharmacy from Pharmacy pharmacy")
	List<Pharmacy> findAllWithDetails();

	@EntityGraph(attributePaths = { "facility" })
	@Query("select pharmacy from Pharmacy pharmacy join pharmacy.facility facility "
			+ "where facility.geoLat is not null and facility.geoLon is not null")
	List<Pharmacy> findWithGeoCoordinates();
}
