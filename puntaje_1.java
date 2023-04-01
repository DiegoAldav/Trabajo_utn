package Programa;

import trabajoIntegrador.Equipo;
import trabajoIntegrador.Partido;
import trabajoIntegrador.Pronostico;
import trabajoIntegrador.Ronda;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puntaje {

    /**
     * @param args
     *
     *
     *
     */


    public static void main(String[] args) throws Exception {

        String archivo = "/home/mustafa/trabajoIntegrador/resultados.csv";

        /*for (String linea : Files.readAllLines(Paths.get(archivo))) {
            System.out.println(linea);
        }*/

        List<String> idpartidos = Files.readAllLines(Paths.get(archivo));

        String[] id1 = idpartidos.get(1).split(",");
        System.out.println(id1[1] + " vs " + id1[4]);


        Equipo equip1 = new Equipo(id1[1], "");
        Equipo equip2 = new Equipo(id1[4], "");

        int eg1 = Integer.parseInt(id1[2]);
        int eg2 = Integer.parseInt(id1[3]);

        Partido partido1 = new Partido(equip1, equip2, eg1, eg2);

        System.out.println("partido 1 "+partido1.resultado(equip2));

        // aca lo hago con la linea 6

        String[] id6 = idpartidos.get(6).split(",");


        Equipo equip11 = new Equipo(id6[1], "");
        Equipo equip12 = new Equipo(id6[4], "");

        int eg11 = Integer.parseInt(id6[2]);
        int eg12 = Integer.parseInt(id6[3]);

        Partido partido6 = new Partido(equip11, equip12, eg11, eg12);


        System.out.println(partido6.resultado(equip11));
        System.out.println(partido6.getEquipo1());


        //////////////////////////////

        //    PRONOSTICOS
        System.out.println("PRONOSTICOS");

        String archivo1 = "/home/mustafa/trabajoIntegrador/pronostico.csv";

        List<String> idpronosticos = Files.readAllLines(Paths.get(archivo1));

        String[] idp1 = idpronosticos.get(1).split(",");

         /*for (String linea : Files.readAllLines(Paths.get(archivo1))) {
            System.out.println(linea);
        }*/

        System.out.println(idp1[1] + " vs " + idp1[5]);

        Equipo equipopron1 = new Equipo(idp1[1], "");
        Equipo equipopron2 = new Equipo(idp1[5], "");

        String[] idp6 = idpronosticos.get(6).split(",");

        Equipo equipopron11 = new Equipo(idp6[1], "");
        Equipo equipopron12 = new Equipo(idp6[5], "");

        //int egp1 = Integer.parseInt(idp1[2]);
        //int egp2 = Integer.parseInt(idp1[4]);
        int egp1 = 0;
        int egp2 = 0;
        if (idp1[2] != "") {
            egp1 = 1;
            egp2 = 0;
        } else if (idp1[4] != "") {
            egp1 = 0;
            egp2 = 1;
        } else if (idp1[3] != "") {
            egp1 = 0;
            egp2 = 0;
        } else {
            return ;
        }

        int egp11 = 0;
        int egp12 = 0;
        if (idp6[2] != "") {
            egp11 = 1;
            egp12 = 0;
        } else if (idp6[4] != "") {
            egp11 = 0;
            egp12 = 1;
        } else if (idp6[3] != "") {
            egp11 = 0;
            egp12 = 0;
        } else {
            return ;
        }



        Partido partidopron1 = new Partido(equipopron1,equipopron2,egp1,egp2);

        Partido partidopron6 = new Partido(equipopron11,equipopron12,egp11,egp12);

        Pronostico pronostico1 = new Pronostico(partidopron1,equipopron1,partidopron1.resultado(equipopron1));

        Pronostico pronostico2 = new Pronostico(partido1,equip1,partidopron1.resultado(equipopron1));

        Pronostico pronostico6 = new Pronostico(partido6,equip11,partidopron6.resultado(equipopron11));




        System.out.println("partido " + idp1[1]);

        System.out.println(partidopron1.resultado(equipopron2));

        System.out.println("puntos "+pronostico2.puntos());

        System.out.println("puntos partido 6: "+pronostico6.puntos());



    }

}
