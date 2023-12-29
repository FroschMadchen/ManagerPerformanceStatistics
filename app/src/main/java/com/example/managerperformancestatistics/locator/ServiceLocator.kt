package com.example.managerperformancestatistics.locator

import com.example.managerperformancestatistics.model.projects.ProjectRepository
import kotlin.reflect.KClass

object ServiceLocator {


    private val instances = mutableMapOf<KClass<*>, Any>()

    inline fun <reified T: Any> register(instance: T) = register(T::class, instance)

    fun <T: Any> register(kClass: KClass<T>, instance: T) {
        instances[kClass] = instance
    }

 /*   @Suppress("UNCHECKED_CAST")
    fun <T: Any> get(kClass: KClass<T>): T = instances[kClass] as T
*/
    @Suppress("UNCHECKED_CAST")
    fun <T : Any> get(kClass: KClass<T>): T {
        val instance = instances[kClass]
        if (instance != null) {
            return instance as T
        } else {
            throw NoSuchElementException("No instance found for class: $kClass")
        }
    }
}



inline fun <reified T: Any> locate() = ServiceLocator.get(T::class)

inline fun <reified T: Any> locateLazy(): Lazy<T> = lazy { ServiceLocator.get(T::class) }