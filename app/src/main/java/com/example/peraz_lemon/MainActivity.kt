package com.example.peraz_lemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.peraz_lemon.ui.theme.Peraz_LemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Peraz_LemonTheme {
                // A surface container using the 'background' color from the theme
               LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    var stepTerkini by remember {
        mutableStateOf(1)
    }
    var perasanLemon by remember {
        mutableStateOf(1)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (stepTerkini) {
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(id = R.string.pilih_lemon))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = stringResource(id = R.string.pohon_lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                stepTerkini = 2
                            }
                    )
                }
            }
            2 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(id = R.string.tap_tap_lemon))
                    Text(text = "power "+perasanLemon)
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.lemon_squeeze),
                        contentDescription = stringResource(id = R.string.lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                perasanLemon += (1..10).random()
                                if (perasanLemon >= 100) {
                                    stepTerkini = 3
                                }
                            }
                    )
                }
            }
            3 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = stringResource(id = R.string.minum_lemon)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.lemon_drink),
                        contentDescription = stringResource(id = R.string.gelas_lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                stepTerkini = 4
                                perasanLemon = 1
                            }
                    )
                }
            }
            4 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = stringResource(id = R.string.mulai_lagi)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.lemon_restart),
                        contentDescription = stringResource(id = R.string.gelas_kosong),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                stepTerkini = 1
                            }
                    )
                }
            }
        }
    }
}

