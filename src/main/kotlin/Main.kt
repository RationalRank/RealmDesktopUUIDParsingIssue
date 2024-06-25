package dev.ranjith

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmUUID
import kotlin.system.exitProcess

class DynamicData : RealmObject {
    var uuid: RealmUUID = RealmUUID.random()
    var data: String = ""
}

fun main() {
    val realmConfiguration = RealmConfiguration
        .Builder(schema = setOf(DynamicData::class))
        .directory("db")
        .build()
    val realm = Realm.open(realmConfiguration)
    val apiData = Api.getData()
    apiData.forEach { dynamicData ->
        realm.writeBlocking {
            copyToRealm(
                DynamicData().apply {
                    uuid = RealmUUID.Companion.from(dynamicData.uuid)
                    data = dynamicData.data
                }
            )
        }    
    }
    realm.close()
    exitProcess(0)
}
