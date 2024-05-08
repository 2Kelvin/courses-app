package com.example.coursesapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val name: Int,
    val topics: Int,
    @DrawableRes val imageId: Int,
)
