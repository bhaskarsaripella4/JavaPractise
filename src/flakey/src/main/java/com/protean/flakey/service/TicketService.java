package com.protean.flakey.service;

import com.protean.flakey.dto.ParkingTickets;
import com.protean.flakey.repository.TicketRepo;
import com.protean.flakey.repository.TicketRepoImpl;
import com.protean.flakey.web.EmailService;
import com.protean.flakey.web.EmailServiceImpl;
import lombok.val;
import org.hibernate.annotations.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Service
public class TicketService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    TicketRepoImpl ticketRepoimpl;

    @Autowired
    EmailServiceImpl emailService;

    @Cacheable(cacheNames = "tickets")
    public Map<String,List<ParkingTickets>> findAllTickets() {
        logger.info("getting tickets from DB");
//        List<ParkingTickets> result = ticketRepo.findAll();
        Stream<ParkingTickets> result = ticketRepo.findAll().stream();
        Map<String, List<ParkingTickets>> resultMap = new HashMap<>();
        Map<String, List<ParkingTickets>> resultMap2 = new HashMap<>();

        /*
        // Attempt to use streams and lambda functions instead of for loop
        Long start = System.currentTimeMillis();
        for(ParkingTickets val: result){
            // one key many values. Then create list, append to list and put back into hashmap
            if(resultMap.containsKey(val.getPlateId())){
                List<ParkingTickets> list = resultMap.get(val.getPlateId());
                list.add(val);
                resultMap.put(val.getPlateId(),list);
            }else{
                // one unique value only
                List<ParkingTickets> list = new ArrayList<>();
                list.add(val);
                resultMap.put(val.getPlateId(),list);
            }
        }
        Long end = System.currentTimeMillis();
        logger.info("For loop for resultset to hashmap took {}ms",(end-start));
        */

        // Using lambda expression
        Long start = System.currentTimeMillis();
//        resultMap2 = result.parallelStream().collect(groupingByConcurrent(ParkingTickets::getPlateId));
        resultMap2 = result.collect(groupingBy(ParkingTickets::getPlateId));
        Long end = System.currentTimeMillis();
        logger.info("Conversion from resultset to hashmap using parallel streams took {}ms",(end-start));


//{List<ParkingTickets> p=new ArrayList<>();p.addAll();return p;}

        return resultMap2;
    }

    // toMap(keyMapper, valueMapper, mergeFunction) create mergeFunction for collisions
    List<ParkingTickets> collisions(ParkingTickets ticket){
        List<ParkingTickets> list = new ArrayList<>();
        list.add(ticket);

        return list;
    }

    //TODO the id here is not the plateId. How to pass the id that corresponds to our plateId?
    @Caching(put = {@CachePut(value="tickets", key="#plateID", cacheManager = "alternateCacheManager")})
//    @(cacheNames = "tickets", key = "#plateID")
    public List<ParkingTickets> findByPlateId(String plateID) {
        List<ParkingTickets> resultId = ticketRepo.findByPlateId(plateID);
        return resultId;
    }

    @CachePut(cacheNames = "tickets", key="#ticket.plateId", cacheManager = "alternateCacheManager")
    public void addTicket(ParkingTickets ticket) {
        ParkingTickets entered = ticketRepo.saveAndFlush(ticket);
        System.out.print(entered);
        String message = "You received a ticket for PlateId: "+ticket.getPlateId().toString()+
                ", Vehicle Type: "+entered.getVehicleMake().toString();

        //send email
        emailService.sendEmail(message);

    }

    @CacheEvict(cacheNames = "tickets", key="#ticket.plateId")
    public void deleteTicket(ParkingTickets ticket){}
}