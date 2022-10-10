package com.example.clinic.Daos.AffiliateDao;

import com.example.clinic.model.Affiliate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliateRepository extends JpaRepository<Affiliate, Long> {

    @Query("SELECT a FROM Affiliate a where a.email = :mail")
    Affiliate checkAffiliateByEmail(@Param("mail") String mail);

    @Query("SELECT a from Affiliate a where a.email = :mail AND a.password = :password")
    Affiliate affiliateSignIn(@Param("mail") String mail, @Param("password") String password);
}
