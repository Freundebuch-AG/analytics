package com.freundebuchag.analytics;

import com.freundebuchag.analytics.FriendRef.FriendRef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Builder
public class AnalyticResourceAssembler {

    private final AnalyticService analyticService;

    public AnalyticResource toResource(FriendRef topLongDino) {
        return AnalyticResource.builder()
                .id(topLongDino.getId())
                .dino(topLongDino.getDino())
                .build();
    }
}
