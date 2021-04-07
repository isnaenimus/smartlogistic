package com.telkom.smartlogistic.framework.util.helper

import okhttp3.Interceptor
import java.util.HashMap

/**
 * Created by Isnaeni on 30/03/2021.
 */
object Common {

    fun getInterceptorWithHeader(
            headerName: String,
            headerValue: String
    ): Interceptor {
        val header: HashMap<String, String> = HashMap()
        header[headerName] = headerValue
        return getInterceptorWithHeader(
                header
        )
    }

    private fun getInterceptorWithHeader(headers: Map<*, *>): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder()
            val var5: Iterator<*> = headers.entries.iterator()
            while (var5.hasNext()) {
                val var4 =
                        var5.next() as Map.Entry<*, *>
                val key = var4.key as String
                val value = var4.value as String
                builder.addHeader(key, value)
            }
            builder.method(original.method, original.body)
            chain.proceed(builder.build())
        }
    }

}