package com.example.hw10_q2

class Answer(q1: Int, b: Boolean) {
    var mQuestion = 0
    var mTrueQuestion = false
    init {
        mQuestion = q1
        mTrueQuestion = b
    }
    fun getQuestion(): Int {
        return mQuestion
    }
    fun isTrueQuestion(): Boolean {
        return mTrueQuestion
    }
}