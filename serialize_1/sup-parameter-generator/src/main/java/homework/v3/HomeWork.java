package homework.v3;


import homework.v3.entity.Bundle;
import homework.v3.entity.JsonFileClass;
import homework.v3.entity.JsonParameters;
import homework.v3.entity.Path;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Задание
 * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.entity.
 * Определить какой элемент является корневым
 * Дать имя файлу homework.parameters.json
 * 2) Заполнить его значениями (как пример "parameters.v1.json")
 * 3) Считать получившийся homework.parameters.json в память
 * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
 * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
 * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
 * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
 * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
 * совпадают с homework.parameters.json
 * */
public class HomeWork {
    public static final String HOMEWORK_PARAM_FILE = "homework.parameters.json";
    public static final String HOMEWORK_PARAM_FILE_EXT = "homework.parameters.ext.json";
    public static final String HOMEWORK_RESULT_PARAM_FILE = "homework.parameters.ser"; //сериализованный файл
    public static final String HOMEWORK_RESULT_PARAM_FILE_EXT = "homework.parameters.exter"; //сериализованный файл Externalizable
    public static final String HOMEWORK_PARAM_FILE_EXT_FINAL = "homework.result.exter.parameters.json";
    public static final String HOMEWORK_PARAM_FILE_SER_FINAL = "homework.result.ser.parameters.json";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CreateObject myObj = new CreateObject();
        //Создает объект и на основании рандомного числа заполняет его.
        myObj.fillObject(2);


         //http://j4web.ru/java-json/primer-ispolzovaniya-jackson-java-obekty-i-json.html
        //https://github.com/FasterXML/jackson-docs
        //https://docs.oracle.com/javase/6/docs/platform/serialization/spec/serial-arch.html#4539

        //создать JSON объект
        ObjectMapper mapper = new ObjectMapper(); //буфер
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(HOMEWORK_PARAM_FILE),myObj.getFileClass());


        //преобразовать JSON в Java, считать файл в память

        JsonParametrReader parameterReader = new JsonParametrReader();
        JsonFileClass parameterInform = parameterReader.read(HOMEWORK_PARAM_FILE);
        System.out.println("Файл JSON успешно создан " + HOMEWORK_PARAM_FILE);

        //Сериализация
        JsonParameterSerializeWriter serializeWriter = new JsonParameterSerializeWriter();
        serializeWriter.customSerializeWriter(parameterInform,HOMEWORK_RESULT_PARAM_FILE);
        System.out.println("Файл успешно серриализован " + HOMEWORK_RESULT_PARAM_FILE);

        /* *
        * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.entity.
        * Определить какой элемент является корневым
        * Дать имя файлу homework.parameters.json
        * 2) Заполнить его значениями (как пример "parameters.v1.json")
        * 3) Считать получившийся homework.parameters.json в память
        * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
        * СДЕЛАНО
        * */


        //https://habr.com/ru/post/431524/
        CreateObjectExt myObjExt = new CreateObjectExt();
        //Создает объект и на основании рандомного числа заполняет его.
        myObjExt.fillObjectExt(2);

        //создать JSON объект
        ObjectMapper mapperExt = new ObjectMapper(); //буфер
        mapperExt.writerWithDefaultPrettyPrinter().writeValue(new File(HOMEWORK_PARAM_FILE_EXT),myObjExt.getFileClassExt());
        System.out.println("Файл JSON успешно создан " + HOMEWORK_PARAM_FILE_EXT);


        // считать файл в память

        JsonParameterReaderExt parameterReaderExt = new JsonParameterReaderExt();
        homework.v3.entityExt.JsonFileClass parameterInformExt = parameterReaderExt.read(HOMEWORK_PARAM_FILE_EXT);
        System.out.println("Файл JSON успешно считан в память " + HOMEWORK_PARAM_FILE_EXT);

        //Сериализация в writeExternal и readExternal указываем , что сериализовать
        JsonParameterExternalizableWriter WriterExt = new JsonParameterExternalizableWriter();
        WriterExt.customWriterExt(parameterInformExt,HOMEWORK_RESULT_PARAM_FILE_EXT);
        System.out.println("Файл успешно серриализован " + HOMEWORK_RESULT_PARAM_FILE_EXT);

        //дессериализатор
        JsonParameterExternalizableReader ReadExt = new JsonParameterExternalizableReader();
        homework.v3.entityExt.JsonFileClass parameterInformExt1 = ReadExt.customReaderExt(HOMEWORK_RESULT_PARAM_FILE_EXT);
        ObjectMapper mapperExt1 = new ObjectMapper(); //буфер
        mapperExt1.writerWithDefaultPrettyPrinter().writeValue(new File(HOMEWORK_PARAM_FILE_EXT_FINAL),parameterInformExt1);
        System.out.println("Файл успешно десериализован " + HOMEWORK_RESULT_PARAM_FILE_EXT + " в " + HOMEWORK_PARAM_FILE_EXT_FINAL);


            //дессериализатор Serializable
        JsonParameterSerializeReader ReadSer = new JsonParameterSerializeReader();
        JsonFileClass parameterInformSer = ReadSer.customSerializeReader(HOMEWORK_RESULT_PARAM_FILE);
        ObjectMapper mapperSer1 = new ObjectMapper(); //буфер
        mapperSer1.writerWithDefaultPrettyPrinter().writeValue(new File(HOMEWORK_PARAM_FILE_SER_FINAL),parameterInformSer);
        System.out.println("Файл успешно десериализован " + HOMEWORK_RESULT_PARAM_FILE + " в " + HOMEWORK_PARAM_FILE_SER_FINAL);

        /**
         * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
         * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
         * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
         * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
         * совпадают с homework.parameters.json
         * */

        if(CompareObjects.CompareJson(HOMEWORK_PARAM_FILE,HOMEWORK_PARAM_FILE_SER_FINAL)&&
                CompareObjects.CompareJson(HOMEWORK_PARAM_FILE,HOMEWORK_PARAM_FILE_EXT_FINAL)){
            System.out.println("Файлы совпадают!");}
        else {System.out.println("Файлы не совпадают!");}

    }











}
