package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.data.DataSource
import com.example.coursesapp.model.Course
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
fun CoursesApp() {
    // passing in the datasource list of courses
    // applying a padding of 8.dp to AllCourses composable
    AllCourses(courses = DataSource.topics)
}

// reusable course composable
@Composable
fun OneCourse(course: Course, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .height(68.dp)
            .clip(RoundedCornerShape(12.dp)),
        shadowElevation = 12.dp,
        color = Color(0xFFe5e2e7)
    ) {
        Row {
            Image(
                painter = painterResource(id = course.imageId),
                contentDescription = stringResource(id = course.name),
                modifier = modifier
                    .width(68.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = modifier
                    .padding(bottom = 0.dp, top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxHeight()
            ) {
                Text( // course name
                    text = stringResource(id = course.name),
                    modifier = modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // course topics icon
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                    )
                    Text( // course topics
                        text = course.topics.toString(),
                        modifier = modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

// all courses in a grid
@Composable
fun AllCourses(courses: List<Course>, modifier: Modifier = Modifier) {
    // display a vertical grid with 2 columns
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.padding(8.dp)
    ) {
        // passing the list to items property
        items(courses) {eachCourse ->
            // displaying each course using OneCourse reusable composable
            OneCourse(course = eachCourse)
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