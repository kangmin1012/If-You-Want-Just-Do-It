package kang.min.userinfo.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ifyouwant.justdo.ui.IfYouWantTheme
import kang.min.userinfo.R
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdayInfoScreen() {

    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 100.dp),
            painter = painterResource(id = R.drawable.img_birthday_cake),
            contentDescription = "생일 타이틀 이미지"
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "생년월일을 선택해주세요", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "나이 : NN살", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { showBottomSheet = true }
            ) {
                Text(text = "선택하기")
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {
                        coroutineScope.launch { sheetState.hide() }.invokeOnCompletion {
                            showBottomSheet = false
                        }
                    },
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(text = "선택")
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NumberPickerSpinner(
    items: List<String>,
    modifier: Modifier = Modifier,
    startIndex: Int = 0,
    visibleItemsCount: Int = 3,
) {
    var selectedItem by remember { mutableStateOf("") }
    val visibleItemsMiddle = visibleItemsCount / 2
    val listScrollCount = Integer.MAX_VALUE
    val listScrollMiddle = listScrollCount / 2
    val listStartIndex = listScrollMiddle - listScrollMiddle % items.size - visibleItemsMiddle + startIndex

    val listState = rememberLazyListState(initialFirstVisibleItemIndex = listStartIndex)
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)

    var itemHeight by remember { mutableIntStateOf(0) }

    val fadingEdgeGradient = remember {
        Brush.verticalGradient(
            0f to Color.Transparent,
            0.5f to Color.Black,
            1f to Color.Transparent
        )
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .map { index ->
                items[(index + visibleItemsMiddle) % items.size]
            }
            .distinctUntilChanged()
            .collect { item -> selectedItem = item }
    }

    Box(modifier = modifier) {

        LazyColumn(
            state = listState,
            flingBehavior = flingBehavior,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight.dp * visibleItemsCount)
                .graphicsLayer { compositingStrategy = CompositingStrategy.Offscreen }
                .drawWithContent {
                    drawContent()
                    drawRect(brush = fadingEdgeGradient, blendMode = BlendMode.DstIn)
                }
        ) {
            items(listScrollCount) { index ->
                Text(
                    text = items[(index) % items.size],
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 32.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .onSizeChanged { size -> itemHeight = size.height }
                        .padding(8.dp)
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.offset(y = itemHeight.dp * visibleItemsMiddle),
            color = Color.White
        )

        HorizontalDivider(
            color =  Color.White,
            modifier = Modifier.offset(y = itemHeight.dp * (visibleItemsMiddle + 1))
        )

    }

}

@Composable
@Preview(showBackground = true)
private fun BirthdayInfoScreenPreview() {
    IfYouWantTheme {
        BirthdayInfoScreen()
    }
}

@Composable
@Preview
private fun NumberPickerSpinnerPreview() {
    IfYouWantTheme {
        NumberPickerSpinner(
            items = (1..99).map {it.toString()},
        )
    }
}