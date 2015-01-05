package com.mdb.utils.translate;

import java.util.Map;

public interface FileParser {
    public Map<String, String> readEntries(String path);

    public String getFilename(String path);
}
