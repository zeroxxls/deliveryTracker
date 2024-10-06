package com.example.deliverytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliverytracker.ui.theme.DeliveryTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DeliverySteps()
                }
            }
        }
    }
}

@Composable
fun DeliverySteps(modifier: Modifier = Modifier) {
    val steps = listOf(
        StepInfo("Заказ принят", R.drawable.step1),
        StepInfo("Заказ упакован", R.drawable.step2),
        StepInfo("Заказ отправлен", R.drawable.step3),
        StepInfo("Заказ в пути", R.drawable.step4),
        StepInfo("Заказ доставлен", R.drawable.step5)
    )

    var currentStep by remember { mutableStateOf(0) }
    val step = steps[currentStep]

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(step.imageResId),
            contentDescription = step.description
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = step.description,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            currentStep = (currentStep + 1) % steps.size
        }) {
            Text(text = "Следующий этап")
        }
    }
}

data class StepInfo(val description: String, val imageResId: Int)

@Preview(showBackground = true)
@Composable
fun DeliveryTrackerPreview() {
    DeliveryTrackerTheme {
        DeliverySteps()
    }
}

