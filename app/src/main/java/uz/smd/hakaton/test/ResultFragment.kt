package uz.smd.hakaton.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_result.*
import uz.smd.hakaton.MainFragment
import uz.smd.hakaton.R
import uz.smd.hakaton.ResourceFragment
import uz.smd.hakaton.data.local.LocalStorage
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
                if (local.result < 50) {
                    emotion.visibility = View.VISIBLE
                    cardBtn.gone()
                } else {
                    cardBtn.show()
                    emotion.visibility = View.GONE
                }
            }
            2 -> {
                basic.text="zo'ravonlik ko'rsatkichi"
                result3.text = "${local.result}%"
                result2.gone()
                res1.gone()
                res2.gone()
                result1.gone()
                if (local.result < 50) {
                    emotion.visibility = View.VISIBLE
                    cardBtn.gone()
                } else {
                    cardBtn.show()
                    emotion.visibility = View.GONE
                }
            }
            3 -> {

                result3.text = "${local.result}%"
                result2.text = "${local.result2}%"
                result1.text = "${local.result1}%"
                if (local.result < 50) {
                    emotion.visibility = View.VISIBLE
                    cardBtn.gone()
                } else {
                    cardBtn.show()
                    emotion.visibility = View.GONE
                }
            }
            4 -> {
                basic.text="Gender stereotipi"
                result3.text = "${local.result}%"
                result2.gone()
                res1.gone()
                res2.gone()
                result1.gone()
                if (local.result < 50) {
                    emotion.visibility = View.VISIBLE
                    cardBtn.gone()
                } else {
                    cardBtn.show()
                    emotion.visibility = View.GONE
                }
            }
            5 -> {
                basic.text="Zo'ravonliksiz strategiyalar"
                result3.text = "${local.result}%"
                result2.gone()
                res1.gone()
                res2.gone()
                result1.gone()
                if (local.result > 50) {
                    emotion.visibility = View.VISIBLE
                    cardBtn.gone()
                } else {
                    cardBtn.show()
                    emotion.visibility = View.GONE
                }
            }
            6 -> {
                basic.text="O'z-o'zini boshqarish istagi"
                result3.text = "${local.result}%"
                result2.gone()
                res1.gone()
                res2.gone()
                result1.gone()
                if (local.result >50) {
                    emotion.visibility = View.VISIBLE
                    cardBtn.gone()
                } else {
                    cardBtn.show()
                    emotion.visibility = View.GONE
                }
            }
            7 -> {
                basic.text="Ijtimoiy mas'uliyat hissi"
                result3.text = "${local.result}%"
                result2.gone()
                res1.gone()
                res2.gone()
                result1.gone()
                if (local.result >50) {
                    emotion.visibility = View.VISIBLE
                    cardBtn.gone()
                } else {
                    cardBtn.show()
                    emotion.visibility = View.GONE
                }
            }
            8 -> {
                basic.text="G'amxo'rlik"
                result3.text = "${local.result}%"
                result2.gone()
                res1.gone()
                res2.gone()
                result1.gone()
                if (local.result > 50) {
                    emotion.visibility = View.VISIBLE
                    cardBtn.gone()
                } else {
                    cardBtn.show()
                    emotion.visibility = View.GONE
                }
            }
        }

        btnR.setOnClickListener { next(ResourceFragment()) }
    }

}
