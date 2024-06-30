package com.thindie.physact.data

import com.thindie.physact.domain.Activity
import com.thindie.physact.domain.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl() : Repository {
    override val activities: Flow<List<Activity>>
        get() = flow { }
}