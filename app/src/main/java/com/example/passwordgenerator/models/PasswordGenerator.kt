package com.example.passwordgenerator.models

import java.util.ArrayList
abstract class PasswordGenerator {
    abstract fun getChar(): String
    companion object {
        var generators: ArrayList<PasswordGenerator> = ArrayList()
        fun clear() {
            generators.clear()
        }

        fun isEmpty(): Boolean {
            return generators.isEmpty()
        }

        fun add(pwdg: PasswordGenerator) {
            generators.add(pwdg)
        }

        private fun getRandomPassGen(): PasswordGenerator {
            if (generators.isEmpty()) {
                add(LowerCaseGenerator())
            }
            return if (generators.size == 1) generators[0]
            else generators[Helper.randomVal(generators.size)]
        }
        fun generatePassword(sizeOfPassword: Int): String {
            var size = sizeOfPassword
            val password = StringBuilder()

            while (size != 0) {
                password.append(getRandomPassGen().getChar())
                size--
            }
            return password.toString()
        }
    }
}