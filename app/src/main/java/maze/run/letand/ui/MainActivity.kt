package maze.run.letand.ui

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import maze.run.letand.R

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var navController: NavController
    lateinit var appBarConfiguration2: AppBarConfiguration
    lateinit var navigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        navigationView = findViewById<BottomNavigationView>(R.id.bootomnavigationview)
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration2 = AppBarConfiguration(
            setOf(
                R.id.homeFragmentnav,
                R.id.cartFragmentnav,
                R.id.saveFavFragmentnav,
                R.id.profileFragmentnav
            )
        )
        navigationView.setupWithNavController(navController)
    }



    override fun onSupportNavigateUp(): Boolean {
      val navController = findNavController(R.id.nav_host_fragment)

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}