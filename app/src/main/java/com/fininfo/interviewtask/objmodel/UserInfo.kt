package com.fininfo.interviewtask.objmodel

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class UserInfo(
    var name: String? = null,
    var age: Int? = null,
    var city: String? = null

) : RealmObject()