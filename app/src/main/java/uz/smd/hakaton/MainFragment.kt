package uz.smd.hakaton

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import uz.smd.hakaton.test.QuizFragment
import uz.smd.hakaton.utils.next
import uz.smd.hakaton.utils.sweatAlertDialog

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickListener()
    }

    fun clickListener() {
        btnHelp.setOnClickListener { sweatAlertDialog() }
        btnResource.setOnClickListener {
            next(ResourceFragment(),"r")
//            val intent = Intent(requireActivity(), Yandex::class.java)
//            startActivity(intent)
        }
        btnTest.setOnClickListener {
            next(QuizFragment(), "q")
        }
    }


}
