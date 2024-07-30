package id.biz.equatron.dattebayo.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetAllCharactersResponse(

	@field:SerializedName("characters")
	val characters: List<CharactersItem>,

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("pageSize")
	val pageSize: Int,

	@field:SerializedName("currentPage")
	val currentPage: Int
)

data class Debut(

	@field:SerializedName("game")
	val game: String,

	@field:SerializedName("appearsIn")
	val appearsIn: String,

	@field:SerializedName("manga")
	val manga: String,

	@field:SerializedName("anime")
	val anime: String,

	@field:SerializedName("movie")
	val movie: String,

	@field:SerializedName("ova")
	val ova: String,

	@field:SerializedName("novel")
	val novel: String
)

data class Weight(

	@field:SerializedName("Part II")
	val partII: String,

	@field:SerializedName("Part I")
	val partI: String
)

data class Height(

	@field:SerializedName("Part II")
	val partII: String,

	@field:SerializedName("Part I")
	val partI: String,

	@field:SerializedName("Blank Period")
	val blankPeriod: String,

	@field:SerializedName("Boruto Movie")
	val borutoMovie: String,

	@field:SerializedName("Boruto Manga")
	val borutoManga: String,

	@field:SerializedName("Gaiden")
	val gaiden: String
)

data class Family(

	@field:SerializedName("creator")
	val creator: String,

	@field:SerializedName("genetic template")
	val geneticTemplate: String,

	@field:SerializedName("son")
	val son: String,

	@field:SerializedName("grandmother")
	val grandmother: String,

	@field:SerializedName("lover")
	val lover: String,

	@field:SerializedName("granduncle")
	val granduncle: String,

	@field:SerializedName("great-grandfather")
	val greatGrandfather: String,

	@field:SerializedName("grandfather")
	val grandfather: String,

	@field:SerializedName("brother")
	val brother: String,

	@field:SerializedName("grandson")
	val grandson: String,

	@field:SerializedName("wife")
	val wife: String,

	@field:SerializedName("father")
	val father: String,

	@field:SerializedName("granddaughter")
	val granddaughter: String,

	@field:SerializedName("mother")
	val mother: String,

	@field:SerializedName("niece")
	val niece: String,

	@field:SerializedName("aunt")
	val aunt: String,

	@field:SerializedName("host")
	val host: String,

	@field:SerializedName("first cousin once removed")
	val firstCousinOnceRemoved: String,

	@field:SerializedName("adoptive brother")
	val adoptiveBrother: String,

	@field:SerializedName("sister")
	val sister: String,

	@field:SerializedName("clone/brother")
	val cloneBrother: String,

	@field:SerializedName("pet ")
	val pet: String,

	@field:SerializedName("genetic template/parent")
	val geneticTemplateParent: String,

	@field:SerializedName("uncle")
	val uncle: String,

	@field:SerializedName("cousin")
	val cousin: String,

	@field:SerializedName("clone")
	val clone: String,

	@field:SerializedName("godson")
	val godson: String,

	@field:SerializedName("adoptive mother")
	val adoptiveMother: String,

	@field:SerializedName("adoptive sons")
	val adoptiveSons: String,

	@field:SerializedName("nephew")
	val nephew: String,

	@field:SerializedName("adoptive son")
	val adoptiveSon: String,

	@field:SerializedName("clone/son")
	val cloneSon: String,

	@field:SerializedName("daughter")
	val daughter: String,

	@field:SerializedName("godfather")
	val godfather: String
)

data class Rank(

	@field:SerializedName("ninjaRegistration")
	val ninjaRegistration: String,

	@field:SerializedName("ninjaRank")
	val ninjaRank: NinjaRank
)

data class NinjaRank(

	@field:SerializedName("Part II")
	val partII: String,

	@field:SerializedName("Part I")
	val partI: String,

	@field:SerializedName("Gaiden")
	val gaiden: String,

	@field:SerializedName("Blank Period")
	val blankPeriod: String
)

data class Age(

	@field:SerializedName("Academy Graduate")
	val academyGraduate: String,

	@field:SerializedName("Part II")
	val partII: String,

	@field:SerializedName("Part I")
	val partI: String,

	@field:SerializedName("Chunin Promotion")
	val chuninPromotion: String,

	@field:SerializedName("Boruto Movie")
	val borutoMovie: String,

	@field:SerializedName("Blank Period")
	val blankPeriod: String,

	@field:SerializedName("Boruto Manga")
	val borutoManga: String
)

data class VoiceActors(

	@field:SerializedName("japanese")
	val japanese: List<String>,

	@field:SerializedName("english")
	val english: List<String>
)
