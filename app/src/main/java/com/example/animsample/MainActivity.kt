package com.example.animsample

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animsample.ui.theme.AnimSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ship: ImageView = findViewById(R.id.shipView)
        val shipAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.ship_anim)
        ship.startAnimation(shipAnim)

        val lander: ImageView = findViewById(R.id.landerView)
        val landerAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.ship_anim)
        lander.startAnimation(landerAnim)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimSampleTheme {
        Greeting("Android")
    }
}