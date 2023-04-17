package com.freundebuchag.analytics.TopLongDino;

import com.freundebuchag.analytics.FriendRef.FriendRef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Builder
public class TopLongDinoResourceAssembler {

    public TopLongDinoResource toTopLongDino(FriendRef topLongDino) {
        return TopLongDinoResource.builder()
                .id(topLongDino.getId())
                .firstName(topLongDino.getFirstName())
                .lastName(topLongDino.getLastName())
                .dino(topLongDino.getDino())
                .build();
    }
}
