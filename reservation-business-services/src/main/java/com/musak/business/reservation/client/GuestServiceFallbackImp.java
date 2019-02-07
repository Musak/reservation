package com.musak.business.reservation.client;

import com.musak.business.reservation.domain.Guest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


/**
 * Created by musak on 2/5/19.
 */
@Component
public class GuestServiceFallbackImp implements GuestService {


    @Override
    public List<Guest> findAll(String emailAddress) {
        return Collections.emptyList();
    }

    @Override
    public Guest findOne(long id) {
        Guest guest = new Guest();
        guest.setLastName("Occupied");
        guest.setFirstName("Guest");

        return guest;
    }
}
