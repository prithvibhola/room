package prithvi.io.room.data.repository

import io.reactivex.Flowable
import prithvi.io.room.data.api.Api
import prithvi.io.room.data.models.GithubUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository @Inject constructor(
        private val api: Api
) {
    fun getGithubUsers(name: String): Flowable<List<GithubUser>> =
            api.getGithubUsers(name).map { it.items }.toFlowable()
}