package prithvi.io.room.data.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
        val github: GithubRepository
)
