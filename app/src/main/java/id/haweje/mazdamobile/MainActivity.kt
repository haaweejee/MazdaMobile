package id.haweje.mazdamobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var homeFragment: HomeFragment
    private lateinit var profileFragment: ProfileFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())


        val bottomNav : BottomNavigationView = findViewById(R.id.bottomNavMenu)

        homeFragment = HomeFragment()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.homePage ->{
                    homeFragment = HomeFragment()
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.frameLayout, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()
                }
                R.id.profilePage ->{
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.frameLayout, profileFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()
                }
            }

            true
        }
    }
}