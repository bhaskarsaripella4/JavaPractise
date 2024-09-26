package com.protean.flakey.repository;

import com.protean.flakey.dto.ParkingTickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<ParkingTickets, Integer>{

    @Override
    @Query(value= "select * from parking_tickets_temp limit 1000",nativeQuery = true)
    public List<ParkingTickets> findAll();

//    @Query(value="select p from ParkingTickets p where p.plateId = ?1") // JPA query
    @Query(value="select * from parking_tickets_temp where Plate_ID = ?1",nativeQuery = true)
    public List<ParkingTickets> findByPlateId(String plateID);
}
