package id.biz.equatron.dattebayo.core.data.model

data class Character(
    val id: Int,
    val name: String,
    val images: List<String>,
    val jutsu: List<String>,
)