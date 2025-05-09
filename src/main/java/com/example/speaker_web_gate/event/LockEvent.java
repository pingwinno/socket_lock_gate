package com.example.speaker_web_gate.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LockEvent extends ApplicationEvent {
    private final String state;

    public LockEvent(Object source, String state) {
        super(source);
        this.state = state;
    }

}
