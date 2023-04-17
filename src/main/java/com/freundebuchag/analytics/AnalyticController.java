package com.freundebuchag.analytics;

import com.freundebuchag.analytics.FriendRef.FriendRef;
import com.freundebuchag.analytics.FriendRef.FriendRefService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/dino")
@RequiredArgsConstructor
public class AnalyticController {

    private final AnalyticResourceAssembler analyticResourceAssembler;

    private final FriendRefService friendRefService;

    @GetMapping
    public ResponseEntity<AnalyticResource> getTopLongDino() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://localhost:8080/friend";
        FriendRef[] response = restTemplate.getForObject(url, FriendRef[].class);

        List<FriendRef> friendRefList = Arrays.asList(response);

        friendRefList.stream().map(friend -> {
            FriendRef friendRef = new FriendRef();
            friendRef.setId(friend.getId());
            friendRef.setFirstName(friend.getFirstName());
            friendRef.setLastName(friend.getLastName());
            friendRef.setBday(friend.getBday());
            friendRef.setFood(friend.getFood());
            friendRef.setAnimal(friend.getAnimal());
            friendRef.setDino(friendRef.getDino());
            return friendRef;
        }).forEach(friendRefService::create);

        return ResponseEntity.ok(analyticResourceAssembler.toResource(friendRefService.getTop()));
    }
}