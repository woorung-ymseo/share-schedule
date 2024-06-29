package com.schedule.share.common.utils

object CollectionUtil {
    // 랜덤으로 하나 뽑기
    fun <T> getRandomElement(collection: Collection<T>): T? {
        return collection.randomOrNull()
    }

    // 기존의 CollectionUtil.distinctByKey 는 kotlin.collections 의 distinctBy 사용해주세요.
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/distinct-by.html

    /**
     * 모든 요소가 `null`이 아니면서 빈 문자열("")이 아닌지 확인합니다.
     */
    fun isAllNotBlank(collection: Collection<String?>): Boolean {
        return collection.all { !it.isNullOrBlank() }
    }

    /**
     * 모든 요소가 null 이 아닐 때 바디에서 해당 값의 non-null 임을 보장
     */
    fun <T : Any, R : Any> multipleLet(
        vararg options: T?,
        block: (List<T>) -> R,
    ): R? {
        return if (options.all { it != null }) {
            block(options.filterNotNull()) // or do unsafe cast to non null collection
        } else {
            null
        }
    }

    /**
     * 바디에서 리스트가 empty 가 아님을 보장
     */
    fun <T, R> List<T>.letIfNotEmpty(block: (List<T>) -> R): R? = takeIf { it.isNotEmpty() }?.let { block(it) }
}
