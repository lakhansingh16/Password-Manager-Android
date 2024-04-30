package com.example.passwordgenerator.models

object Helper {
        fun randomVal(size: Int): Int {
        val rand = Math.random()
        return (rand * size).toInt()
        }

        fun randomChar(min: Int, max: Int): Int {
        return randomVal(max - min + 1) + min
        }
}
