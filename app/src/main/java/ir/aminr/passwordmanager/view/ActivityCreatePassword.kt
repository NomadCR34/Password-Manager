package ir.aminr.passwordmanager.view

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ir.aminr.passwordmanager.R
import ir.aminr.passwordmanager.view.navigarion.Screen
import ir.aminr.passwordmanager.view.theme.PasswordManagerTheme


class ActivityCreatePassword : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}

@Composable
fun CreateScreen(navController: NavController){
    PasswordManagerTheme {
        AppBarCreateScreen(navController)
    }
}

@Composable()
fun AppBarCreateScreen(navController: NavController) {
    Scaffold() {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 4.dp,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Text(
                    text = stringResource(R.string.createPassword),
                    color = MaterialTheme.colors.secondary,
                )
            }

        }
    }
}

