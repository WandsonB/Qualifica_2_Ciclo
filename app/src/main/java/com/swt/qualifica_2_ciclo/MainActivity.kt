package com.swt.qualifica_2_ciclo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabItem

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  buttonFeed: Button

    private lateinit var feedFragment: Feed_Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFeed = findViewById(R.id.button)
        buttonFeed.setOnClickListener(this)

        feedFragment = Feed_Fragment()

        setFragment(feedFragment)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_fragments, fragment)
        fragmentTransition.commit()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                setFragment(feedFragment)
            }
        }
    }
}
