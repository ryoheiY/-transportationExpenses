package com.ryo.transportationexpensesapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "transportation_form")
public class TransportationFormEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * ユーザID
     */
    @Column(name = "userid")
    String userId;

    /**
     * ユーザ名
     */
    @Column(name = "username")
    String userName;


    /**
     * 出発地点
     */
    @Column(name = "origin")
    String origin;

    /**
     * 目的地
     */
    @Column(name = "destination")
    String destination;

    /**
     * 片道フラグ
     */
    @Column(name = "one_way")
    boolean isOneWay;

    /**
     * 費用
     */
    @Column(name = "expense")
    int expense;

    /**
     * 出発日
     */
    @Column(name = "departure_date")
    Date departureDate;

    /**
     * 出発日枝番
     */
    @Column(name = "departure_sub_no")
    Integer departureSubNo;

    /**
     * 申請日
     */
    @Column(name = "created_at")
    Date createdAt;
}