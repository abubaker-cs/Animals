package org.abubaker.animals.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import org.abubaker.animals.R
import org.abubaker.animals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // binding = ActivityMainBinding.inflate(layoutInflater)
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        // NavigationUI.setupActionBarWithNavController(this, navController)
        navController = findNavController( R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)

    }

    // This will enable < back / up arrow in the Detail Screen only, because listFragment is the parent view
    override fun onSupportNavigateUp(): Boolean {
        // Add the navigate up code and pass the required params. This will navigate the user
        return NavigationUI.navigateUp(navController, null)
    }

}