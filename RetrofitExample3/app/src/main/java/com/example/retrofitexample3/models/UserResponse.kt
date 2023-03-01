package com.example.retrofitexample3.models
import com.google.gson.annotations.SerializedName

data class UserResponse(
    val data : UserData,
)

data class UserListResponse(
    val total : Int,
    val page : Int,
    val data : List<UserData>,
)

data class UserData(

    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("avatar")
    val avatar: String? = null,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)


//
//data class UserData(
//    val id : Int?,
//    val email : String?,
//    val firstName : String?,
//    val lastName : String?,
//    val avatar : String?
//)
