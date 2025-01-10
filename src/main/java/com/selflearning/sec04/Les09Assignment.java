package com.selflearning.sec04;

import com.selflearning.common.Util;
import com.selflearning.sec04.assignment.FileReaderService;
import com.selflearning.sec04.assignment.FileReaderServiceImpl;

import java.nio.file.Path;

public class Les09Assignment {

    public static void main(String[] args) {
        var path = Path.of("src/main/resources/sec04/file.txt");
        var fileReaderService = new FileReaderServiceImpl();
        fileReaderService.read(path).subscribe(Util.subscriber());
    }
}
