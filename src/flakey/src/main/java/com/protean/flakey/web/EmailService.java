package com.protean.flakey.web;

import com.protean.flakey.dto.Mail;
import com.protean.flakey.dto.ParkingTickets;

public interface EmailService {

    public void sendEmail(String message);
}
