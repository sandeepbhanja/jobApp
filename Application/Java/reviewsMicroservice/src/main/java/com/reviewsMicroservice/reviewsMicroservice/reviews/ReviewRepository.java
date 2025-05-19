package com.reviewsMicroservice.reviewsMicroservice.reviews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews,Long>{
    
    @Query(value="SELECT * FROM reviews_table WHERE company_id=:companyId", nativeQuery = true)
    List<Reviews> findByCompanyId(@Param("companyId") Long companyId);
}
