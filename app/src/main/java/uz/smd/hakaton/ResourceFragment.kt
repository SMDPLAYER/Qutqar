package uz.smd.hakaton

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class ResourceFragment :Fragment(R.layout.fragment_resource){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(),"Malumotni yuklashni iloji bulmadi",Toast.LENGTH_SHORT).show()
    }
}