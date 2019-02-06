package com.musak.service.guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by musak on 2/5/19.
 */
@Repository
public interface GuestRepository extends CrudRepository<Guest, Long>{
    Guest findByEmailAddress(String emailAddress);
}
