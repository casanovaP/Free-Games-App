package com.example.freegamesapp.di

import com.example.freegamesapp.data.remote.GamesApi
import com.example.freegamesapp.data.repository.GamesRepositoryImpl
import com.example.freegamesapp.domain.repository.GamesRepository
import com.example.freegamesapp.domain.use_cases.UseCases
import com.example.freegamesapp.domain.use_cases.get_game.GetGameUseCase
import com.example.freegamesapp.domain.use_cases.get_games.GetGamesUseCase
import com.example.freegamesapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GamesModule {

    @Provides
    @Singleton
    fun provideApi(): GamesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(GamesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: GamesApi): GamesRepository {
        return GamesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUseCases(gamesRepository: GamesRepository): UseCases {
        return UseCases(
            getGamesUseCase = GetGamesUseCase(gamesRepository),
            getGameUseCase = GetGameUseCase(gamesRepository)
        )
    }
}