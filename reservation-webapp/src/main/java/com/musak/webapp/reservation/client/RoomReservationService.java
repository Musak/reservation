package com.musak.webapp.reservation.client;

import com.musak.webapp.reservation.domain.Room;
import com.musak.webapp.reservation.domain.RoomReservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by musak on 2/5/19.
 */
@FeignClient("RESERVATIONBUSINESSSERVICES")
public interface RoomReservationService {

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getAllRooms(@RequestParam(name="roomNumber", required=false)String roomNumber);

    @RequestMapping(value="/roomReservations/{date}", method=RequestMethod.GET)
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date);
}
