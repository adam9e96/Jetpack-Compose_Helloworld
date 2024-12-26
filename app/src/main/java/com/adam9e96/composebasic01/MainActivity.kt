
package com.adam9e96.composebasic01

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.platform.LocalContext // 추가

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 시스템 창과 앱 콘텐츠를 분리
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            // 앱 전체 테마를 적용
            MaterialTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var count by remember { mutableStateOf(0) }
    val context = LocalContext.current // Context 가져오기

    Scaffold(
        // 필요하다면 topBar, bottomBar 등을 정의할 수 있음
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .statusBarsPadding() // 상태 표시줄 패딩 추가
        ) {
            Text(
                text = "Jetpack Compose",
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "Hello World",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                val newCount = count + 1
                count = newCount
                Toast.makeText(context, "Count: $newCount", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Count: $count")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    MaterialTheme {
        MyApp()
    }
}
