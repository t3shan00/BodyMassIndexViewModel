package com.example.bodymassindexviewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.viewmodel.compose.viewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bodymassindexviewmodel.ui.theme.BodyMassIndexViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BodyMassIndexViewModelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bmi(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            }
        }
    }

@Composable
fun Bmi(viewModel: BmiViewModel = viewModel(), @SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    Column (modifier = modifier.padding(16.dp)) {
        Text (
            text = stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        OutlinedTextField(
            value = viewModel.heightInput,
            onValueChange = {
                viewModel.heightInput = it.replace(',','.')
                viewModel.calculateBmi()
                            },
            label = {Text(stringResource(R.string.height_meters))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )
        OutlinedTextField(
            value = viewModel.weightInput,
            onValueChange = {
                viewModel.weightInput = it.replace(',','.')
                viewModel.calculateBmi()
                            },
            label = {Text(stringResource(R.string.weight_kg))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )
        Text(
            text = "${stringResource(R.string.body_mass_index_is)} ${viewModel.bmi}",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)
        )
    }
}