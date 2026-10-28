package com.example.kotlinemodule2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

/**
 * Задание 2:
 * Создайте для функции HelloPreview из предыдущего урока три макета предпросмотра с показом системного UI:
 * - portrait — с портретной ориентацией экрана.
 * - landscape — с альбомной ориентацией экрана.
 * - round — с круглым дисплеем размером 200dpx200dp, а также жёлтым задним фоном.
 */

@Composable
fun HelloPreviewContent() {
    Hello(name = "Android")
}

@Preview(
    name = "portrait",
    showSystemUi = true,
    device = Devices.PHONE
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = "spec:width=891dp,height=411dp,orientation=landscape,dpi=420"
)
@Composable
fun HelloPreview() {
    HelloPreviewContent()
}

@Preview(
    name = "round",
    showSystemUi = true,
    device = "spec:width=200dp,height=200dp,isRound=true",
    showBackground = true,
    backgroundColor = 0xFFFFFF00
)
@Composable
fun HelloPreviewRound() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Yellow
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            HelloPreviewContent()
        }
    }
}
