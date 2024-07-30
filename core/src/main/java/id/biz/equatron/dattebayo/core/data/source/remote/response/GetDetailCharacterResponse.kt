package id.biz.equatron.dattebayo.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetDetailCharacterResponse(

//	@field:SerializedName("debut")
//	val debut: Debut,

	@field:SerializedName("images")
	val images: List<String>,

//	@field:SerializedName("voiceActors")
//	val voiceActors: VoiceActors,

	@field:SerializedName("jutsu")
	val jutsu: List<String>,

	@field:SerializedName("name")
	val name: String,

//	@field:SerializedName("rank")
//	val rank: Rank,
//
//	@field:SerializedName("personal")
//	val personal: Personal,

	@field:SerializedName("id")
	val id: Int,

//	@field:SerializedName("family")
//	val family: Family,
//
//	@field:SerializedName("natureType")
//	val natureType: List<String>,
//
//	@field:SerializedName("tools")
//	val tools: List<String>
)
//
//data class Weight(
//
//	@field:SerializedName("Part II")
//	val partII: String,
//
//	@field:SerializedName("Part I")
//	val partI: String
//)
//
//data class Family(
//
//	@field:SerializedName("mother")
//	val mother: String,
//
//	@field:SerializedName("son")
//	val son: String,
//
//	@field:SerializedName("wife")
//	val wife: String,
//
//	@field:SerializedName("father")
//	val father: String,
//
//	@field:SerializedName("adoptive son")
//	val adoptiveSon: String,
//
//	@field:SerializedName("daughter")
//	val daughter: String,
//
//	@field:SerializedName("godfather")
//	val godfather: String
//)
//
//data class NinjaRank(
//
//	@field:SerializedName("Part I")
//	val partI: String,
//
//	@field:SerializedName("Gaiden")
//	val gaiden: String
//)
//
//data class Personal(
//
//	@field:SerializedName("tailedBeast")
//	val tailedBeast: String,
//
//	@field:SerializedName("birthdate")
//	val birthdate: String,
//
//	@field:SerializedName("occupation")
//	val occupation: List<String>,
//
//	@field:SerializedName("sex")
//	val sex: String,
//
//	@field:SerializedName("weight")
//	val weight: Weight,
//
//	@field:SerializedName("team")
//	val team: List<String>,
//
//	@field:SerializedName("titles")
//	val titles: List<String>,
//
//	@field:SerializedName("bloodType")
//	val bloodType: String,
//
//	@field:SerializedName("classification")
//	val classification: List<String>,
//
//	@field:SerializedName("affiliation")
//	val affiliation: List<String>,
//
//	@field:SerializedName("kekkeiGenkai")
//	val kekkeiGenkai: List<String>,
//
//	@field:SerializedName("clan")
//	val clan: String,
//
//	@field:SerializedName("age")
//	val age: Age,
//
//	@field:SerializedName("height")
//	val height: Height
//)
//
//data class VoiceActors(
//
//	@field:SerializedName("japanese")
//	val japanese: List<String>,
//
//	@field:SerializedName("english")
//	val english: List<String>
//)
//
//data class Height(
//
//	@field:SerializedName("Part II")
//	val partII: String,
//
//	@field:SerializedName("Part I")
//	val partI: String,
//
//	@field:SerializedName("Blank Period")
//	val blankPeriod: String
//)
//
//data class Debut(
//
//	@field:SerializedName("game")
//	val game: String,
//
//	@field:SerializedName("appearsIn")
//	val appearsIn: String,
//
//	@field:SerializedName("movie")
//	val movie: String,
//
//	@field:SerializedName("manga")
//	val manga: String,
//
//	@field:SerializedName("ova")
//	val ova: String,
//
//	@field:SerializedName("anime")
//	val anime: String,
//
//	@field:SerializedName("novel")
//	val novel: String
//)
//
//data class Age(
//
//	@field:SerializedName("Academy Graduate")
//	val academyGraduate: String,
//
//	@field:SerializedName("Part II")
//	val partII: String,
//
//	@field:SerializedName("Part I")
//	val partI: String
//)
//
//data class Rank(
//
//	@field:SerializedName("ninjaRegistration")
//	val ninjaRegistration: String,
//
//	@field:SerializedName("ninjaRank")
//	val ninjaRank: NinjaRank
//)
