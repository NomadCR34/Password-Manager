package ir.aminr.passwordmanager.view.navigarion

sealed class Screen(val route:String){
    object MainScreen:Screen("main_screen")
    object CreateScreen:Screen("create_screen")
}
