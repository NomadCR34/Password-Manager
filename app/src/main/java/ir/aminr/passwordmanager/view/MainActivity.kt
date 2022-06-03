package ir.aminr.passwordmanager.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import ir.aminr.passwordmanager.R
import ir.aminr.passwordmanager.view.navigarion.Navigation
import ir.aminr.passwordmanager.view.navigarion.Screen
import ir.aminr.passwordmanager.view.theme.PasswordManagerTheme
import ir.aminr.passwordmanager.viewmodel.PasswordViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: PasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordManagerTheme {
                Navigation()
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

}

@Composable
fun MainScreen(navController: NavController) {
    AppBarMainScreen(navController = navController)
}

@Composable()
fun AppBarMainScreen(navController: NavController) {
    Scaffold() {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 4.dp
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.Passwords),
                    color=MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    tint = MaterialTheme.colors.secondary,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController.navigate(Screen.CreateScreen.route)
                        }
                )
            }

        }
    }
}


