package com.lenarlenar.vkmessengeraac.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(@SerializedName("response") val profileDetails: List<VkProfile>)

data class VkProfile(val uid: Int, val first_name: String, val last_name: String)