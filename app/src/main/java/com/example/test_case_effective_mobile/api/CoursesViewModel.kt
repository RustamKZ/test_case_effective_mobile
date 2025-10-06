package com.example.test_case_effective_mobile.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoursesViewModel constructor(
    private val repository: CoursesRepository = CoursesRepository()
): ViewModel() {
    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses: StateFlow<List<Course>> = _courses

    private val _likedIds = MutableStateFlow<Set<Int>>(emptySet())
    val likedIds: StateFlow<Set<Int>> = _likedIds

    init {
        loadCourses()
    }
    private fun loadCourses() {
        viewModelScope.launch {
            _courses.value = repository.getCourses()
        }
    }

    fun toggleLike(courseId: Int) {
        _likedIds.update { set ->
            if (set.contains(courseId)) set - courseId else set + courseId
        }
    }
}