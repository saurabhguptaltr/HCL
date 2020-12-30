package com.hcl.payment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.payment.entity.Train;



@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

//	List<Train> findBySourceIgnoreCaseOrDestinationIgnoreCase(@Param("source") String source,@Param("destination") String destination);
	@Query("Select t from Train t where (upper(t.source)=:source AND upper(t.destination)=:destination) AND t.days like %:days%")
	List<Train> searchTrain(@Param("source") String source,@Param("destination") String destination, @Param("days")String days);
}
