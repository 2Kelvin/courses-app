package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.data.Course
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp(modifier: Modifier = Modifier) {
    //
}

// reusable course composable
@Composable
fun OneCourse(course: Course, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(68.dp)
    ) {
        Image(
            painter = painterResource(id = course.imageId),
            contentDescription = stringResource(id = course.name),
            modifier = modifier
                .width(68.dp)
                .fillMaxHeight()
        )
        
        Column(
            modifier = modifier
                .weight(1f)
                .padding(bottom = 0.dp, top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxHeight()
        ) {
            Text( // course name
                text = stringResource(id = course.name),
                modifier = modifier.padding(bottom = 8.dp)
            )
            Row {
                // course topics icon
                Image(
                    painter = painterResource(id = R.drawable.ic_grain),
                    contentDescription = null,
                )
                Text( // course topics
                    text = stringResource(id = course.topics),
                    modifier = modifier.padding(start = 8.dp)
                )
            }
        }
    }
} 

@Preview(showBackground = true)
@Composable
fun CoursesAppPreview() {
    CoursesAppTheme {
        CoursesApp()
    }
}