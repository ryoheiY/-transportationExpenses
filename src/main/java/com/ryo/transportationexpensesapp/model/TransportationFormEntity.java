package com.ryo.transportationexpensesapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("userid")
    @Column(name = "userid")
    String userId;

    /**
     * ユーザ名
     */
    @JsonProperty("username")
    @Column(name = "username")
    String userName;


    /**
     * 出発地点
     */
    @JsonProperty("origin")
    @Column(name = "origin")
    String origin;

    /**
     * 目的地
     */
    @JsonProperty("destination")
    @Column(name = "destination")
    String destination;

    /**
     * 片道フラグ
     */
    @JsonProperty("one_way")
    @Column(name = "one_way")
    boolean isOneWay;

    /**
     * 費用
     */
    @JsonProperty("expense")
    @Column(name = "expense")
    int expense;

    /**
     * 出発日
     */
    @JsonProperty("departure_date")
    @Column(name = "departure_date")
    Date departureDate;

    /**
     * チェックフラグ
     */
    @JsonProperty("is_check")
    @Column(name = "is_check")
    boolean isCheck;

    /**
     * 申請日
     */
    @JsonProperty("created_at")
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
                ", isCheck=" + isCheck +
                ", createdAt=" + createdAt +
                '}';
    }
}