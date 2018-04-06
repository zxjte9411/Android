package com.hw4_2;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoraHandlerTest {
    @Test
    public void MoraHandler(){
        MoraHandler mH = new MoraHandler();
        // 0 – 剪刀, 1 – 石頭, 2 – 布.
        String result = mH.Mora(0,0);
        assertEquals(result,"draw");

        result = mH.Mora(0,1);
        assertEquals(result,"lose");

        result = mH.Mora(0,2);
        assertEquals(result,"win");

        result = mH.Mora(1,0);
        assertEquals(result,"win");

        result = mH.Mora(1,1);
        assertEquals(result,"draw");

        result = mH.Mora(1,2);
        assertEquals(result,"lose");

        result = mH.Mora(2,0);
        assertEquals(result,"lose");

        result = mH.Mora(2,1);
        assertEquals(result,"win");

        result = mH.Mora(2,2);
        assertEquals(result,"draw");
    }
}
