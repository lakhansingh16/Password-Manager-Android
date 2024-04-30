package com.example.passwordgenerator.models

class SpecialCharGenerator : PasswordGenerator() {
        companion object {
                private val SPECIAL_CHAR_ARRAY = charArrayOf('?', '.', '/', '!', '%', '*', '$', '^', '+', '-', ')', ']', '@', '(', '[', '\'', '{', '}', '#', '<', '>')
        }

        override fun getChar(): String {
                return SPECIAL_CHAR_ARRAY[Helper.randomChar(0, SPECIAL_CHAR_ARRAY.size - 1)].toString()
        }
}