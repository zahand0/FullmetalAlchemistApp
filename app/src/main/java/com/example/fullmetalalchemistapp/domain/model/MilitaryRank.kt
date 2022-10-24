package com.example.models

enum class MilitaryRank(
    val rankName: String,
    val img: String
) {
FuhrerPresident("Führer-President", "/images/ranks/fuhrerPresident.jpg"),
MajorGeneral("Major General", "/images/ranks/majorGeneral.jpg"),
Colonel("Colonel", "/images/ranks/colonel.jpg"),
LieutenantColonel("Lieutenant Colonel", "/images/ranks/lieutenantColonel.jpg") ,
Major("Major", "/images/ranks/major.jpg") ,
FirstLieutenant("First Lieutenant", "/images/ranks/firstLieutenant.jpg"),
Civilian("Civilian", "")
}
