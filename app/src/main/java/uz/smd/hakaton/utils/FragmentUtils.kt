package uz.smd.hakaton.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.transition.MaterialSharedAxis
import uz.smd.hakaton.R

fun Fragment.next(fragment: Fragment){
fragmentManager?.beginTransaction()
//?.setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
?.replace(R.id.layoutFragment, fragment)

?.commit()
}
fun Fragment.next(fragment: Fragment,name:String){
    fragmentManager?.beginTransaction()
//        ?.setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
        ?.replace(R.id.layoutFragment, fragment)
        ?.addToBackStack(name)
        ?.commit()
}
fun Fragment.last(fragment: Fragment){
    fragmentManager?.beginTransaction()
        ?.replace(R.id.layoutFragment, fragment)
        ?.addToBackStack(null)
        ?.commit()
}

fun Fragment.animateSlide(){
    val backward = MaterialSharedAxis(MaterialSharedAxis.Z, false)
    val forward = MaterialSharedAxis(MaterialSharedAxis.Z, true)
    reenterTransition = backward
    exitTransition = forward
    enterTransition = forward
    returnTransition = backward

}
fun Fragment.onBackPressed(){
    requireActivity().onBackPressed()
}
fun Fragment.sweatAlertDialog() {
    SweetAlertDialog(view!!.context, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
        .setCustomImage(R.drawable.bg_btn_info)
        .setTitleText("Habar junatildi qushimcha choralar kurilsinmi")
        .setConfirmText("Ha")
        .setCancelButton("Yo\'q") { obj: SweetAlertDialog -> obj.dismissWithAnimation() }
        .setConfirmClickListener { sweetAlertDialog: SweetAlertDialog ->
            sweetAlertDialog.dismissWithAnimation()
            Toast.makeText(
                requireContext(),
                "Birinchi darajali havf rejimi faollashtirildi",
                Toast.LENGTH_SHORT
            ).show()
        }.show()
}
