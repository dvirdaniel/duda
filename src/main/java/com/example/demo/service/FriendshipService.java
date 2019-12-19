package com.example.demo.service;

import com.example.demo.persistence.entity.FriendshipEntity;
import com.example.demo.persistence.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    public void setFriendShip(Long firstPupilId, Long secondPupilId) {
        FriendshipEntity friendshipEntity = new FriendshipEntity();
        friendshipEntity.setFirstPupilId(firstPupilId);
        friendshipEntity.setSecondPupilId(secondPupilId);
        friendshipRepository.save(friendshipEntity);

        friendshipEntity = new FriendshipEntity();
        friendshipEntity.setFirstPupilId(secondPupilId);
        friendshipEntity.setSecondPupilId(firstPupilId);
        friendshipRepository.save(friendshipEntity);
    }
}
