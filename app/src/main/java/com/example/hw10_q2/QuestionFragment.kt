package com.example.hw10_q2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hw10_q2.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
lateinit var binding:FragmentQuestionBinding
    var trueAnswer=0
    var falseAnswer=0
   //var viewModel= ViewModelProvider(requireActivity()).get(QuestionFragmentViewModel::class.java)
    val viewModel:QuestionFragmentViewModel by viewModels()

    var index=0
    var cheat=true
    var mQuestionBank=  arrayListOf<Answer>(
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
        binding= FragmentQuestionBinding.inflate(layoutInflater)
        return binding.root
        //inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        index=viewModel.indexOfQuestion
        mQuestionBank=viewModel.arrayQ
        updateQuestion()
        binding.buttonCheat.setOnClickListener {
            getInit()
        }
        binding.buttonNext.setOnClickListener {
            index=(index+1)%mQuestionBank.size
            viewModel.addNext(index)
            cheat=false
            updateQuestion()

        }
        binding.buttonprev.setOnClickListener {
            index = (index - 1) % mQuestionBank.size
            viewModel.addNext(index)
            cheat = false
            updateQuestion()
        }
        binding.buttonTrue.setOnClickListener {
            checkA(true)
        }
        binding.buttonFalse.setOnClickListener {
            checkA(false)
        }

    }
    private fun checkA(b: Boolean) {
        val c=mQuestionBank[index].isTrueQuestion()
        val id=0
        if(b==mQuestionBank[index].isTrueQuestion()) {
            Toast.makeText(activity, "correct!", Toast.LENGTH_LONG).show()
            trueAnswer++
        } else{
            Toast.makeText(activity,"wrong!", Toast.LENGTH_LONG).show()
            falseAnswer++
        }



    }

    private fun updateQuestion() {
        val question=mQuestionBank[index].getQuestion()
        binding.text.setText(question)

    }

    private fun getInit() {
        var bindle= bundleOf("id" to index)
        findNavController().navigate(R.id.action_questionFragment_to_answerFragment,bindle)

    }

}