
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.print.Doc;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vem_ser");

        MongoCollection<Document> pokemons = mongoDatabase.getCollection("pokemon");
        MongoCollection<Document> mochilas = mongoDatabase.getCollection("mochila");

        //todo CRIANDO NOVO DOCUMENTO E INSERINDO
//        Document novoPokemon = new Document("mochila_id",3)
//                .append("racaPokemon", "Rayquaza")
//                .append("peso",2000.00)
//                .append("sexo","FEMININO")
//                .append("level",8000)
//                .append("dificuldade","DIFICIL")
//                .append("tipos",Arrays.asList(
//                        new Document("tipo1","DRAGON"),
//                        new Document("tipo2","FLYING")
//                        )
//                )
//                .append("raridade","SUPER_RARO");
//
//        pokemons.insertOne(novoPokemon);
//
//        Document novaMochila = new Document("_id",3)
//                .append("quantidadePokeball",99)
//                .append("quantidadeGreatball",99)
//                .append("quantidadeMasterball",99)
//                .append("quantidadeHeavyball",99)
//                .append("quantidadeNetball",99);
//        Document novaMochila1 = new Document("_id",4)
//                .append("quantidadePokeball",0)
//                .append("quantidadeGreatball",0)
//                .append("quantidadeMasterball",0)
//                .append("quantidadeHeavyball",0)
//                .append("quantidadeNetball",0);
//
//        mochilas.insertMany(Arrays.asList(novaMochila,novaMochila1));

        //todo ATUALIZANDO CAMPO DO DOCUMENTO
//        pokemons.updateOne(Filters.eq("racaPokemon","Rayquaza"), new Document("$set", new Document("peso", 1000)));

//        mochilas.updateOne(Filters.and(Filters.eq("_id",3), Filters.gt("quantidadePokeball",0)), new Document("$inc", new Document("quantidadePokeball",-1)));
        //todo DELETANDO DOCUMENTO
        pokemons.deleteOne(Filters.eq("racaPokemon" , "Rayquaza"));

        mochilas.deleteMany(Filters.gte("_id", 3));

        //todo BUSCA DE UM DOCUMENTO
        System.out.println("Pokemon buscado:");
        Document pokemon = pokemons.find(new Document("level",new Document("$gt",100))).first();
        System.out.println(pokemon);

        System.out.println("Mochilas:");
        FindIterable<Document> todasMochilas = mochilas.find();
        todasMochilas.forEach(System.out::println);

        //todo AGREGATE
        System.out.println("Pokebolas totais:");
        mochilas.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.empty()),
                        Aggregates.group(null, Accumulators.sum("quantidadePokeball", "$quantidadePokeball"))
                )).forEach(doc -> System.out.println(doc.toJson()));

        mongoClient.close();
    }

}
