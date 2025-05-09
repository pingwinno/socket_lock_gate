package com.example.speaker_web_gate.service;

import com.example.speaker_web_gate.event.LockEvent;
import com.example.speaker_web_gate.gateway.MqttGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MqttService {

    private final MqttGateway mqttGateway;
    private final ApplicationEventPublisher applicationEventPublisher;


    @EventListener(LockEvent.class)
    public void sentSpeakerParameterUpdate(LockEvent lockEvent) {
        log.info("Sending settings event to mqtt: {}", lockEvent.getState());
        mqttGateway.sendMessage("/lock", 2, lockEvent.getState());
    }

}
