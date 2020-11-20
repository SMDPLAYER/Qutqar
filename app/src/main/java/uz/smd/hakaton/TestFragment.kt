package uz.smd.hakaton

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_test.*
import uz.smd.hakaton.local.LocalStorage
import uz.smd.hakaton.utils.gone
import uz.smd.hakaton.utils.next
import uz.smd.hakaton.utils.show

class TestFragment : Fragment(R.layout.fragment_test) {
    val local = LocalStorage.instance
    var results: Int = 0
    var result1: Int = 0
    var result2: Int = 0
    var position: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        load()

    }

    private fun load() {
        when (local.quiz) {
            1 -> {
                count.text = "/" + listData1.size
                quiz5.gone()
                pos()
                quiz1.setOnClickListener { click(4) }
                quiz2.setOnClickListener { click(3) }
                quiz3.setOnClickListener { click(2) }
                quiz4.setOnClickListener { click(1) }
            }
            2 -> {
                count.text = "/" + listData2.size
                quiz5.show()
                pos2()
                quiz1.setOnClickListener { click2(5) }
                quiz2.setOnClickListener { click2(4) }
                quiz3.setOnClickListener { click2(3) }
                quiz4.setOnClickListener { click2(2) }
                quiz5.setOnClickListener { click2(1) }
            }
            3 -> {
                count.text = "/" + listData2.size
                quiz5.show()
                pos2()
                quiz1.setOnClickListener { click2(5) }
                quiz2.setOnClickListener { click2(4) }
                quiz3.setOnClickListener { click2(3) }
                quiz4.setOnClickListener { click2(2) }
                quiz5.setOnClickListener { click2(1) }
            }
            4 -> {
                count.text = "/" + listData4.size
                quiz5.gone()
                pos4()
                quiz1.setOnClickListener { click4(4) }
                quiz2.setOnClickListener { click4(3) }
                quiz3.setOnClickListener { click4(2) }
                quiz4.setOnClickListener { click4(1) }
            }
        }

    }

    private fun click4(grade: Int) {
        results += if (position == 3 || position == 5|| position == 7|| position == 9|| position == 12) {
            6 - grade
        } else grade
        position++
        if (position == listData4.size) {
            local.result = (results*100/48)
            next(ResultFragment())
        } else {
            pos4()
        }
    }

    private fun click2(grade: Int) {
        results += if (position == 1 || position == 4) {
            6 - grade
        } else grade
        position++
        if (position == listData2.size) {
            local.result = (results*10/3)
            next(ResultFragment())
        } else {
            pos2()
        }
    }

    private fun click(grade: Int) {
        if (position > 11) {
            result1 += grade
        } else {
            result2 += grade
        }
        results += grade
        position++
        if (position == listData1.size) {
            local.result = (results *25)/ listData1.size
            local.result1 = (result1 *25)/ 8
            local.result2 = (result2*25) / 12
            next(ResultFragment())
        } else {
            pos()
        }
    }

    private fun pos() {
        number.text = (position + 1).toString()
        quiz.text = listData1[position].question
        quiz1.text = listData1[position].answer1
        quiz2.text = listData1[position].answer2
        quiz3.text = listData1[position].answer3
        quiz4.text = listData1[position].answer4

    }
    private fun pos4() {
        number.text = (position + 1).toString()
        quiz.text = listData4[position].question
        quiz1.text = listData4[position].answer1
        quiz2.text = listData4[position].answer2
        quiz3.text = listData4[position].answer3
        quiz4.text = listData4[position].answer4

    }

    private fun pos2() {
        number.text = (position + 1).toString()
        quiz.text = listData2[position].question
        quiz1.text = listData2[position].answer1
        quiz2.text = listData2[position].answer2
        quiz3.text = listData2[position].answer3
        quiz4.text = listData2[position].answer4
        quiz5.text = listData2[position].answer5


    }
}
