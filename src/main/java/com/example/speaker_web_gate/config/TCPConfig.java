package com.example.speaker_web_gate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.serializer.TcpCodecs;

@Configuration
public class TCPConfig {

    @Value("${socket.port}")
    private Integer socketPort;

    @Bean
    public IntegrationFlow server() {
        return IntegrationFlow.from(Tcp.inboundAdapter(Tcp.netServer(socketPort)
                                .deserializer(TcpCodecs.singleTerminator((byte) 0x0A))
                                .serializer(TcpCodecs.lengthHeader1())
                                .backlog(1))
                        .errorChannel("tcpIn.errorChannel")
                        .id("tcpIn"))
                .transform(Transformers.objectToString())
                .channel("tcpInbound")
                .get();
    }

    @Bean
    public IntegrationFlow client() {
        return f -> f.handle(Tcp.outboundGateway(Tcp.nioClient("192.168.0.63", 1000)
                        .deserializer(TcpCodecs.lengthHeader1())
                        .serializer(TcpCodecs.lengthHeader1())))
                .channel("tcpOutBound");

    }
}
