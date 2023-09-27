package com.littlelemon.littlelemoningredients.icecreammachine

class Engine(/* Engine dependencies here */) {

    fun powerUp() {

    }

    fun getVoltage(): String {
        return ""
    }
}



class IceCreamMachine(
    private val engine: Engine
) {

    fun powerUp(){
        engine.powerUp()
    }
}