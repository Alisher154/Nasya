package uz.texnopos.nasya.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.texnopos.nasya.presentation.main.addclient.usecase.AddClientFragmentUC
import uz.texnopos.nasya.presentation.main.addclient.usecase.AddClientFragmentUCImpl
import uz.texnopos.nasya.presentation.main.clients.usecase.ClientsFragmentUC
import uz.texnopos.nasya.presentation.main.clients.usecase.ClientsFragmentUCImpl
import uz.texnopos.nasya.presentation.main.orders.usecase.OrdersFragmentUC
import uz.texnopos.nasya.presentation.main.orders.usecase.OrdersFragmentUCImpl

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun provideClientsFragmentUseCase(impl: ClientsFragmentUCImpl): ClientsFragmentUC

    @Binds
    fun provideAddClientFragmentUseCase(impl: AddClientFragmentUCImpl): AddClientFragmentUC

    @Binds
    fun provideOrdersFragmentUseCase(impl:OrdersFragmentUCImpl):OrdersFragmentUC
}