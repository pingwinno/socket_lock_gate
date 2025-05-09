package com.example.socketLockGate;

import org.junit.jupiter.api.Test;

class SocketLockGateApplicationTest {

    @Test
    void test(){
       var result = method(10);
        System.out.println(result);
    }

    static int method(int i) {
        return i++ + i++ - 2 * i--;
    }
}