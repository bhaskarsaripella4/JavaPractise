package com.protean.flakey.controller;

import com.protean.flakey.dto.ParkingTickets;
import com.protean.flakey.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
public class TicketController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public Map<String,List<ParkingTickets>> getAllTickets(){ // return List<ParkingTickets>
//        logger.info("getting tickets from DB ");;
        return ticketService.findAllTickets();
    }

    @GetMapping("/tickets/{plateID}")
    public List<ParkingTickets> getTickets(@PathVariable String plateID){
         List<ParkingTickets> resultId = ticketService.findAllTickets().get(plateID);
         if(resultId == null) {
             logger.info("Accessing DB to get by Plate ID");
             resultId = ticketService.findByPlateId(plateID);
         }
         return resultId;
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public String addTicket(@RequestBody ParkingTickets ticket){
        ticketService.addTicket(ticket);
        String id = ticket.getPlateId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ticket.getId())
                .toUri();
        return "New ticket Entered";
    }

}
