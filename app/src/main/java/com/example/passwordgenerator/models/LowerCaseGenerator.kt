package com.example.passwordgenerator.models

class LowerCaseGenerator : PasswordGenerator() {
    private val CHAR_A = 'a'
    private val CHAR_Z = 'z'

    override fun getChar(): String {
        return Helper.randomChar(CHAR_A.code, CHAR_Z.code).toChar().toString()
    }
}
