package com.thindie.physact.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    val activities: Flow<List<Activity>>
}