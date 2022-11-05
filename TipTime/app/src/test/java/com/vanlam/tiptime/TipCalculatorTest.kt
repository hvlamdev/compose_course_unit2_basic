package com.vanlam.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TipCalculatorTest {

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 10.0
        val tipPercent = 20.00
        val expectedTip = "$2.00"
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}