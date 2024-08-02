package id.biz.equatron.dattebayo.core.domain.model

data class Character(
    val id: Int,
    val name: String,
    val images: List<String>,
    val jutsu: List<String>,
)