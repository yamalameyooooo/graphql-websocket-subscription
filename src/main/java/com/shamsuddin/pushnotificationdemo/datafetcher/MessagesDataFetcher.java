package com.shamsuddin.pushnotificationdemo.datafetcher;

import com.netflix.graphql.dgs.*;
import com.shamsuddin.pushnotificationdemo.types.TextMessageInput;
import com.shamsuddin.pushnotificationdemo.types.TextMessage;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

import java.util.*;

@DgsComponent
public class MessagesDataFetcher {

    private final Many<TextMessage> sink = Sinks.many().replay().latest();
    private static final Map<String, TextMessage> STORE = new HashMap<>();

    @DgsQuery
    public Collection<TextMessage> messages() {
        return STORE.values();
    }

    @DgsMutation
    public TextMessage send(@InputArgument("message") TextMessageInput message) {
        TextMessage msg = new TextMessage(
                UUID.randomUUID().toString(),
                message.getBody()
        );
        STORE.put(msg.getId(), msg);
        sink.emitNext(msg, Sinks.EmitFailureHandler.FAIL_FAST);
        return msg;
    }

    @DgsSubscription
    public Publisher<TextMessage> messageSent(@InputArgument("userName") String userName) {
        return sink.asFlux();
    }

}
