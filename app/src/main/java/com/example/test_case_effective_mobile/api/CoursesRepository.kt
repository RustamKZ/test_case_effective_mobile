package com.example.test_case_effective_mobile.api

class CoursesRepository {
    private val api = RetrofitInstance.api

    suspend fun getCourses(): List<Course> {
        val response = api.getCourses()
        return response.courses
    }
}