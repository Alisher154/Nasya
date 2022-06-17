package uz.texnopos.nasya.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.uznewmax.auth.ui.AuthScreens
import dagger.hilt.android.AndroidEntryPoint
import uz.texnopos.nasya.R
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = object : AppNavigator(this, R.id.main_container) {

        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
        }

        override fun setupFragmentTransaction(
            screen: FragmentScreen,
            fragmentTransaction: FragmentTransaction,
            currentFragment: Fragment?,
            nextFragment: Fragment
        ) {
            fragmentTransaction.setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            super.setupFragmentTransaction(
                screen,
                fragmentTransaction,
                currentFragment,
                nextFragment
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            navigator.applyCommands(arrayOf<Command>(Replace(AuthScreens.LoginScreen())))
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}