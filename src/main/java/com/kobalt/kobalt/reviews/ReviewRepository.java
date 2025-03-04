package com.kobalt.kobalt.reviews;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews,Long>{

    @Query(value = "SELECT r FROM Reviews r WHERE r.company = ?1")
    List<Reviews> findAllByCompany(String company);

    @Query(value = "Select r FROM Reviews r where r.company= ?1 and r.id=?2")
    Reviews findReviewIdByCompany(String company,Long id);

    @Query(value = "Select r FROM Reviews r where r.company= ?1 and r.id=?2")
    Optional<Reviews> findReviewIdByCompanyOptional(String company,Long id);

}
