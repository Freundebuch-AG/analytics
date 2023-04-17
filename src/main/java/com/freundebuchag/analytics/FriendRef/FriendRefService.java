package com.freundebuchag.analytics.FriendRef;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Service
@Transactional
@RequiredArgsConstructor(access = PROTECTED)
public class FriendRefService {
    @NonNull
    private final FriendRefRepository friendRefRepository;

    public FriendRef create(FriendRef transientEntitiy) {return friendRefRepository.saveAndFlush(transientEntitiy);}
    public List<FriendRef> findAll() {
        return friendRefRepository.findAll();
    }

    public FriendRef getTop() {
        return friendRefRepository.getTop();
    }
}
