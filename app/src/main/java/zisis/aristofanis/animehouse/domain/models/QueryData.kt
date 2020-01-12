package zisis.aristofanis.animehouse.domain.models

import com.apollographql.apollo.api.Error as ApolloError

sealed class QueryData {

    data class Error(val errorMessage: ApolloError) : QueryData()

    data class Success<out T>(
        val data: T) : QueryData()
}