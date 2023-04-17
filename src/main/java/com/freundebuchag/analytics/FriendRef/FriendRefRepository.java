package com.freundebuchag.analytics.FriendRef;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FriendRefRepository extends JpaRepository<FriendRef, UUID> {
    @Query(value = "SELECT f FROM FriendRef f WHERE LENGTH(f.dino) = (SELECT MAX(LENGTH(f2.dino)) FROM FriendRef f2)")
    public FriendRef getTop();
}
