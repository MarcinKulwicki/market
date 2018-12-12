package pl.marcinkulwicki.promotionmarket;

import android.util.JsonReader;

import java.io.IOException;

import pl.marcinkulwicki.promotionmarket.Objects.Product;

public class JsonObjectReaders {

    public static Product readProduct(JsonReader reader) throws IOException {
        String id = "";
        String name = "";
        String priceBefore = "";
        String priceAfter = "";
        String isAvailable = "";

        reader.beginObject();

        if(reader.nextName().equals("_id")){
            reader.beginObject();
            reader.nextName();
            id = reader.nextString();
            reader.endObject();
//            reader.skipValue();
        }
        while (reader.hasNext()){

            String nameToRead = reader.nextName();

            if(nameToRead.equals("name")){
                name = reader.nextString();
            }else if(nameToRead.equals("priceBefore")){
                priceBefore = reader.nextString();
            }else if(nameToRead.equals("priceAfter")){
                priceAfter = reader.nextString();
            }else if(nameToRead.equals("isAvailable")){
                isAvailable = reader.nextString();
            }
        }

        reader.endObject();
        return new Product(id,name,priceBefore,priceAfter,isAvailable);
    }
}
