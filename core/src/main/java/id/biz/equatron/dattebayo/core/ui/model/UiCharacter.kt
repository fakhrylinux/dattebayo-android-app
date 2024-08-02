package id.biz.equatron.dattebayo.core.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiCharacter(
    val id: Int,
    val name: String,
    val images: List<String>,
    val jutsu: List<String>,
): Parcelable
