package com.epub;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.MediaType;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // read epub file
        EpubReader epubReader = new EpubReader();
        Book book = epubReader.readEpub(new FileInputStream("5225_1.epub"));
    
        // print the first title
        List<String> titles = book.getMetadata().getTitles();
        System.out.println("book title:" + (titles.isEmpty() ? "book has no title" : titles.get(0)));
    
        final Resource coverPage = book.getCoverPage();
        System.out.println("coverPage = " + coverPage);
    
        final int size = book.getTableOfContents().size();
        System.out.println("size = " + size);
    
        final Resource opfResource = book.getOpfResource();
        System.out.println("opfResource = " + opfResource);
    
        final Resource ncxResource = book.getNcxResource();
        System.out.println("ncxResource = " + ncxResource);
    
        final MediaType mediaType = book.getNcxResource()
                                        .getMediaType();
        System.out.println("mediaType = " + mediaType);
    
        final List<Resource> contents = book.getContents();
        System.out.println("contents = " + contents);
    
        for (Resource content : contents) {
            final byte[] data = content.getData();
            System.out.println("data = " + new String(data));
        }
    }
}
