package nextstep.github.data

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class GithubRepositoryImplTest {
    private lateinit var repository: GithubRepository

    @Before
    fun setUp() {
        repository = FakeGithubRepository()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `리파지토리 데이터가 비어있지 않은지 확인해 본다`(): Unit = runTest {
        val actual = repository.getRepositories("next-step").fold(
            onSuccess = { it },
            onFailure = { emptyList() }
        )
        actual.forEach {
            println(it)
        }
        assertThat(actual.isEmpty()).isFalse()
    }
}