package com.example.dagger2vshilt.di

import com.example.dagger2vshilt.App
import com.example.dagger2vshilt.BlankFragment
import com.example.dagger2vshilt.FreeActivity
import com.example.dagger2vshilt.PaidActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
    ]
)
interface AppComponent : AndroidInjector<App> {


}

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [PaidModule::class, FragmentsModule::class])
    abstract fun contributesMainActivity(): PaidActivity

    @ContributesAndroidInjector(modules = [FreeModule::class, FragmentsModule::class])
    abstract fun contributesFreeActivity(): FreeActivity

}

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributesBlankFragment(): BlankFragment

}

interface Analytics {

    fun trackScreen(): String

}

class PaidAnalytics : Analytics {

    override fun trackScreen(): String {
        return "paid"
    }

}

class FreeAnalytics : Analytics {

    override fun trackScreen(): String {
        return "demo"
    }

}

@Module
class PaidModule {

    @Provides
    fun providePaid(): Analytics {
        return PaidAnalytics()
    }

}

@Module
class FreeModule {

    @Provides
    fun provideFree(): Analytics {
        return FreeAnalytics()
    }

}