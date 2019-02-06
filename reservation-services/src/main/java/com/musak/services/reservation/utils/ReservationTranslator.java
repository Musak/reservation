package com.musak.services.reservation.utils;

import com.musak.services.reservation.Reservation;
import com.musak.services.reservation.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by musak on 2/5/19.
 */
@Component
public class ReservationTranslator {

    private final DateTimeUtils dateTimeUtils;

    @Autowired
    public ReservationTranslator(DateTimeUtils dateTimeUtils){
        super();
        this.dateTimeUtils = dateTimeUtils;
    }

    public Reservation translateEntityToReservation(ReservationEntity reservationEntity){
        Reservation reservation = new Reservation();
        reservation.setId(reservationEntity.getId());
        reservation.setRoomId(reservationEntity.getRoomId());
        reservation.setGuestId(reservationEntity.getGuestId());
        reservation.setReservationDate(this.dateTimeUtils.createDateStringFromDate(reservationEntity.getDate()));
        return reservation;
    }

    public ReservationEntity translateReservationToEntity(Reservation reservation){
        ReservationEntity entity = new ReservationEntity();
        entity.setGuestId(reservation.getGuestId());
        entity.setId(reservation.getId());
        entity.setRoomId(reservation.getRoomId());
        entity.setDate(new java.sql.Date(this.dateTimeUtils.createDateFromDateString(reservation.getReservationDate()).getTime()));
        return entity;
    }
}
