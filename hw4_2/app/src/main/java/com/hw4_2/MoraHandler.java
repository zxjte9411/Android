package com.hw4_2;

public class MoraHandler {
    String Mora(int player, int iComPlay) {
        String result = "";
        // 1 – 剪刀, 2 – 石頭, 3 – 布.
        if (player == 0) {
            if (iComPlay == 0)
                result = "draw";
            else if (iComPlay == 1)
                result = "lose";
            else if (iComPlay == 2)
                result = "win";
        } else if (player == 1) {
            if (iComPlay == 0)
                result = "win";
            else if (iComPlay == 1)
                result = "draw";
            else if (iComPlay == 2)
                result = "lose";
        } else if (player == 2) {
            if (iComPlay == 0)
                result = "lose";
            else if (iComPlay == 1)
                result = "win";
            else if (iComPlay == 2)
                result = "draw";
        }
        return result;
    }
}
