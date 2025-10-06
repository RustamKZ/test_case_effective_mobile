package com.example.test_case_effective_mobile.api

data class CourseResponse (
    val courses: List<Course>
)

data class Course(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    var hasLike: Boolean,
    val publishDate: String
)