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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transportation_form_seq")
    @SequenceGenerator(name = "transportation_form_seq", sequenceName = "transportation_form_seq",
            initialValue = 1, allocationSize = 1)
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

    @Override
    public String toString() {
        return "TransportationFormEntity{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", isOneWay=" + isOneWay +
                ", expense=" + expense +
                ", departureDate=" + departureDate +
                ", departureSubNo=" + departureSubNo +
                ", createdAt=" + createdAt +
                '}';
    }
}