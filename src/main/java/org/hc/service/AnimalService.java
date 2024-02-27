package org.hc.service;

import org.apache.commons.lang3.StringUtils;
import org.hc.model.Animal;
import org.hc.utils.Sexo;
import org.hc.utils.TipoAnimal;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    public static void Animales () throws IOException {
        // Ruta al archivo CSV
        String filePath = "csv/animales.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";

        //"id","lnk_idcliente","trial_lnk_idtipanimal_3","nombre","numtarsani","fechanaci","raza","observaci","sexo","historico","color"
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/dogodb.db");
            String queryInsert = "INSERT INTO Animales (id, idCliente, idTipoAnimal, nombre, nMicrochip, fNacimiento, raza, observacion, sexo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println("INICIAMOS LECTURA AnimalService");

            while ((line = br.readLine()) != null) {

                String[] datos = line.split(cvsSplitBy);

                Animal animal = new Animal(); // Ajusta según campos
                animal.setId(Integer.parseInt(datos[0]));
                animal.setIdCliente(Integer.parseInt(datos[1]));
                animal.setIdTipoAnimal(TipoAnimal.obtainTipoAnimal((datos[2].replaceAll("\"+", ""))));
                animal.setNombre(datos[3].replaceAll("\"+", ""));
                if(!StringUtils.isBlank(datos[4])){
                    if(!verifyValue(datos[4].replaceAll("\"+", ""))){
                        animal.setnMicrochip(datos[4].replaceAll("\"+", ""));
                    }else{
                        animal.setnMicrochip(datos[0]);
                    }
                }else{
                    animal.setnMicrochip(datos[0]);
                }
                animal.setfNacimiento(datos[5]);
                animal.setRaza(datos[6].replaceAll("\"+", ""));
                animal.setObservacion(datos[7].concat(datos[9].replaceAll("\"+", "")).concat(" color : ".concat(datos[10].replaceAll("\"+", ""))));
                if(!StringUtils.isBlank(datos[8])){
                    animal.setSexo(Sexo.obtainNewSex(datos[8].replaceAll("\"+", "")));
                }
                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {

                    preparedStatement.setString(1, String.valueOf(animal.getId()));
                    preparedStatement.setString(2, String.valueOf(animal.getIdCliente()));
                    preparedStatement.setString(3, String.valueOf(animal.getIdTipoAnimal()));
                    preparedStatement.setString(4, animal.getNombre());
                    preparedStatement.setString(5, animal.getnMicrochip());
                    preparedStatement.setString(6, animal.getfNacimiento());
                    preparedStatement.setString(7, animal.getRaza());
                    preparedStatement.setString(8, animal.getObservacion().replaceAll("\"+", "").replaceAll("\"\"+", ""));
                    preparedStatement.setString(9, String.valueOf(animal.getSexo()));
                    //Preparar los statement
                    preparedStatement.executeUpdate();
                }
            }
            connection.close();
            System.out.println("CERRAMOS CONEXION AnimalService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean verifyValue(String dato) {
        try {
            if(evaluateDuplicate(dato)){
                return true;
            }
            else{
                if (Integer.parseInt(dato) == 0){
                    return true;
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            return false;
        }
    }

    private static boolean evaluateDuplicate(String dato) {
        List<String> listDuplicados = new ArrayList<>();
        listDuplicados.add("977200001164469");
        listDuplicados.add("4079003679");
        listDuplicados.add("977200005420594");
        listDuplicados.add("977200000499165");
        listDuplicados.add("111662640A");
        listDuplicados.add("120968213A");
        listDuplicados.add("953000000213666");
        listDuplicados.add("977200000764425");
        listDuplicados.add("977200004451619");
        listDuplicados.add("400D7D2F67");
        listDuplicados.add("985100010253486");
        listDuplicados.add("116319761A");
        listDuplicados.add("977200001328785");
        listDuplicados.add("977200005025636");
        listDuplicados.add("977200004744238");
        listDuplicados.add("724098100315497");
        listDuplicados.add("1F34447277");
        listDuplicados.add("4079343337");
        listDuplicados.add("20055C453A");
        listDuplicados.add("977200000697016");
        listDuplicados.add("406641003C");
        listDuplicados.add("1F2E687D4E");
        listDuplicados.add("111754565A");
        listDuplicados.add("4115266509");
        listDuplicados.add("985100006179716");
        listDuplicados.add("20284B6607");
        listDuplicados.add("41404E6341");
        listDuplicados.add("977200000697017");
        listDuplicados.add("202A1D2673");
        listDuplicados.add("724098101137922");
        listDuplicados.add("977200001489577");
        listDuplicados.add("724098100448725");
        listDuplicados.add("977200001292686");
        listDuplicados.add("1F21686C6C");
        listDuplicados.add("977200000717969");
        listDuplicados.add("724098101023301");
        listDuplicados.add("977200004961286");
        listDuplicados.add("977200005028109");
        listDuplicados.add("1F53582C0A");
        listDuplicados.add("N27728032");
        listDuplicados.add("116347371A");
        listDuplicados.add("115466591A");
        listDuplicados.add("977200001699066");
        listDuplicados.add("250269800283863");
        listDuplicados.add("977200001184362");
        listDuplicados.add("977200000738138");
        listDuplicados.add("1F2D583824");
        listDuplicados.add("1f2d583824");
        listDuplicados.add("982009100635465");
        listDuplicados.add("967000000264417");
        listDuplicados.add("724098100315001");
        listDuplicados.add("985120015598503");
        listDuplicados.add("953000000274748");
        listDuplicados.add("977200004600637");
        listDuplicados.add("985100009577946");
        listDuplicados.add("977200004499226");
        listDuplicados.add("977200005415669");
        listDuplicados.add("985100009624624");
        listDuplicados.add("528140001062561");
        listDuplicados.add("977200001067987");
        listDuplicados.add("977200001348561");
        listDuplicados.add("977200001238912");
        listDuplicados.add("985100009776070");
        listDuplicados.add("985120021857458");
        listDuplicados.add("941000000451159");
        listDuplicados.add("111552733A");
        listDuplicados.add("977200001238910");
        listDuplicados.add("985100010292684");
        listDuplicados.add("985100010097767");
        listDuplicados.add("981098100329554");
        listDuplicados.add("724098101023302");
        listDuplicados.add("941000012670093");
        listDuplicados.add("941000000496796");
        listDuplicados.add("9850000608809");
        listDuplicados.add("985120009011370");
        listDuplicados.add("982009104356616");
        listDuplicados.add("977200004420861");
        listDuplicados.add("977200000696419");
        listDuplicados.add("985100005860919");
        listDuplicados.add("724098100343371");
        listDuplicados.add("941000000298195");
        listDuplicados.add("941000000855556");
        listDuplicados.add("977200004663037");
        listDuplicados.add("985100006663611");
        listDuplicados.add("34098190019811");
        listDuplicados.add("941000001948555");
        listDuplicados.add("981098100342447");
        listDuplicados.add("977200004122233");
        listDuplicados.add("977200004339779");
        listDuplicados.add("982009100571847");
        listDuplicados.add("985100008449758");
        listDuplicados.add("941000000289445");
        listDuplicados.add("202A0F190E");
        listDuplicados.add("977200005566084");
        listDuplicados.add("977200000857389");
        listDuplicados.add("941000000964653");
        listDuplicados.add("941000002133607");
        listDuplicados.add("977200004451969");
        listDuplicados.add("982009104333300");
        listDuplicados.add("406671411D");
        listDuplicados.add("221A573F2F");
        listDuplicados.add("977200007328050");
        listDuplicados.add("941000002816836");
        listDuplicados.add("941000001918009");
        listDuplicados.add("985100010194412");
        listDuplicados.add("977200007581696");
        listDuplicados.add("977200001083019");
        listDuplicados.add("985120022469312");
        listDuplicados.add("724098101163438");
        listDuplicados.add("985120030562831");
        listDuplicados.add("977200001404803");
        listDuplicados.add("981098102466860");
        listDuplicados.add("941000011496021");
        listDuplicados.add("412C3E792B");
        listDuplicados.add("982009104456183");
        listDuplicados.add("977200007290232");
        listDuplicados.add("941000011869958");
        listDuplicados.add("348098100153924");
        listDuplicados.add("977200007590630");
        listDuplicados.add("977200007456481");
        listDuplicados.add("977200007793706");
        listDuplicados.add("977200005054715");
        listDuplicados.add("977200000721440");
        listDuplicados.add("189900");
        listDuplicados.add("189901");
        listDuplicados.add("985100006933035");
        listDuplicados.add("985170000545666");
        listDuplicados.add("977200008205902");
        listDuplicados.add("941000002199713");
        listDuplicados.add("977200007779877");
        listDuplicados.add("977200007793708");
        listDuplicados.add("938000000175973");
        listDuplicados.add("977200004461197");
        listDuplicados.add("977200007456479");
        listDuplicados.add("977200005619361");
        listDuplicados.add("250268720019089");
        listDuplicados.add("981098102750360");
        listDuplicados.add("941000013770306");
        listDuplicados.add("985120023432783");
        listDuplicados.add("941000000348365");
        listDuplicados.add("900176000054804");
        listDuplicados.add("977200007651528");
        listDuplicados.add("941000014180467");
        listDuplicados.add("900032001594076");
        listDuplicados.add("900032001835350");
        listDuplicados.add("941000002907450");
        listDuplicados.add("982009104987150");
        listDuplicados.add("941000013504206");
        listDuplicados.add("900032002322059");
        listDuplicados.add("981098104457898");
        listDuplicados.add("967000009628137");
        listDuplicados.add("941000012670096");
        listDuplicados.add("977200008514310");
        listDuplicados.add("978000000796616");
        listDuplicados.add("900032002322062");
        listDuplicados.add("985170001172677");
        listDuplicados.add("985170001213921");
        listDuplicados.add("981098102680599");
        listDuplicados.add("985120030062033");
        listDuplicados.add("250269602166286");
        listDuplicados.add("985170002835780");
        listDuplicados.add("941000001643780");
        listDuplicados.add("941000017044973");
        listDuplicados.add("941000015759138");
        listDuplicados.add("941000021370015");
        listDuplicados.add("981098106029347");
        listDuplicados.add("941000013156460");
        listDuplicados.add("991001000953228");
        listDuplicados.add("941000021185050");
        listDuplicados.add("941000021185046");
        listDuplicados.add("941000011444067");
        listDuplicados.add("941000014780720");
        listDuplicados.add("981098104356547");
        listDuplicados.add("900182001016913");
        listDuplicados.add("941000013182046");
        listDuplicados.add("941000013182044");
        listDuplicados.add("991001000583746");
        listDuplicados.add("991001000583745");
        listDuplicados.add("900182000860776");
        listDuplicados.add("941000021913697");
        listDuplicados.add("982009106518878");
        listDuplicados.add("900164001285495");
        listDuplicados.add("900164001529518");
        listDuplicados.add("981098106010952");
        listDuplicados.add("985113000472697");
        listDuplicados.add("977200007273249");
        listDuplicados.add("941000002213081");
        listDuplicados.add("981098104258720");
        listDuplicados.add("642090001039511");
        listDuplicados.add("982009105716838");
        listDuplicados.add("981098106018127");
        listDuplicados.add("941000023672330");
        listDuplicados.add("981098106786961");
        listDuplicados.add("941000018400158");
        listDuplicados.add("977200007328214");
        listDuplicados.add("981098106786962");
        listDuplicados.add("941000013777634");
        listDuplicados.add("978101082104733");
        listDuplicados.add("967000010268448");
        listDuplicados.add("941000019294318");
        listDuplicados.add("978101082603227");
        listDuplicados.add("941000026293297");
        listDuplicados.add("900215000804650");
        listDuplicados.add("967000010118879");
        listDuplicados.add("941000024389209");
        listDuplicados.add("941000022535279");
        listDuplicados.add("941000025532793");
        listDuplicados.add("941000019079455");
        listDuplicados.add("941000024389207");
        listDuplicados.add("941000023672333");
        listDuplicados.add("900133000154232");
        listDuplicados.add("992000000725772");
        listDuplicados.add("941010000367255");
        listDuplicados.add("941000022535276");
        listDuplicados.add("941000026691316");
        listDuplicados.add("981098102796642");
        listDuplicados.add("941000026243323");
        listDuplicados.add("941000025706219");
        listDuplicados.add("941000019363842");
        listDuplicados.add("977200004939597");
        listDuplicados.add("7F7B204061");
        listDuplicados.add("977200001362588");
        listDuplicados.add("977200009090116");
        listDuplicados.add("985170001623820");
        listDuplicados.add("977200001506497");
        listDuplicados.add("938000000727796");
        listDuplicados.add("0977200004451619");
        listDuplicados.add("0977200001699066");
        listDuplicados.add("0977200001506497");
        listDuplicados.add("0977200001489577");
        listDuplicados.add("0977200001362588");
        listDuplicados.add("0977200004461197");
        listDuplicados.add("0977200001292686");
        //listDuplicados.add("");
        //listDuplicados.add("");
        //listDuplicados.add("");
        //listDuplicados.add("");
        //listDuplicados.add("");
        for(String id : listDuplicados){
            if(dato.equals(id)){
                return true;
            }
        }
        return false;
    }
}