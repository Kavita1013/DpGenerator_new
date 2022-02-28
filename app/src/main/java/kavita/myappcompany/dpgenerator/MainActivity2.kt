package kavita.myappcompany.dpgenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kavita.myappcompany.dpgenerator.Fragments.DownloadsFragment
import kavita.myappcompany.dpgenerator.Fragments.Home1Fragment
import kavita.myappcompany.dpgenerator.Fragments.ProfileFragment

class MainActivity2 : AppCompatActivity() {
    private var bottomNavigation: BottomNavigationView? = null
    private var activeFragment: Fragment? = null
    private val Home1Fragment: Home1Fragment = Home1Fragment()
    private val DownloadsFragment: DownloadsFragment = DownloadsFragment()

    private val ProfileFragment: ProfileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
       // setSupportActionBar(toolbar)
        bottomNavigation = findViewById(R.id.bottom_nav_bar)
        bottomNavigation()
        if (savedInstanceState == null) {
            val fragment = Home1Fragment()
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.javaClass.getSimpleName())
                .commit()
        }
    }

    private fun bottomNavigation() {
        /*supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, DownloadsFragment)
            .hide(DownloadsFragment).commit()

        supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, ProfileFragment)
            .hide(ProfileFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, Home1Fragment).commit()
        activeFragment = Home1Fragment
        bottomNavigation?.setSelectedItemId(R.id.nav_home)*/


        val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.nav_home -> {

                        val fragment = Home1Fragment()
                        supportFragmentManager.beginTransaction().replace(
                            R.id.nav_host_fragment,
                            fragment,
                            fragment.javaClass.getSimpleName()
                        )
                            .commit()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.nav_downloads -> {
                        val fragment = DownloadsFragment()
                        supportFragmentManager.beginTransaction().replace(
                            R.id.nav_host_fragment,
                            fragment,
                            fragment.javaClass.getSimpleName()
                        )
                            .commit()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.nav_profile -> {
                        val fragment = ProfileFragment()
                        supportFragmentManager.beginTransaction().replace(
                            R.id.nav_host_fragment,
                            fragment,
                            fragment.javaClass.getSimpleName()
                        )
                            .commit()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }
        bottomNavigation?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        /*bottomNavigation?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            Handler().post {
                var selectedFragment: Fragment = Home1Fragment
                when (item.itemId) {
                    R.id.nav_home -> selectedFragment = Home1Fragment
                    R.id.nav_downloads -> selectedFragment = DownloadsFragment
                    R.id.nav_profile -> selectedFragment = ProfileFragment
                }
                if (selectedFragment !== activeFragment) {
                    //Bundle bundle = new Bundle();
                    //bundle.putString("idToken", Mainid);
                    //SelectedFragment.setArguments(bundle);
                    supportFragmentManager
                        .beginTransaction()
                        .show(selectedFragment)
                        .hide(activeFragment as Home1Fragment)
                        .commit()
                    activeFragment = selectedFragment
                }
            }
            true
        })
    }*/
    }
}