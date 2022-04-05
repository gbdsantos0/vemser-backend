use vem_ser

db.createCollection("pokemon")

db.pokemon.insertMany(
[
	{
	  "racaPokemon": "Bulbasaur",
	  "peso": 7.07,
	  "sexo": "MASCULINO",
	  "level": 5,
	  "dificuldade": "FACIL",
	  "tipo1": "GRASS",
	  "tipo2": "POISON",
	  "raridade": "COMUM"
	},
	{
	  "racaPokemon": "Ivysaur",
	  "peso": 17.56,
	  "sexo": "MASCULINO",
	  "level": 16,
	  "dificuldade": "MEDIO",
	  "tipo1": "GRASS",
	  "tipo2": "POISON",
	  "raridade": "RARO"
	},
	{
	  "racaPokemon": "Wartortle",
	  "peso": 25.56,
	  "sexo": "MASCULINO",
	  "level": 16,
	  "dificuldade": "MEDIO",
	  "tipo1": "WATER",
	  "tipo2": null,
	  "raridade": "RARO"
	},
	{
	  "racaPokemon": "Blastoise",
	  "peso": 93.94,
	  "sexo": "MASCULINO",
	  "level": 36,
	  "dificuldade": "DIFICIL",
	  "tipo1": "WATER",
	  "tipo2": null,
	  "raridade": "SUPER_RARO"
	},
	{
	  "racaPokemon": "Charmander",
	  "peso": 8.76,
	  "sexo": "FEMININO",
	  "level": 10,
	  "dificuldade": "FACIL",
	  "tipo1": "FIRE",
	  "tipo2": null,
	  "raridade": "COMUM"
	},
	{
	  "racaPokemon": "Graveler",
	  "peso": 115.24,
	  "sexo": "FEMININO",
	  "level": 16,
	  "dificuldade": "MEDIO",
	  "tipo1": "ROCK",
	  "tipo2": "GROUND",
	  "raridade": "RARO"
	},
	{
	  "racaPokemon": "Charizard",
	  "peso": 91.26,
	  "sexo": "MASCULINO",
	  "level": 36,
	  "dificuldade": "DIFICIL",
	  "tipo1": "FIRE",
	  "tipo2": "DRAGON",
	  "raridade": "SUPER_RARO"
	}
]
)


db.pokemon.find({$or:[
	{"sexo":"FEMININO"},
	{"level": {$gte: 30}}
]})


db.pokemon.find({"raridade":{$in:["SUPER_RARO", "RARO"]}})

db.pokemon.deleteMany({"level": {$lte:10}})






db.testes.updateOne(
  {},
  [{ $set: { "array": { $concatArrays: [ "$array", ["segundo dado"] ] } } }]
)

db.testes.updateOne(
	{},
	{$pull: {"array":["primeiro dado"]}}
)

db.testes.updateOne(
  {},
  [{ $set: { "array": { $concatArrays: [ ["primeiro dado"], "$array" ] } } }]
)

db.testes.updateOne(
	{},
	[{ $set: { "novocampo": "alo"}}]
)

db.testes.updateOne(
	{},
	[{ $set: { "novocampo": {$concat: ["$novocampo"," oi"]}}}]
)

db.testes.sort({_id:-1}).limit(3)


db.testes.aggregate([{$match: {"novocampo": "aloalo"}}]).sort({_id:1})

db.testes.aggregate([{$match: {"novocampo": "aloalo"}}
,{$group: {_id: "$novocampo"}}
	]).sort({_id:1})

