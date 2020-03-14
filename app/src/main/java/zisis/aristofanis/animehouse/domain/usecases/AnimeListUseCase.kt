package zisis.aristofanis.animehouse.domain.usecases

import zisis.aristofanis.animehouse.domain.datasources.AnimeListDataSource
import zisis.aristofanis.animehouse.domain.models.QueryData

class AnimeListUseCase(private val animeListDataSource: AnimeListDataSource) {

   suspend fun getAnimeListWithInfo(): QueryData {
        return animeListDataSource.getAnimeList()
    }

}