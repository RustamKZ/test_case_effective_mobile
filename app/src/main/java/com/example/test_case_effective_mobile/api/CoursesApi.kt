package com.example.test_case_effective_mobile.api

import retrofit2.http.GET

interface CoursesApi {
    @GET("courses.json")
    suspend fun getCourses(): CourseResponse
}