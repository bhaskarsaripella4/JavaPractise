package com.protean.flakey.dto;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="parking_tickets_temp")
@Data
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ParkingTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Summons_Number")
    private Long summonsNumber;

    @Column(name = "Plate_ID")
    private String plateId;

    @Column(name = "Registration_State")
    private String state;

    @Column(name = "Plate_Type")
    private String plateType;

//    @Column(name = "Issue_Date")
//    private Date issueDate;

    @Column(name = "Violation_Code")
    private Integer violationCode;

    @Column(name = "Vehicle_Body_Type")
    private String vehicleBodyType;

    @Column(name = "Vehicle_Make")
    private String vehicleMake;

    @Column(name = "Vehicle_Color")
    private String vehicleColor;

    @Column(name = "Issuing_Agency")
    private String issuingAgency;

//    @Column(name ="Vehicle_Expiration_Date")
//    private Integer vehicleExpirationDate;

    @Column(name = "Violation_Location")
    private Integer violationLocation;

    @Column(name = "Violation_Time")
    private String violationTime;

    @Column(name = "Violation_County")
    private String violationCountry;

    @Column(name = "House_Number")
    private String houseNumber;

    @Column(name = "Street_Name")
    private String streetName;

    @Column(name = "Law_Section")
    private Integer lawSection;

    @Column(name = "Violation_Legal_Code")
    private String violationLegalCode;

    @Column(name = "Unregistered_Vehicle")
    private Boolean unregistered;

    @Column(name = "Vehicle_Year")
    private Integer vehicleYear;

    @Column(name = "MeterNumber")
    private String meterNumber;

    @Column(name = "Violation_Post_Code")
    private String violationPostCode;

}
