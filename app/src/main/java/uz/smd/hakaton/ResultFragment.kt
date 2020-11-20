package uz.smd.hakaton

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_result.*
import uz.smd.hakaton.local.LocalStorage
import uz.smd.hakaton.utils.gone
import uz.smd.hakaton.utils.next
import uz.smd.hakaton.utils.show

class ResultFragment : Fragment(R.layout.fragment_result) {
    private val local = LocalStorage.instance
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        load()
    }

    fun load() {
        when (local.quiz) {
            1 -> {
                result3.text = "${local.result}%"
                result2.text = "${local.result2}%"
                result1.text = "${local.result1}%"
            }
            2 -> {
                result3.text = "${local.result}%"
                result2.gone()
                res1.gone()
                res2.gone()
                result1.gone()
            }
            3->{
                result3.text = "${local.result}%"
                result2.text = "${local.result2}%"
                result1.text = "${local.result1}%"
            }
            4->{
                result3.text = "${local.result}%"
                result2.gone()
                res1.gone()
                res2.gone()
                result1.gone()
            }
        }
        if (local.result < 50) {
            emotion.visibility = View.VISIBLE
            cardBtn.gone()
        } else {
            cardBtn.show()
            emotion.visibility = View.GONE
        }
        cardBtn.setOnClickListener { next(MainFragment()) }
    }

}
