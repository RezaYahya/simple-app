package com.example.userfriendly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<MeowBottomNavigation>(R.id.mbn)

        setFragment(HomeFragment.newIntance())

        navigation.add(MeowBottomNavigation.Model(1,R.drawable.home))
        navigation.add(MeowBottomNavigation.Model(2,R.drawable.person))

        navigation.setOnClickMenuListener {
            when(it.id){
                1 -> setFragment(HomeFragment.newIntance())
                2 -> setFragment(AddFragment.newIntance())

                else -> ""
            }
        }
        navigation.show(1)

    }

    fun setFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout,fragment,"mainActivity")
            .commit()
    }

}
