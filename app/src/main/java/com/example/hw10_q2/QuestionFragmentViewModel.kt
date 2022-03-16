package com.example.hw10_q2

import androidx.lifecycle.ViewModel

class QuestionFragmentViewModel:ViewModel() {
    var indexOfQuestion=0
    var arrayQ= arrayListOf<Answer>(
        Answer(R.string.q1, true),
        Answer(R.string.q2, true),
        Answer(R.string.q3, false),
        Answer(R.string.q4, true),
        Answer(R.string.q5,true),
        Answer(R.string.q6,false),
        Answer(R.string.q7,false),
        Answer(R.string.q8,true),
        Answer(R.string.q9,true),
        Answer(R.string.q10,false)
    )
    fun addNext(indext:Int){
        indexOfQuestion++
    }
}