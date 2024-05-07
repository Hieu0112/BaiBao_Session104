package com.example.baibao_session104;

import android.util.Log;

import com.example.baibao_session104.model.Item;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

public class MySaxParser{
    public static List<Item>xmlParser(InputStream is){
        List<Item>list=new ArrayList<>();
        try {
            XMLReader reader= SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            MySaxHandler handler=new MySaxHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(is));
            list = handler.getItems();
        }
        catch (Exception e){
            Log.d("Loi:",e.getMessage());
            Log.e("MySaxParser", "Error parsing XML", e);
        }
        return list;
    }
}
