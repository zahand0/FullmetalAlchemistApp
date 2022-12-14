package com.example.fullmetalalchemistapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.fullmetalalchemistapp.data.local.FullmetalAlchemistDatabase
import com.example.fullmetalalchemistapp.data.paging_source.HeroRemoteMediator
import com.example.fullmetalalchemistapp.data.paging_source.SearchHeroesSource
import com.example.fullmetalalchemistapp.data.remote.FullmetalAlchemistApi
import com.example.fullmetalalchemistapp.domain.model.Hero
import com.example.fullmetalalchemistapp.domain.repository.RemoteDataSource
import com.example.fullmetalalchemistapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val fullmetalAlchemistApi: FullmetalAlchemistApi,
    private val fullmetalAlchemistDatabase: FullmetalAlchemistDatabase
) : RemoteDataSource {

    private val heroDao = fullmetalAlchemistDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                fullmetalAlchemistApi = fullmetalAlchemistApi,
                fullmetalAlchemistDatabase = fullmetalAlchemistDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(
                    fullmetalAlchemistApi = fullmetalAlchemistApi,
                    query = query
                )
            }
        ).flow
    }
}