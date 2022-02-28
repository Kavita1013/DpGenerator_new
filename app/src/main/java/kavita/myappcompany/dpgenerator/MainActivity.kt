package kavita.myappcompany.dpgenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kavita.myappcompany.dpgenerator.Fragments.OnBoarding1Fragment

class MainActivity : AppCompatActivity() {
    var fragmentOnBoarding: Fragment? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentOnBoarding =OnBoarding1Fragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout, fragmentOnBoarding as OnBoarding1Fragment).commit()
    }
}