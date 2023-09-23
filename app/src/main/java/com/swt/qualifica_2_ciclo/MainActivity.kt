package com.swt.qualifica_2_ciclo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabItem

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  btnFeed: Button
    private lateinit var  btnProfile: Button
    private lateinit var  btnNewPost: Button
    private lateinit var  btnWeb: Button


    private lateinit var feedFragment: Feed_Fragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var newPostFragment: NewPostFragment
    private lateinit var webFragment: WebFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFeed = findViewById(R.id.buttonFeed)
        btnFeed.setOnClickListener(this)

        btnProfile = findViewById(R.id.buttonProfile)
        btnProfile.setOnClickListener(this)

        btnNewPost = findViewById(R.id.buttonNewPost)
        btnNewPost.setOnClickListener(this)

        btnWeb = findViewById(R.id.buttonWeb)
        btnWeb.setOnClickListener(this)

        feedFragment = Feed_Fragment()
        profileFragment = ProfileFragment()
        newPostFragment = NewPostFragment()
        webFragment = WebFragment()

        setFragment(feedFragment)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_fragments, fragment)
        fragmentTransition.commit()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonFeed -> {
                setFragment(feedFragment)
            }
            R.id.buttonProfile -> {
                setFragment(profileFragment)
            }
            R.id.buttonNewPost -> {
                setFragment(newPostFragment)
            }
            R.id.buttonWeb -> {
                setFragment(webFragment)
            }
        }
    }
}
