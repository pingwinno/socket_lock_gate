package com.example.speaker_web_gate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeakerWebGateApplicationTest {

    @Test
    void test(){
       var result = method(10);
        System.out.println(result);
    }

    static int method(int i) {
        return i++ + i++ - 2 * i--;
    }
}