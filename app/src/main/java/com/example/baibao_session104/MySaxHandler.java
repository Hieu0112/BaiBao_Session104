package com.example.baibao_session104;

import com.example.baibao_session104.model.Item;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MySaxHandler extends DefaultHandler {
    private List<Item>list;
    private Item item;
    private String temp;
    private boolean flagstart=false;

    public MySaxHandler() {
        item=new Item();
        list=new ArrayList<>();
    }
    public List<Item> getItems(){
        return list;
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if(flagstart){
            temp=new String(ch,start,length);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equalsIgnoreCase("item")){
            item=new Item();
            flagstart=true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equalsIgnoreCase("item")){
            list.add(item);
        } else if (qName.equalsIgnoreCase("title")) {
            item.setTitle(temp);
        }else if(qName.equalsIgnoreCase("description")) {
            item.setDescription(temp);
        }else if(qName.equalsIgnoreCase("pubDate")) {
            item.setPubDate(temp);
        }else if(qName.equalsIgnoreCase("link")) {
            item.setLink(temp);
        }
    }
}
