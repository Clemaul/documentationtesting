package org.sfvl.application;

import org.junit.jupiter.api.Test;
import org.sfvl.doctesting.ApprovalsBase;
import org.sfvl.application.FizzBuzz;

public class FizzBuzzTest extends ApprovalsBase {


    /**
     * When number is not divisible by five or three, returns the number.
     */
    @Test
    public void return_given_number() {
        callFizzBuzzWith(1);
        callFizzBuzzWith(2);
        callFizzBuzzWith(4);
        callFizzBuzzWith(22);
    }

    /**
     * When number is divisible by three, returns Fizz.
     */
    @Test
    public void return_fizz_when_divisible_by_three() {
        callFizzBuzzWith(3);
        callFizzBuzzWith(9);
    }

    /**
     * When number is divisible by five, returns buzz.
     */
    @Test
    public void return_buzz_when_divisible_by_five() {
        callFizzBuzzWith(5);
        callFizzBuzzWith(25);
    }

    /**
     * When number is divisible three and five, returns fizzbuzz.
     */
    @Test
    public void return_fizzbuzz_when_divisible_by_three_and_five() {
        callFizzBuzzWith(15);
        callFizzBuzzWith(60);
    }


    private void callFizzBuzzWith(int value) {
        write(String.format("FizzBuzz(%d) = %s +\n ", value, FizzBuzz.get(value)));
    }


}