package com.musak.services.room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by musak on 2/5/19.
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    Room findByRoomNumber(String roomNumber);
}
