package com.example.passwordgenerator.models

class UpperCaseGenerator : PasswordGenerator() {
    companion object {
        private const val CHAR_A = 'A'
        private const val CHAR_Z = 'Z'
    }

    override fun getChar(): String {
        return ((Helper.randomChar(CHAR_A.code, CHAR_Z.code)).toChar()).toString()
    }
}