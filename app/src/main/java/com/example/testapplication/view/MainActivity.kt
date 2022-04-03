package com.example.testapplication.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.testapplication.R
import com.example.testapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.characterListFragment, R.id.episodeFragment))

        navController.addOnDestinationChangedListener { _, destination, _ ->
            run {
                when (destination.id) {
                    R.id.characterFragment -> {
                        binding.bottomNav.visibility = View.GONE
                        // binding.toolbar.visibility = View.GONE
                    }
                    R.id.testiFragment -> {
                        binding.bottomNav.visibility = View.GONE
                        binding.toolbar.visibility = View.GONE
                    }
                    else -> {
                        binding.bottomNav.visibility = View.VISIBLE
                        binding.toolbar.visibility = View.VISIBLE
                    }
                }
            }
        }

        onSupportNavigateUp()

        with(binding) {
            setSupportActionBar(toolbar)
            bottomNav.setupWithNavController(navController)
            toolbar.setupWithNavController(navController, appBarConfiguration)
        }
    }
}