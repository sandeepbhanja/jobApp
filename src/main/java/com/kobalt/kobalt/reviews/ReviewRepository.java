package com.kobalt.kobalt.reviews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews,Long>{
    
    List<Reviews> findByCompanyId(Long companyId);

}
