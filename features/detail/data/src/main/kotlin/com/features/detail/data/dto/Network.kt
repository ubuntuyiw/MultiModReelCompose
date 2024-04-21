package com.features.detail.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Network(
    val id: Int? = null,
    @SerialName("logo_path")
    val logoPath: String? = null,
    val name: String? = null,
    @SerialName("origin_country")
    val originCountry: String? = null,
)