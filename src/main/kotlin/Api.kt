package dev.ranjith

data class DynamicDataDto(
    val uuid: String,
    val data: String
)

object Api {
    
    /**
     * Dummy method replicating the API data 
     */
    fun getData(): List<DynamicDataDto> {
        return buildList {
            add(
                DynamicDataDto(
                    uuid = "e47805a0-3c08-11ee-a025-6fe458af8702",
                    data = "UUID V1"
                )
            )
            add(
                DynamicDataDto(
                    uuid = "b90ef1a6-3185-4e7f-a7d2-0de4f4cacde9",
                    data = "UUID V4"
                )
            )
        }
    }
}
