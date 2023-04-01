package trabajoIntegrador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import Enum.Resultado;

public class Ronda {

    public static void main(String[] args) throws Exception {
        String archivo = "/home/mustafa/trabajoIntegrador/resultados.csv";

        /*for (String linea : Files.readAllLines(Paths.get(archivo))) {
            System.out.println(linea);
        }*/

        List<String> idpartidos = Files.readAllLines(Paths.get(archivo));

        //String[] id1 = idpartidos.get(1).split(",");
        int s1 = -1;
        int s2 = 0;

        //   PRONOSTICOS

        String archivo1 = "/home/mustafa/trabajoIntegrador/pronostico.csv";

        List<String> idpronosticos = Files.readAllLines(Paths.get(archivo1));

        int puntosJugador1 = 0;


        for (int x = 1; x < idpartidos.size(); x++) {
            String[] idx = idpartidos.get(x).split(",");
            System.out.println(idx[1] + " vs " + idx[4]);

            if(true) {s1+=2;}
            if (true) {s2+=2;}

            Equipo equips1 = new Equipo(idx[1], "");
            Equipo equips2 = new Equipo(idx[4], "");

            //System.out.println(equips1.getNombre());
            //System.out.println(equips2.getNombre());

            int egs1 = Integer.parseInt(idx[2]);
            int egs2 = Integer.parseInt(idx[3]);

            //System.out.print(egs1+" vs ");
            //System.out.println(egs2);

            Partido partidox = new Partido(equips1, equips2, egs1, egs2);

            //System.out.println("partido "+x+" "+equips1.getNombre()+" "+partidox.resultado(equips1));


            //////////////////////////////////////////////////////
            //   PRONOSTICOS

            String[] idpx = idpronosticos.get(x).split(",");

            Equipo equipoprons1 = new Equipo(idpx[1], "");
            Equipo equipoprons2 = new Equipo(idpx[5], "");

            //System.out.println(equipoprons1.getNombre()+" contra "+equipoprons2.getNombre());

            int egps1 = 0;
            int egps2 = 0;
            if (idpx[2] != "") {
                egps1 = 1;
                egps2 = 0;
            } else if (idpx[4] != "") {
                egps1 = 0;
                egps2 = 1;
            } else if (idpx[3] != "") {
                egps1 = 0;
                egps2 = 0;
            } else {
                return ;
            }

            Partido partidopronx = new Partido(equipoprons1,equipoprons2,egps1,egps2);

            Pronostico pronosticox = new Pronostico(partidox,equips1,partidopronx.resultado(equipoprons1));

            System.out.println("puntos "+pronosticox.puntos());

            puntosJugador1 += pronosticox.puntos();



        }

        System.out.println("puntos jugador 1: "+puntosJugador1);


        /*System.out.println(id1[1] + " vs " + id1[4]);

        System.out.println("largo: "+idpartidos.size());


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
        }*//*

        System.out.println(idp1[1] + " vs " + idp1[5]);

        Equipo equipopron1 = new Equipo(idp1[1], "");
        Equipo equipopron2 = new Equipo(idp1[5], "");

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

        Partido partidopron1 = new Partido(equipopron1,equipopron2,egp1,egp2);

        Pronostico pronostico1 = new Pronostico(partidopron1,equipopron1,partidopron1.resultado(equipopron1));

        Pronostico pronostico2 = new Pronostico(partido1,equip1,partidopron1.resultado(equipopron1));




        System.out.println("partido " + idp1[1]);

        System.out.println(partidopron1.resultado(equipopron2));

        System.out.println("puntos "+pronostico2.puntos());


*/
    }



}
