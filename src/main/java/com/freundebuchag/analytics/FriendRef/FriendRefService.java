package com.freundebuchag.analytics.FriendRef;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Service
@Transactional
@RequiredArgsConstructor(access = PROTECTED)
@Getter
public class FriendRefService {
    @NonNull
    private final FriendRefRepository friendRefRepository;

    public Optional<FriendRef> findByIdOptional(UUID id) {;
        return friendRefRepository.findById(id);
    }
    public FriendRef create(FriendRef transientEntitiy) {
        if(friendRefRepository.findById(transientEntitiy.getId()).isPresent()){
            return transientEntitiy;
        } else{
            return friendRefRepository.saveAndFlush(transientEntitiy);
        }
    }

    public FriendRef getTop() {
        return friendRefRepository.getTop();
    }
}
