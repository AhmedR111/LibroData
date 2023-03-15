package com.tema1.data;

import com.tema1.Author;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericData<T extends IEntitateFisier> implements IData<T> {

    private String dataSourceFile;

    /**
     * Constructor gets initialized with the relative path to the input file
     * @param dataSourceFile
     */
    public GenericData(String dataSourceFile) {
        this.dataSourceFile = this.getThePathToInit() + "\\" +dataSourceFile;

    }

    /**
     * Every object will be transformed by the respective class which extends current
     * Transformation will be handled appropriately by the method, in order to transition from a
     * String instance into a specific type object
     * @param linieDinFisier
     * @return
     */
    protected abstract T transformare(String linieDinFisier);

    protected String getThePathToInit(){
        String path = "src/init";

        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        return absolutePath;
    }

    /**
     * Method which returns all instances of items, corresponding with each line in the file
     * @return
     */
    public List<T> findAll(){
        List<T> resultList = new ArrayList<>();
        try {
            List<String> fileLines = Files.readAllLines(Paths.get
                    (dataSourceFile), StandardCharsets.UTF_8);
            fileLines.remove(0);
            for(String line: fileLines){
                T cevaDinFisier = this.transformare(line);
                resultList.add(cevaDinFisier);
                //System.out.println(author.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Method which allows "jumping" to a specific element by id
     * This method uses <code>transformare</code> to transform each line in the file
     * into a specific object
     * @return
     */
    @Override
    public Map<Integer, T> findAllWithIds() {
        Map<Integer, T> result = new HashMap<>();
        try {
            List<String> linesFromFile = Files.readAllLines(Paths.get
                    (dataSourceFile), StandardCharsets.UTF_8);
            linesFromFile.remove(0);
            for(String line: linesFromFile){
                T cevaDinFisier = transformare(line);
                result.put(cevaDinFisier.getId(), cevaDinFisier);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
