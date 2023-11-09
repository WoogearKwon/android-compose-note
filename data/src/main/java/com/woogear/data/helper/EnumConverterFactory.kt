package com.woogear.data.helper

import kotlinx.serialization.SerialName
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class EnumConverterFactory : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<Enum<*>, String>? {
        return if (type is Class<*> && type.isEnum) {
            Converter { enum ->
                try {
                    enum.javaClass.getField(enum.name).getAnnotation(SerialName::class.java)?.value
                } catch (e: Exception) {
                    null
                } ?: enum.toString()
            }
        } else {
            null
        }
    }
}
