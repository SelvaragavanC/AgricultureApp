package com.selvaragavan.agricultureapp.transportService;


import com.selvaragavan.agricultureapp.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TransportServiceRepository extends JpaRepository<TransportService, Long> {
    @Query("select t from TransportService t join t.addressesAvailable a  where a.id =  :id ")
    List<TransportService> findAllByAddressesAvailable(@Param("id") Integer id);
}
