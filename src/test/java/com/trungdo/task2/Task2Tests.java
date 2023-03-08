package com.trungdo.task2;

import org.junit.jupiter.api.Test;

public class Task2Tests {

    @Test
    void test() {
        assert Task2.findSubArray(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}) == 0;
        assert Task2.findSubArray(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3}) == 0;
        assert Task2.findSubArray(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5, 6}) == -1;
        assert Task2.findSubArray(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 6}) == -1;
        assert Task2.findSubArray(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5}) == 2;
        assert Task2.findSubArray(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4}) == 2;
        assert Task2.findSubArray(new int[]{1, 2, 3, 4, 5}, new int[]{3}) == 2;
    }
}
