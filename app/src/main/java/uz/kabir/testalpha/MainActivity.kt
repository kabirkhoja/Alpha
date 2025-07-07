package uz.kabir.testalpha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.kabir.testalpha.presentation.AppNavGraph
import uz.kabir.testalpha.ui.theme.TestAlphaTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAlphaTheme {
                Surface {
                    AppNavGraph(navController = rememberNavController())
                }
            }
        }
    }
}