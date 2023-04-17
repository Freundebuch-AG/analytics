package com.freundebuchag.analytics;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.freundebuchag.analytics.FriendRef.FriendRef;
import com.freundebuchag.analytics.FriendRef.FriendRefService;
import com.freundebuchag.analytics.TopLongDino.TopLongDinoResource;
import com.freundebuchag.analytics.TopLongDino.TopLongDinoResourceAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/dino")
@RequiredArgsConstructor
public class AnalyticController {

    private final TopLongDinoResourceAssembler topLongDinoResourceAssembler;

    private final FriendRefService friendRefService;

    @GetMapping
    public ResponseEntity<TopLongDinoResource> getTopLongDino() {

        String url = "http://localhost:8080/friend";

        try{
            HttpRequest getFriends = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(getFriends, HttpResponse.BodyHandlers.ofString());

            String responseJson = httpResponse.body();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            ArrayNode arrayNode =  (ArrayNode) objectMapper.readTree(responseJson);

            List<FriendRef> friendRefsList = new ArrayList<>();

            for (int i = 0; i < arrayNode.size(); i++) {
                FriendRef friendRef = objectMapper.treeToValue(arrayNode.get(i), FriendRef.class);
                friendRefsList.add(friendRef);
            }

            friendRefsList.stream().map(friend -> {
                FriendRef friendRef = new FriendRef();
                friendRef.setId(friend.getId());
                friendRef.setFirstName(friend.getFirstName());
                friendRef.setLastName(friend.getLastName());
                friendRef.setBday(friend.getBday());
                friendRef.setFood(friend.getFood());
                friendRef.setAnimal(friend.getAnimal());
                friendRef.setDino(friend.getDino());
                return friendRef;
            }).forEach(friendRefService::create);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        } catch (InterruptedException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


        return ResponseEntity.ok(topLongDinoResourceAssembler.toTopLongDino(friendRefService.getTop()));
    }
}