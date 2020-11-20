package uz.smd.hakaton

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_quiz.*
import uz.smd.hakaton.local.LocalStorage
import uz.smd.hakaton.utils.next

class QuizFragment:Fragment(R.layout.fragment_quiz) {
    val local=LocalStorage.instance
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
clickListener()
    }
    fun clickListener(){

        btn1.setOnClickListener {
            local.quiz=1
            next(TestFragment(),"t")
        }
        btn2.setOnClickListener {
            local.quiz=2
            next(TestFragment(),"t")
        }
        btn3.setOnClickListener {
            local.quiz=3
            next(TestFragment(),"t")
        }
        btn4.setOnClickListener {
            local.quiz=4
            next(TestFragment(),"t")
        }
    }
}