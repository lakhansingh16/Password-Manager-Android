package com.example.passwordgenerator.models

class NumericGenerator : PasswordGenerator() {
    private val CHAR_0 = '0'
    private val CHAR_9 = '9'

    override fun getChar(): String {
        return Helper.randomChar(CHAR_0.code, CHAR_9.code).toChar().toString()
    }
}
