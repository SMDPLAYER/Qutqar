package uz.smd.hakaton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        startFragment()
    }
    private fun startFragment() {
        val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.layoutFragment, MainFragment()).commit ()

    }
}