package com.elvisotieno.googleonetapcompose

import android.net.Uri

data class UserCredentials(
    val id: String?,
    val googleIdToken: String?,
    val displayName: String?,
    val familyName: String?,
    val givenName: String?,
    val password: String?,
    val phoneNumber: String?,
    val profilePictureUri: Uri?,
)

