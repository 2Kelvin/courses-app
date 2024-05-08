package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val name: Int,
    val topics: Int,
    @DrawableRes val imageId: Int,
)
