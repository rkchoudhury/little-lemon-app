package com.littlelemon.littlelemoningredients.icecreammachine

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.given
import org.mockito.kotlin.verifyNoInteractions

class IceCreamMachineTest {
    val mockEngine: Engine = mock()
    val classUnderTest = IceCreamMachine(mockEngine)

    @Test
    fun power_up_engine() {
        classUnderTest.powerUp()

        verify(mockEngine).powerUp()
    }

    @Test
    fun mock_voltage() {
        given { mockEngine.getVoltage() }.willReturn("Some value")

        verifyNoInteractions(mockEngine)
    }
}