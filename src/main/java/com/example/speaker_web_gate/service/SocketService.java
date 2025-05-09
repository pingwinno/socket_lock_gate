package com.example.speaker_web_gate.service;


import com.example.speaker_web_gate.event.LockEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class SocketService {

    private final ApplicationEventPublisher applicationEventPublisher;


    @ServiceActivator(inputChannel = "tcpInbound")
    public void processSettingsChange(Message<String> message) {
        log.info("Received lock update: {}", message);
        log.info("Setting is : {}", message.getPayload());
        applicationEventPublisher.publishEvent(new LockEvent(this, message.getPayload()));
    }

    @ServiceActivator(inputChannel = "tcpIn.errorChannel")
    public void processErrorMessage(Message<String> message) {
        log.info("Received settings update: {}", message);
        log.info("Setting is : {}", message.getPayload());
    }
}
