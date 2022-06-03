package ir.aminr.passwordmanager.view.navigarion


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.aminr.passwordmanager.view.CreateScreen
import ir.aminr.passwordmanager.view.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(Screen.CreateScreen.route){
            CreateScreen(navController = navController)
        }
    }
}

