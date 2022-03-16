package com.example.hw10_q2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw10_q2.databinding.FragmentAnswerBinding

class AnswerFragment : Fragment() {
    lateinit var binding: FragmentAnswerBinding
    val mQuestionBank: Array<Answer> = arrayOf<Answer>(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentAnswerBinding.inflate(layoutInflater)
        return binding.root
        //inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var extraMessage=requireArguments().getInt("id")
        binding.button6.setOnClickListener {
            binding.textView2.visibility= View.VISIBLE
            val question=mQuestionBank[extraMessage].isTrueQuestion()
            binding.textView2.setText(question.toString())
        }
    }

}